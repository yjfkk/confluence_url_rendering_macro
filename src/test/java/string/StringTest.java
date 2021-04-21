package string;

import com.atlassian.tutorial.constant.Urls;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class StringTest {
    @Test
    public void test01(){
        String depUrl = "http://dep.daily.vdian.net/#/search?name=%20%E6%B5%8B%E8%AF%95&searchFrom=navigation";
        depUrl.startsWith(Urls.DEP_SEARCH_PAGE_URL);
    }
    @Test
    public void tets02() throws MalformedURLException {
        String depUrl = "http://dep.daily.vdian.net/#/search?searchFilterId=164";
        URL url= new URL(depUrl);
        List<NameValuePair> list = URLEncodedUtils.parse(depUrl.split("\\?")[1], Charset.forName("UTF-8"));
        boolean isFilter = false;
        String filterId = "";
        for (NameValuePair one : list) {
            if (one.getName().equals("searchFilterId")) {
                isFilter = true;
                filterId = one.getValue();
                System.out.println("aaaaaa");
                break;
            }
        }
    }
}
