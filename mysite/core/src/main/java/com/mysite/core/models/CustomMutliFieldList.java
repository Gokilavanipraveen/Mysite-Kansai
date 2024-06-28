package com.mysite.core.models;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomMutliFieldList {
	
@Inject private String fileReference;
@Inject private String desc;
@Inject private String path;
@Inject private String text;


public String getFileReference() {
	return fileReference;
}

public String getDesc() {
	return desc;
}

public String getPath() {
	return path;
}

public String getText() {
	return text;
}
}
