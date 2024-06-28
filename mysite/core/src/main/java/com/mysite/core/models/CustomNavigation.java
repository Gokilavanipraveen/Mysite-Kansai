package com.mysite.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.mysite.core.services.Youtubeservice;

@Model(adaptables = {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomNavigation {
    
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject private String rootpath;
	
	private Resource Res;

	@OSGiService
	private Youtubeservice service1;
	
	
	@Inject private ResourceResolver Resolver;
	
	private List<String> childname;

	private Map<String,String> map;

	public String getRootpath() {
		return rootpath;
	}
	
	public List<String> getChildname() {
		return childname;
	}
	
	public Map<String,String> getMap() {
		return map;
	}
	 @ScriptVariable
	    private Page currentPage;
	 
@PostConstruct
public void init() {
	childname=new ArrayList();
	map=new HashMap<String, String>();
	
	logger.info("Root pathhhhhh1  {}::::",service1.getAPIPath());	
	
	if(rootpath !=null) {
		childPage(rootpath);
	}
else {
	logger.info("currentPage ::: {}",currentPage.getPath());
	childPage(currentPage.getPath());
}
}
	 private void childPage(String rootpath2) {
		Res=Resolver.getResource(rootpath2);
		logger.info("Root Path :: ",rootpath2);
		
		Iterable<Resource> info = Res.getChildren();
		
		for(Resource r : info){
		if(!r.getName().equals("jcr:content")){
			
		logger.info("Name:"+ r.getName());
		
		//To get the current value from current resource
		//if(r.getValueMap().get("hideInNav").equals(true)) {
		
		childname.add(r.getName());
		
		logger .info("Path:"+ r.getPath());
		logger .info("Created By:"+ r.getValueMap().get(JcrConstants.JCR_CREATED_BY));
		map.put(r.getPath(), r.getName());
		}	
}
	
}







}
