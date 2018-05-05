package com.qa.tests;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.*;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{
	
	TestBase testBase;
	String baseURL;
	String apiURL;
	String url;
	String newURL;
	RestClient restClient;
	
	
	@BeforeTest
	public void setUp() throws ClientProtocolException, IOException
	{
		testBase=new TestBase();
		baseURL = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		url = baseURL + apiURL;
		System.out.println("Get service URL--->"+url);
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException
	{
		restClient = new RestClient();
		restClient.get(url);
		
	}

}
