package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import okhttp3.Headers;

public class RestClient {
	
	//1. Get Method
	public void get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);
		
		//status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code for GET----->"+statusCode);
		
		//JSON response
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		System.out.println("Rsponse String for GET----->"+responseString);
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("Rsponse JSON for GET----->"+responseJSON);
		
		//response Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders = new HashMap<String,String> ();
		
		for(Header header : headersArray)
		{
			allHeaders.put(header.getName(),header.getValue());
		}
		
		System.out.println("All response headers for GET---->"+allHeaders);
		
		
		
		
		
	}

}
