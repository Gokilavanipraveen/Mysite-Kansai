package com.mysite.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomCarousel {
	
	
	@Inject private String carousellistFrom;
	
	@Inject private List<Carousel>carouselv1;
	@Inject private List<Carousel>carouselv2;
	

	public List<Carousel> getCarouselv1() {
		return carouselv1;
	}
	public List<Carousel> getCarouselv2() {
		return carouselv2;
	}
	public String getCarousellistFrom() {
		return carousellistFrom;
	}
	
	
}
