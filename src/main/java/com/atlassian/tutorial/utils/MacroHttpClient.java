package com.atlassian.tutorial.utils;

import com.atlassian.tutorial.constant.Urls;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


public  class  MacroHttpClient {
    public static String HttpGetString(String url){
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");
        HttpResponse response = null;
        String resultString ="";
        try {
            response = client.execute(request);
            resultString = IOUtils.toString(response.getEntity().getContent());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultString;
    }
    public static HttpResponse HttpGetResponese(String url){
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("accept", "application/json");
        HttpResponse response = null;
        try {
            response = client.execute(request);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }



}
