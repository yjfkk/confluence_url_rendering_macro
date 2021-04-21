package com.atlassian.tutorial.macro;

import bucket.core.actions.PaginationSupport;
import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.tutorial.constant.FieldConfig;
import com.atlassian.tutorial.constant.Urls;
import com.atlassian.tutorial.utils.MacroHttpClient;
import com.atlassian.tutorial.vo.DetailVo;
import com.google.gson.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.*;

@Scanned
public class SearchDepMacro implements Macro {
    private static final Logger log = LoggerFactory.getLogger(SearchDepMacro.class);

    @Override
    public String execute(Map<String, String> map, String s, ConversionContext conversionContext) throws MacroExecutionException {

        PaginationSupport paginationSupport = new PaginationSupport();
        ConnectionDepResult connectionDepResult = new ConnectionDepResult<List>();
        Map context = MacroUtils.defaultVelocityContext();
        JsonParser parser = new JsonParser();
        String keyword = map.get("标题关键字");
        String depUrl = map.get("DEP搜索链接");

        try {
            if (keyword == null && depUrl == null) {
                connectionDepResult.setSuccess(false);
                connectionDepResult.setMessage("标题关键字，DEP链接不能都为空。目前【dep搜索链接】支持：http://dep.vdian.net/#/search和http://dep.vdian.net/#/search?searchFilterId=137 ");
            } else if (keyword != null && depUrl != null) {
                connectionDepResult.setSuccess(false);
                connectionDepResult.setMessage("标题关键字，DEP链接不能同时填写");
            }
            //关键字查询
            else if (keyword != null) {
                String url = Urls.DEP_SEARCH_ALL_API+"?name="+keyword;
                HttpResponse response = MacroHttpClient.HttpGetResponese(url);
                int total = Integer.valueOf(response.getHeaders("X-Total-Count")[0].getValue());
                String resultString = IOUtils.toString(response.getEntity().getContent());
                JsonElement tradeElement = parser.parse(resultString);
                JsonArray data = tradeElement.getAsJsonArray();
                List<JsonObject> items = new ArrayList<>();
                for (JsonElement one : data) {
                    items.add(this.addRequirementName(one));
                }
                paginationSupport.setPageSize(20);
                paginationSupport.setItems(items);
                paginationSupport.setStartIndex(0);
                context.put("paginationSupport", paginationSupport);
                connectionDepResult.setTotal(total);
                connectionDepResult.setQuery("name="+keyword);
                connectionDepResult.setSuccess(true);
            }
            //url 支持类型：http://dep.vdian.net/#/search?name=test&searchFrom=navigation、http://dep.vdian.net/#/search?searchFilterId=136
            else if (depUrl != null) {
                if (depUrl.startsWith(Urls.DEP_SEARCH_PAGE_URL)) {
                    List<NameValuePair> list = URLEncodedUtils.parse(depUrl.split("\\?")[1], Charset.forName("UTF-8"));
                    boolean isFilter = false;
                    String filterId = "";
                    for (NameValuePair one : list) {
                        if (one.getName().equals("searchFilterId")) {
                            isFilter = true;
                            filterId = one.getValue();
                            break;
                        }
                    }
                    //过滤器处理
                    if(isFilter) {
                        //获取过滤条件
                        String getFilterDetailurl = String.format(Urls.DEP_Filter_DETAIL_API, filterId);
                        String rep = MacroHttpClient.HttpGetString(getFilterDetailurl);
                        JsonElement tradeElement = parser.parse(rep);
                        String searchValue = tradeElement.getAsJsonObject().get("searchValue").getAsString();
                        //获取反馈内容
                        String searchUrl = Urls.DEP_SEARCH_ALL_API+"?"+searchValue;
                        HttpResponse response = MacroHttpClient.HttpGetResponese(searchUrl);
                        int total = Integer.valueOf(response.getHeaders("X-Total-Count")[0].getValue());
                        String resultString = IOUtils.toString(response.getEntity().getContent());
                        JsonElement newElement = parser.parse(resultString);
                        JsonArray data = newElement.getAsJsonArray();
                        List<JsonObject> items = new ArrayList<>();
                        for (JsonElement one : data) {
                            items.add(this.addRequirementName(one));
                        }
                        paginationSupport.setPageSize(20);
                        paginationSupport.setItems(items);
                        paginationSupport.setStartIndex(0);
                        context.put("paginationSupport", paginationSupport);
                        connectionDepResult.setTotal(total);
                        connectionDepResult.setQuery(searchValue);
                        connectionDepResult.setSuccess(true);
                        connectionDepResult.setFilterId(filterId);
                        connectionDepResult.setExpandColumns(this.initExpandColumns(searchUrl));
                    }
                    //非过滤器处理
                    else{
                        String quereStr = depUrl.split("\\?")[1];
                        String searchUrl = Urls.DEP_SEARCH_ALL_API+"?"+quereStr;
                        HttpResponse response = MacroHttpClient.HttpGetResponese(searchUrl);
                        int total = Integer.valueOf(response.getHeaders("X-Total-Count")[0].getValue());
                        String resultString = IOUtils.toString(response.getEntity().getContent());
                        JsonElement newElement = parser.parse(resultString);
                        JsonArray data = newElement.getAsJsonArray();
                        List<JsonObject> items = new ArrayList<>();
                        for (JsonElement one : data) {
                            items.add(this.addRequirementName(one));
                        }
                        paginationSupport.setPageSize(20);
                        paginationSupport.setItems(items);
                        paginationSupport.setStartIndex(0);
                        context.put("paginationSupport", paginationSupport);
                        connectionDepResult.setTotal(total);
                        connectionDepResult.setQuery(quereStr);
                        connectionDepResult.setSuccess(true);
                        connectionDepResult.setExpandColumns(this.initExpandColumns(depUrl));
                    }
                }
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            connectionDepResult.setSuccess(false);
            connectionDepResult.setMessage(ExceptionUtils.getStackTrace(e));
        }
        connectionDepResult.setDepUrl(depUrl);
        connectionDepResult.setDomain(Urls.DEP_DOMAIN);

        context.put("connectionDepResult", connectionDepResult);
        return VelocityUtils.getRenderedTemplate("templates/connection-dep.vm", context);
    }

    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }

