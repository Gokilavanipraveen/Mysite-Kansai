package com.mysite.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;



@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomBanner {
	
	@Inject private String banner;	
	@Inject private String bannertext;

	public String getBanner() {
		return banner;
	}

	public String getBannertext() {
		return bannertext;
	}
	
	
	
	
}
