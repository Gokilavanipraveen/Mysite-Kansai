package com.mysite.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "youtubeconfig",description = "youtube configuration")
public @interface Youtubeconfig {
	
	@AttributeDefinition(name = "Youtubepath",type = AttributeType.STRING)
	String getYoutubepath() default "AIzaSyAlBIfEJUduF3Z2qgwE5Ymm-iDouZtrgPU";

}
