package com.mysite.core.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CustomMultifieldModel {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private String listFrom;
	@Inject private List<CustomMutliFieldList> files;
	@Inject private List<CustomMutliFieldList> filesv2;

	public List<CustomMutliFieldList> getFiles() {
		return files;
	}

public String getListFrom() {
	return listFrom;
}

public List<CustomMutliFieldList> getFilesv2() {
	return filesv2;
}


}