    private LinkedHashMap<String,String> initExpandColumns(String url) {
        JsonParser parser = new JsonParser();
        JsonObject expandColumns = parser.parse(FieldConfig.EXPAND_Columns_ALL).getAsJsonObject();
        JsonObject moreTypeParms = parser.parse(FieldConfig.MORE_TYPE_PARAMS).getAsJsonObject();
        String quereStr = url.split("\\?")[1];
        String[] parms = quereStr.split("&");
        LinkedHashMap columnsMap = new LinkedHashMap<String,String>();
        for (String parm : parms) {
            String fieldName = parm.split("=")[0];
            if(expandColumns.get(fieldName)!=null&&!expandColumns.isJsonNull()){
                columnsMap.put(fieldName,expandColumns.get(fieldName).getAsString());
            }else if(moreTypeParms.get(fieldName)!=null &&!moreTypeParms.isJsonNull()){
                String replaceField = moreTypeParms.get(fieldName).getAsString();
                columnsMap.put(replaceField,expandColumns.get(replaceField).getAsString());
            }
        }
        return columnsMap;
    }

    private JsonObject addRequirementName(JsonElement jsonElement){
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement fieldRequirements = jsonObject.get("requirements");
        if (fieldRequirements!=null && !fieldRequirements.isJsonNull()){
            ArrayList requirementsNameArr = new ArrayList();
            JsonArray fielRequirementsObjects = fieldRequirements.getAsJsonArray();
            for(JsonElement one:fielRequirementsObjects) {
                JsonObject fielRequirementsObject = one.getAsJsonObject();
                String requirementsName = fielRequirementsObject.get("name").getAsString();
                requirementsNameArr.add(requirementsName);
            }
            jsonObject.addProperty("requirementsName", String.join(",",requirementsNameArr));
        }
        return jsonObject;
    }

}
