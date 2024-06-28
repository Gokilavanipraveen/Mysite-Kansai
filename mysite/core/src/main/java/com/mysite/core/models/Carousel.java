package com.mysite.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Carousel {
	
	@Inject private String carouseltext;
	@Inject private String carouselfileReference;
	
	public String getCarouseltext() {
		return carouseltext;
	}
	public String getCarouselfileReference() {
		return carouselfileReference;
	}
	
	

}
