package com.mysite.core.serviceimpl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.osgi.services.HttpClientBuilderFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.core.services.Youtubeapicallservice;
import com.mysite.core.services.Youtubeservice;

@Component(service = Youtubeapicallservice.class,enabled = true, immediate = true)
public class Youtubeapicallserviceimpl implements Youtubeapicallservice {

	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	private Youtubeservice config;
	
	@Reference
	private HttpClientBuilderFactory  httpclientbuilder;
	
	private Executor execute;
	
	@Override
	public String getyoutubedetails(String youtubeid) {
		logger.info("config check" + config.getAPIPath());
		Request request = Request.Get("https://www.googleapis.com/youtube/v3/videos?part=id%2C+snippet&id="+youtubeid+"&Key="+config.getAPIPath());
		
		try {
			Response response = getExecuteConfig().execute(request);
			logger.info("Response"+response.returnContent().toString());			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("check getyoutubedetails");
		
		// TODO Auto-generated method stub
		return "inside Block";
	}
	
	public HttpClientBuilderFactory getHttpclient() {
		return httpclientbuilder;
	}
	
	private Executor getExecuteConfig() {
		if(execute ==null) {
			HttpClientBuilderFactory httpClientBuilderFactory = getHttpclient();
			HttpClientBuilder builder = httpClientBuilderFactory.newBuilder();
			
			HttpClient httpclient = builder.build();
			this.execute = Executor.newInstance(httpclient);
		}
		return this.execute;
	}

}
