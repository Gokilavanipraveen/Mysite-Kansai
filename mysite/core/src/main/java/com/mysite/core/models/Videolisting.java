package com.mysite.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.core.services.Youtubeapicallservice;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Videolisting {	

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Named("text")
	@Inject private String youtubeid;
	
	@Inject
	private Youtubeapicallservice service;

	public String getYoutubeid() {
		return youtubeid;
	}
	
	
@PostConstruct
public void init() {	
	String check = service.getyoutubedetails(youtubeid);
	logger.info(check);	
}

}
