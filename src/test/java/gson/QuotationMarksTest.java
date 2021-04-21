package gson;

import com.atlassian.tutorial.constant.FieldConfig;
import com.atlassian.tutorial.constant.Urls;
import com.atlassian.tutorial.utils.MacroHttpClient;
import com.atlassian.tutorial.vo.DetailVo;
import com.google.gson.*;
import org.apache.http.HttpResponse;
import org.junit.Test;

import java.util.LinkedHashMap;


public class QuotationMarksTest {
    //@Test
    public void test_01(){
        String jsonText ="[{\"projectName\":\"群群项目1\",\"creatorDisplayName\":\"刘群群\",\"updateorDisplayName\":\"宋珂\",\"pm\":null,\"pmDisplayName\":null,\"projectId\":59,\"iterationId\":27,\"status\":\"处理中\",\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"name\":\"测试任务\",\"detailId\":7,\"processor\":\"songke\",\"priority\":\"P3\",\"creator\":\"liuqunqun\",\"completeTime\":null,\"updateor\":\"songke\",\"iterationName\":\"迭代3\",\"verifierDisplayName\":null,\"isValid\":true,\"nodeBuildId\":0,\"statusUpdateTime\":\"2020-11-17 15:40:32\",\"dateCreated\":\"2019-11-15 13:53:38\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"updateTime\":\"2020-11-17 15:40:32\",\"nodeId\":0,\"type\":\"task\",\"id\":18},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"dateCreated\":\"2019-11-20 09:52:11\",\"verifier\":null,\"updateTime\":\"2020-06-06 21:11:22\",\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"detailId\":26,\"name\":\"这是一个测试需求222\",\"completeTime\":null,\"updateor\":\"songke\",\"statusUpdateTime\":\"2020-06-06 21:11:22\",\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"废弃\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":46},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"updateTime\":\"2020-06-06 21:11:22\",\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"name\":\"测试任务一\",\"processor\":\"songke\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"completeTime\":null,\"updateor\":\"songke\",\"statusUpdateTime\":\"2020-06-06 21:11:22\",\"detailId\":23,\"verifierDisplayName\":null,\"isValid\":true,\"nodeBuildId\":0,\"dateCreated\":\"2019-11-20 10:07:12\",\"status\":\"废弃\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"type\":\"task\",\"id\":50},{\"projectId\":63,\"creatorDisplayName\":\"郭启龙\",\"updateorDisplayName\":\"郭启龙\",\"pm\":null,\"completeTime\":\"2019-11-26 14:16:23\",\"pmDisplayName\":null,\"updateTime\":\"2019-11-26 14:16:23\",\"processorDisplayName\":\"郭倩红\",\"verifier\":null,\"dateCreated\":\"2019-11-20 14:37:42\",\"statusUpdateorDisplayName\":\"郭启龙\",\"priority\":\"P3\",\"statusUpdateTime\":\"2019-11-26 14:16:23\",\"statusUpdateor\":\"guoqilong\",\"detailId\":81,\"name\":\"测试2\",\"iterationName\":\"迭代2\",\"verifierDisplayName\":null,\"creator\":\"guoqilong\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"完成\",\"processor\":\"guoqianhong\",\"type\":\"bug\",\"nodeId\":0,\"iterationId\":33,\"projectName\":\"郭启龙测试11\",\"updateor\":\"guoqilong\",\"id\":117},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"statusUpdateTime\":\"2019-11-25 11:45:31\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":30,\"pm\":null,\"pmDisplayName\":null,\"status\":\"处理中\",\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"dateCreated\":\"2019-11-20 15:20:32\",\"detailId\":27,\"iterationName\":\"这是一个测试迭代111\",\"completeTime\":null,\"updateor\":\"songke\",\"verifierDisplayName\":null,\"name\":\"这是一个测试任务\",\"updateTime\":\"2019-11-25 11:48:24\",\"isValid\":true,\"nodeBuildId\":0,\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"type\":\"task\",\"id\":126},{\"creator\":\"songke\",\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationName\":\"无迭代\",\"pm\":null,\"pmDisplayName\":null,\"statusUpdateTime\":\"2019-11-25 15:28:52\",\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"priority\":\"P3\",\"completeTime\":\"2019-11-25 15:28:52\",\"updateTime\":\"2019-11-25 15:28:52\",\"detailId\":90,\"updateor\":\"songke\",\"iterationId\":0,\"verifierDisplayName\":null,\"isValid\":true,\"processor\":\"guoqilong\",\"nodeBuildId\":0,\"status\":\"完成\",\"statusUpdateor\":\"songke\",\"dateCreated\":\"2019-11-20 15:23:39\",\"projectName\":\"效能平台调试项目\",\"name\":\"测试任务，完成时候的二次弹框，无法录入测试记录，common/getTestLinkInfo?type=planPlatforms，500\",\"processorDisplayName\":\"郭启龙\",\"type\":\"bug\",\"nodeId\":0,\"projectId\":64,\"id\":127},{\"projectId\":63,\"creatorDisplayName\":\"郭启龙\",\"updateorDisplayName\":\"郭启龙\",\"iterationName\":\"无迭代\",\"pm\":null,\"pmDisplayName\":null,\"dateCreated\":\"2019-11-20 17:27:11\",\"verifier\":null,\"status\":\"待处理\",\"priority\":\"P3\",\"completeTime\":null,\"name\":\"测试3\",\"iterationId\":0,\"verifierDisplayName\":null,\"creator\":\"guoqilong\",\"isValid\":true,\"statusUpdateorDisplayName\":null,\"processor\":\"guoqilong\",\"statusUpdateTime\":\"2019-11-20 17:27:11\",\"detailId\":34,\"nodeBuildId\":0,\"statusUpdateor\":null,\"processorDisplayName\":\"郭启龙\",\"nodeId\":0,\"projectName\":\"郭启龙测试11\",\"updateTime\":\"2019-11-20 17:27:11\",\"updateor\":\"guoqilong\",\"type\":\"task\",\"id\":137},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"completeTime\":\"2019-11-25 15:16:20\",\"processor\":\"songke\",\"updateTime\":\"2019-11-25 15:16:20\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"statusUpdateTime\":\"2019-11-25 15:16:20\",\"updateor\":\"songke\",\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"dateCreated\":\"2019-11-20 20:44:24\",\"detailId\":35,\"nodeBuildId\":0,\"status\":\"完成\",\"statusUpdateor\":\"songke\",\"name\":\"这是一个测试需求111\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":158},{\"dateCreated\":\"2019-11-20 20:50:44\",\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"statusUpdateTime\":\"2019-11-20 20:53:39\",\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"updateor\":\"songke\",\"verifierDisplayName\":null,\"completeTime\":\"2019-11-20 20:53:39\",\"detailId\":41,\"name\":\"测试需求111的视觉任务\",\"updateTime\":\"2019-11-29 20:08:25\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"完成\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"type\":\"task\",\"id\":160},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"completeTime\":\"2019-11-22 18:33:40\",\"projectName\":\"宋珂测试项目1\",\"updateTime\":\"2019-11-25 15:24:51\",\"processor\":\"songke\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"name\":\"测试任务关联的需求-1\",\"updateor\":\"songke\",\"statusUpdateTime\":\"2019-11-22 18:33:40\",\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"detailId\":36,\"status\":\"完成\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"dateCreated\":\"2019-11-20 22:30:27\",\"nodeId\":0,\"id\":162},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"dateCreated\":\"2019-11-20 22:34:21\",\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"completeTime\":\"2019-12-05 19:29:03\",\"updateTime\":\"2019-12-05 19:29:03\",\"processor\":\"songke\",\"priority\":\"P3\",\"name\":\"测试任务关联的需求-2\",\"iterationName\":\"视频测试-迭代\",\"statusUpdateTime\":\"2019-12-05 19:29:03\",\"updateor\":\"songke\",\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"detailId\":37,\"status\":\"完成\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":164},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"statusUpdateTime\":\"2019-11-22 22:09:53\",\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"name\":\"测试任务关联的需求-3\",\"updateor\":\"songke\",\"completeTime\":\"2019-11-22 22:09:53\",\"verifierDisplayName\":null,\"dateCreated\":\"2019-11-20 22:35:56\",\"updateTime\":\"2019-11-22 22:09:54\",\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"detailId\":38,\"status\":\"完成\",\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":165},{\"projectId\":63,\"creatorDisplayName\":\"郭启龙\",\"updateorDisplayName\":\"郭启龙\",\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"dateCreated\":\"2019-11-21 15:38:34\",\"statusUpdateorDisplayName\":\"郭启龙\",\"statusUpdateTime\":\"2019-11-21 15:40:19\",\"priority\":\"P3\",\"statusUpdateor\":\"guoqilong\",\"completeTime\":null,\"iterationName\":\"迭代3\",\"verifierDisplayName\":null,\"name\":\"测试\",\"detailId\":40,\"creator\":\"guoqilong\",\"type\":\"requirement\",\"isValid\":true,\"processor\":\"guoqilong\",\"nodeBuildId\":0,\"status\":\"废弃\",\"updateTime\":\"2019-11-21 15:38:34\",\"processorDisplayName\":\"郭启龙\",\"nodeId\":0,\"iterationId\":34,\"projectName\":\"郭启龙测试11\",\"updateor\":\"guoqilong\",\"id\":182},{\"updateTime\":\"2019-11-21 16:22:21\",\"projectId\":63,\"creatorDisplayName\":\"郭启龙\",\"updateorDisplayName\":\"郭启龙\",\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"dateCreated\":\"2019-11-21 16:18:35\",\"priority\":\"P3\",\"completeTime\":null,\"iterationName\":\"迭代2\",\"verifierDisplayName\":null,\"statusUpdateTime\":\"2019-11-21 16:18:35\",\"detailId\":45,\"creator\":\"guoqilong\",\"isValid\":true,\"statusUpdateorDisplayName\":null,\"processor\":\"guoqilong\",\"nodeBuildId\":0,\"statusUpdateor\":null,\"status\":\"废弃\",\"name\":\"需求关联测试任务\",\"processorDisplayName\":\"郭启龙\",\"nodeId\":0,\"iterationId\":33,\"projectName\":\"郭启龙测试11\",\"updateor\":\"guoqilong\",\"type\":\"task\",\"id\":188},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationId\":31,\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"iterationName\":\"视频测试-迭代\",\"name\":\"测试任务关联的需求-4\",\"updateor\":\"songke\",\"verifierDisplayName\":null,\"statusUpdateTime\":\"2019-11-25 15:19:43\",\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"完成\",\"completeTime\":\"2019-11-25 15:19:43\",\"updateTime\":\"2019-11-25 15:19:43\",\"statusUpdateor\":\"songke\",\"dateCreated\":\"2019-11-22 13:49:48\",\"processorDisplayName\":\"宋珂\",\"detailId\":50,\"nodeId\":0,\"id\":220},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationName\":\"无迭代\",\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"dateCreated\":\"2019-11-22 20:52:15\",\"processor\":\"songke\",\"priority\":\"P3\",\"completeTime\":null,\"name\":\"测试任务关联的需求-5\",\"updateor\":\"songke\",\"iterationId\":0,\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"updateTime\":\"2020-11-18 13:55:35\",\"nodeBuildId\":0,\"status\":\"废弃\",\"statusUpdateor\":\"songke\",\"detailId\":58,\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"statusUpdateTime\":\"2020-11-18 13:55:35\",\"id\":273},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationName\":\"无迭代\",\"pm\":null,\"pmDisplayName\":null,\"dateCreated\":\"2019-11-22 22:13:12\",\"verifier\":null,\"name\":\"测试需求1\",\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"completeTime\":null,\"updateor\":\"songke\",\"iterationId\":0,\"verifierDisplayName\":null,\"statusUpdateTime\":\"2020-11-18 13:56:32\",\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"废弃\",\"updateTime\":\"2020-11-18 13:56:32\",\"detailId\":59,\"statusUpdateor\":\"songke\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":278},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationName\":\"无迭代\",\"pm\":null,\"pmDisplayName\":null,\"verifier\":null,\"name\":\"测试需求2\",\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"completeTime\":null,\"updateor\":\"songke\",\"iterationId\":0,\"verifierDisplayName\":null,\"updateTime\":\"2020-11-18 13:57:38\",\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"废弃\",\"statusUpdateor\":\"songke\",\"statusUpdateTime\":\"2020-11-18 13:57:38\",\"detailId\":60,\"dateCreated\":\"2019-11-22 22:21:47\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":279},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationName\":\"无迭代\",\"pm\":null,\"statusUpdateTime\":\"2020-07-01 15:40:07\",\"pmDisplayName\":null,\"name\":\"测试需求3\",\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"priority\":\"P3\",\"updateTime\":\"2020-07-01 15:40:07\",\"completeTime\":null,\"updateor\":\"songke\",\"iterationId\":0,\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"废弃\",\"statusUpdateor\":\"songke\",\"detailId\":61,\"dateCreated\":\"2019-11-22 22:27:33\",\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":280},{\"creator\":\"songke\",\"projectId\":61,\"creatorDisplayName\":\"宋珂\",\"updateorDisplayName\":\"宋珂\",\"iterationName\":\"无迭代\",\"pm\":null,\"pmDisplayName\":null,\"name\":\"测试需求4\",\"verifier\":null,\"statusUpdateorDisplayName\":\"宋珂\",\"projectName\":\"宋珂测试项目1\",\"processor\":\"songke\",\"updateTime\":\"2020-11-19 17:32:05\",\"priority\":\"P3\",\"completeTime\":null,\"statusUpdateTime\":\"2020-11-19 17:32:05\",\"updateor\":\"songke\",\"iterationId\":0,\"verifierDisplayName\":null,\"type\":\"requirement\",\"isValid\":true,\"nodeBuildId\":0,\"status\":\"废弃\",\"statusUpdateor\":\"songke\",\"dateCreated\":\"2019-11-22 22:43:19\",\"detailId\":62,\"processorDisplayName\":\"宋珂\",\"nodeId\":0,\"id\":281}]";
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(jsonText);
        JsonArray jsonArray = tradeElement.getAsJsonArray();
        jsonArray.get(0).getAsJsonObject().get("pm");
        jsonArray.get(0).getAsJsonObject().get("status");
        String.valueOf(jsonArray.get(0).getAsJsonObject().get("pm"));
        jsonArray.forEach(System.out::println);

    }
    //@Test
    public void test02(){
        JsonParser parser = new JsonParser();
        String getFilterDetailurl = String.format(Urls.DEP_Filter_DETAIL_API, "164");
        String rep = MacroHttpClient.HttpGetString(getFilterDetailurl);
        JsonElement tradeElement = parser.parse(rep);
        String searchValue = tradeElement.getAsJsonObject().get("searchValue").getAsString();
        //获取反馈内容
        String searchUrl = Urls.DEP_SEARCH_ALL_API+"?"+searchValue;
        HttpResponse response = MacroHttpClient.HttpGetResponese(searchUrl);
        int total = Integer.valueOf(response.getHeaders("X-Total-Count")[0].getValue());
    }
    //@Test
    public void test03(){
        JsonParser parser = new JsonParser();
        String detailRequest = Urls.DEP_SEARCH_ALL_API + "?id=" + "4716";
        String detailJsonStr = MacroHttpClient.HttpGetString(detailRequest);
        DetailVo detailVo =new Gson().fromJson(parser.parse(detailJsonStr).getAsJsonArray().get(0),DetailVo.class);
    }

    //@Test
    public void test04(){
        String JsonStr = "{\n" +
                "    \"success\": true,\n" +
                "    \"total\": 365,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"completeTime\": \"2021-01-20 10:22:13\",\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-20 10:21:57\",\n" +
                "            \"detailId\": 1729,\n" +
                "            \"id\": 4386,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_需求\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 165,\n" +
                "            \"projectName\": \"但\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2021-01-20 10:22:13\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-20 10:22:13\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2021-01-19 17:28:39\",\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-19 17:28:17\",\n" +
                "            \"detailId\": 1724,\n" +
                "            \"id\": 4379,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_213\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 52,\n" +
                "            \"projectName\": \"群群测试2\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2021-01-19 17:28:39\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-19 17:28:39\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2021-01-19 17:21:40\",\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-19 17:21:19\",\n" +
                "            \"detailId\": 1722,\n" +
                "            \"id\": 4376,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_12\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 52,\n" +
                "            \"projectName\": \"群群测试2\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2021-01-19 17:21:40\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-19 17:21:40\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2021-01-19 17:18:28\",\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-19 17:18:14\",\n" +
                "            \"detailId\": 1718,\n" +
                "            \"id\": 4370,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_01-18-5\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 52,\n" +
                "            \"projectName\": \"群群测试2\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2021-01-19 17:18:28\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-19 17:18:28\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"songke\",\n" +
                "            \"creatorDisplayName\": \"宋珂\",\n" +
                "            \"dateCreated\": \"2021-01-13 17:00:39\",\n" +
                "            \"detailId\": 1700,\n" +
                "            \"id\": 4327,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_1-8-10\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 3828,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"songke\",\n" +
                "            \"processorDisplayName\": \"宋珂\",\n" +
                "            \"projectId\": 175,\n" +
                "            \"projectName\": \"2021\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2021-01-13 17:00:40\",\n" +
                "            \"statusUpdateor\": \"songke\",\n" +
                "            \"statusUpdateorDisplayName\": \"宋珂\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-13 17:00:40\",\n" +
                "            \"updateor\": \"songke\",\n" +
                "            \"updateorDisplayName\": \"宋珂\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-13 11:59:30\",\n" +
                "            \"detailId\": 1275,\n" +
                "            \"id\": 4296,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试2\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2021-02-04 11:51:35\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"requirement\",\n" +
                "            \"updateTime\": \"2021-02-04 11:51:35\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-13 11:59:07\",\n" +
                "            \"detailId\": 1521,\n" +
                "            \"id\": 4295,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试1\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待修复\",\n" +
                "            \"statusUpdateTime\": \"2021-01-13 11:59:07\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"bug\",\n" +
                "            \"updateTime\": \"2021-01-13 11:59:11\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": \"guoqilong\",\n" +
                "            \"verifierDisplayName\": \"郭启龙\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-13 11:58:37\",\n" +
                "            \"detailId\": 1520,\n" +
                "            \"id\": 4294,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待修复\",\n" +
                "            \"statusUpdateTime\": \"2021-01-13 11:58:37\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"bug\",\n" +
                "            \"updateTime\": \"2021-01-13 11:59:23\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": \"guoqilong\",\n" +
                "            \"verifierDisplayName\": \"郭启龙\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2021-01-12 15:25:33\",\n" +
                "            \"detailId\": 1686,\n" +
                "            \"id\": 4269,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 360,\n" +
                "            \"iterationName\": \"01-12新建一个迭代\",\n" +
                "            \"name\": \"测试任务_第二个需求\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2021-01-12 15:25:33\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-12 16:13:09\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2021-01-12 11:33:01\",\n" +
                "            \"creator\": \"songke\",\n" +
                "            \"creatorDisplayName\": \"宋珂\",\n" +
                "            \"dateCreated\": \"2021-01-12 11:32:36\",\n" +
                "            \"detailId\": 1678,\n" +
                "            \"id\": 4254,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 321,\n" +
                "            \"iterationName\": \"12月-3\uD83D\uDE00\uD83D\uDE00\",\n" +
                "            \"name\": \"测试任务_1-12\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"songke\",\n" +
                "            \"processorDisplayName\": \"宋珂\",\n" +
                "            \"projectId\": 61,\n" +
                "            \"projectName\": \"宋珂测试项目1\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2021-01-12 11:33:01\",\n" +
                "            \"statusUpdateor\": \"songke\",\n" +
                "            \"statusUpdateorDisplayName\": \"宋珂\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-12 12:05:41\",\n" +
                "            \"updateor\": \"songke\",\n" +
                "            \"updateorDisplayName\": \"宋珂\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"guoqilong\",\n" +
                "            \"creatorDisplayName\": \"郭启龙\",\n" +
                "            \"dateCreated\": \"2021-01-11 14:35:42\",\n" +
                "            \"detailId\": 1139,\n" +
                "            \"id\": 4232,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"郭启龙测试\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": \"\",\n" +
                "            \"pmDisplayName\": \"\",\n" +
                "            \"priority\": \"P2\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"需求设计中\",\n" +
                "            \"statusUpdateTime\": \"2021-01-12 13:52:11\",\n" +
                "            \"statusUpdateor\": \"guoqilong\",\n" +
                "            \"statusUpdateorDisplayName\": \"郭启龙\",\n" +
                "            \"type\": \"requirement\",\n" +
                "            \"updateTime\": \"2021-01-15 16:02:26\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2021-01-05 11:17:00\",\n" +
                "            \"detailId\": 1673,\n" +
                "            \"id\": 4214,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 340,\n" +
                "            \"iterationName\": \"迭代1\",\n" +
                "            \"name\": \"测试任务_asdfas\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 3779,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 170,\n" +
                "            \"projectName\": \"新的项目改名字+1\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2021-01-05 11:17:00\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-05 11:17:00\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:26:11\",\n" +
                "            \"detailId\": 1655,\n" +
                "            \"id\": 4161,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 339,\n" +
                "            \"iterationName\": \"迭代12-31 03\",\n" +
                "            \"name\": \"测试任务_又一个普通用户的需求\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 3761,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:26:11\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2020-12-31 17:26:11\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2020-12-31 17:22:14\",\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:21:59\",\n" +
                "            \"detailId\": 1654,\n" +
                "            \"id\": 4160,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 338,\n" +
                "            \"iterationName\": \"新建迭代12-31郭启龙3\",\n" +
                "            \"name\": \"测试任务_一个普通用户的需求afsdf\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 3760,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:22:14\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2020-12-31 17:22:14\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:15:48\",\n" +
                "            \"detailId\": 1652,\n" +
                "            \"id\": 4158,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_阿萨德\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:15:48\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-11 11:01:42\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2020-12-31 17:15:40\",\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:15:21\",\n" +
                "            \"detailId\": 1651,\n" +
                "            \"id\": 4157,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 338,\n" +
                "            \"iterationName\": \"新建迭代12-31郭启龙3\",\n" +
                "            \"name\": \"测试任务_又一个普通用户的需求-克隆\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:15:40\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2020-12-31 17:17:17\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:14:38\",\n" +
                "            \"detailId\": 1650,\n" +
                "            \"id\": 4156,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 0,\n" +
                "            \"iterationName\": \"无迭代\",\n" +
                "            \"name\": \"测试任务_阿萨德\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 3757,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:14:38\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2020-12-31 17:14:38\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:11:05\",\n" +
                "            \"detailId\": 1648,\n" +
                "            \"id\": 4151,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 339,\n" +
                "            \"iterationName\": \"迭代12-31 03\",\n" +
                "            \"name\": \"测试任务_又一个普通用户的需求\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 3756,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P2\",\n" +
                "            \"processor\": \"guoqilong\",\n" +
                "            \"processorDisplayName\": \"郭启龙\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:11:05\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-11 11:01:05\",\n" +
                "            \"updateor\": \"guoqilong\",\n" +
                "            \"updateorDisplayName\": \"郭启龙\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": null,\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:10:01\",\n" +
                "            \"detailId\": 1647,\n" +
                "            \"id\": 4150,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 339,\n" +
                "            \"iterationName\": \"迭代12-31 03\",\n" +
                "            \"name\": \"测试任务_又一个普通用户的需求a就阿萨德减肥辣椒水的咖啡机奥克斯的罚款是电费卡手动阀\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"待处理\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:10:01\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2021-01-12 16:49:25\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"completeTime\": \"2020-12-31 17:10:14\",\n" +
                "            \"creator\": \"liuqunqun\",\n" +
                "            \"creatorDisplayName\": \"刘群群\",\n" +
                "            \"dateCreated\": \"2020-12-31 17:09:33\",\n" +
                "            \"detailId\": 1644,\n" +
                "            \"id\": 4147,\n" +
                "            \"isValid\": true,\n" +
                "            \"iterationId\": 339,\n" +
                "            \"iterationName\": \"迭代12-31 03\",\n" +
                "            \"name\": \"测试任务_又一个普通用户的需求\",\n" +
                "            \"nodeBuildId\": 0,\n" +
                "            \"nodeId\": 0,\n" +
                "            \"pm\": null,\n" +
                "            \"pmDisplayName\": null,\n" +
                "            \"priority\": \"P3\",\n" +
                "            \"processor\": \"liuqunqun\",\n" +
                "            \"processorDisplayName\": \"刘群群\",\n" +
                "            \"projectId\": 159,\n" +
                "            \"projectName\": \"群群测试项目\",\n" +
                "            \"status\": \"完成\",\n" +
                "            \"statusUpdateTime\": \"2020-12-31 17:10:14\",\n" +
                "            \"statusUpdateor\": \"liuqunqun\",\n" +
                "            \"statusUpdateorDisplayName\": \"刘群群\",\n" +
                "            \"type\": \"task\",\n" +
                "            \"updateTime\": \"2020-12-31 17:10:14\",\n" +
                "            \"updateor\": \"liuqunqun\",\n" +
                "            \"updateorDisplayName\": \"刘群群\",\n" +
                "            \"verifier\": null,\n" +
                "            \"verifierDisplayName\": null\n" +
                "        }\n" +
                "    ],\n" +
                "    \"message\": \"\"\n" +
                "}";
        JsonParser parser = new JsonParser();

        JsonElement newElement = parser.parse(JsonStr);
        JsonArray jsonArray = newElement.getAsJsonObject().get("data").getAsJsonArray();
        for (JsonElement one:jsonArray){
            System.out.println(one.getAsJsonObject().get("name").getAsString());
            System.out.println(one.getAsJsonObject().get("pmDisplayName").toString());
        }
    }
    //@Test
    public void test05(){
        String url = "http://dep.vdian.net/#/search?order=desc&sort=dateCreated&offset=0&name=%E6%B5%8B%E8%AF%95&bugRequirements=&creatorOrVerifierDepart=&processorOrCreatorOrVerifier=&projectId=&processorDepart=&creatorDepart=&startTime=&endTime=";
        LinkedHashMap list = this.initExpandColumns(url);
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
            if(expandColumns.get(fieldName)!=null){
                columnsMap.put(fieldName,expandColumns.get(fieldName).getAsString());
            }else if(moreTypeParms.get(fieldName)!=null){
                columnsMap.put(fieldName,moreTypeParms.get(fieldName).getAsString());
            }
        }
        return columnsMap;
    }
    @Test
    public void test06(){
        String jsonStr = FieldConfig.MORE_TYPE_PARAMS;
        JsonParser parser = new JsonParser();
        JsonObject jsonElement = parser.parse(jsonStr).getAsJsonObject();
        jsonElement.get("aa");
    }
}
