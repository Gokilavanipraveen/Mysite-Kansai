package com.mysite.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomTeaser {
	
	@Inject private String Teaser;
	@Inject private String Teasertitle;
	@Inject private String Teaserdesc;
	@Inject private String Teaserpath;
	
	public String getTeaser() {
		return Teaser;
	}
	public String getTeasertitle() {
		return Teasertitle;
	}
	public String getTeaserdesc() {
		return Teaserdesc;
	}
	public String getTeaserpath() {
		return Teaserpath;
	}

}
