package httpClient;

import com.atlassian.tutorial.constant.Urls;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.junit.Test;


public class JsonTest {
    @Test
    public void test() throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(String.format(Urls.DEP_SEARCH_ALL_API,"测试"));
        request.addHeader("accept", "application/json");
        //request.addHeader("Cookie","__spider__visitorid=f9d31f1112084ed0; UM_distinctid=177dd9ab83d636-0c895fc659464a-33687709-fa000-177dd9ab83e3d8; wdr-ticket=8da6e369b11e807d402632bca66ad517-7abb8c5f6a3c1bc454f11d28f9158c29; sso-ticket=03ef46d3ecb9d47845e21f3485fc2ccf-1226a6db34f7a928df46cb29549e978e; JSESSIONID=99469E1DD0CD80C66E35DAF58D8FAFE5");
        HttpResponse response = client.execute(request);
        int total = Integer.valueOf(response.getHeaders("X-Total-Count")[0].getValue());
        String json = IOUtils.toString(response.getEntity().getContent());

       System.out.println(json);

    }
}