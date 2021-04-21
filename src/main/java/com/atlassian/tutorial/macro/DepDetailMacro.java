package com.atlassian.tutorial.macro;

import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.tutorial.constant.Urls;
import com.atlassian.tutorial.utils.MacroHttpClient;
import com.atlassian.tutorial.vo.DetailVo;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@Scanned
public class DepDetailMacro implements Macro {
    private static final Logger log = LoggerFactory.getLogger(SearchDepMacro.class);

    @Override
    public String execute(Map<String, String> map, String s, ConversionContext conversionContext) throws MacroExecutionException {
        JsonParser parser = new JsonParser();
        Map context = MacroUtils.defaultVelocityContext();
        String depUrl = map.get("详情地址");
        ConnectionDepResult connectionDepResult = new ConnectionDepResult<DetailVo>();
        try {
            if (depUrl == null) {
                connectionDepResult.setSuccess(false);
                connectionDepResult.setMessage("详情地址不能为空，目前支持详情链接："+ Urls.DEP_TASK_DETAIL_PAGE_URL +  "，" + Urls.DEP_BUG_DETAIL_PAGE_URL+"，"+Urls.DEP_DEMAND_DETAIL_PAGE_URL);
            } else if (depUrl.startsWith(Urls.DEP_TASK_DETAIL_PAGE_URL)  || depUrl.startsWith(Urls.DEP_BUG_DETAIL_PAGE_URL)||depUrl.startsWith(Urls.DEP_DEMAND_DETAIL_PAGE_URL)) {
                List<NameValuePair> list = URLEncodedUtils.parse(depUrl.split("\\?")[1], Charset.forName("UTF-8"));
                String detailId = "";
                for (NameValuePair one : list) {
                    if (one.getName().equals("id")) {
                        detailId = one.getValue();
                        break;
                    }
                }
                String detailRequest = Urls.DEP_SEARCH_ALL_API + "?id=" + detailId;
                String detailJsonStr = MacroHttpClient.HttpGetString(detailRequest);
                DetailVo detailVo = new Gson().fromJson(parser.parse(detailJsonStr).getAsJsonArray().get(0),DetailVo.class);
                if(detailVo.getType().equals("requirement")){
                    detailVo.setType("demand");
                }
                connectionDepResult.setData(detailVo);
                connectionDepResult.setSuccess(true);

            } else {
                connectionDepResult.setSuccess(false);
                connectionDepResult.setMessage("格式不符合要求，目前支持：" + Urls.DEP_TASK_DETAIL_PAGE_URL +  "，" + Urls.DEP_BUG_DETAIL_PAGE_URL+"，"+Urls.DEP_DEMAND_DETAIL_PAGE_URL);
            }
        }catch (Exception e){
            connectionDepResult.setSuccess(false);
            connectionDepResult.setMessage(ExceptionUtils.getStackTrace(e));
        }
        context.put("connectionDepResult",connectionDepResult);
        connectionDepResult.setDomain(Urls.DEP_DOMAIN);
        return VelocityUtils.getRenderedTemplate("templates/detail-dep.vm", context);
    }

    @Override
    public BodyType getBodyType() {
        return BodyType.NONE;
    }

    @Override
    public OutputType getOutputType() {
        return OutputType.BLOCK;
    }
}
