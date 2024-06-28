package com.mysite.core.serviceimpl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.core.config.Youtubeconfig;
import com.mysite.core.services.Youtubeservice;

@Component(service = Youtubeservice.class,enabled = true, immediate = true)
@Designate(ocd = Youtubeconfig.class)
public class Youtubeserviceimpl implements Youtubeservice{
	private Youtubeconfig config;


	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Activate
	public void activate(final Youtubeconfig activateconfig) {
		this.config=activateconfig;
	}

	@Override
	public Youtubeconfig getYoutubeconfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getAPIPath() {
		logger.info(config.getYoutubepath());
		// TODO Auto-generated method stub
		return config.getYoutubepath();
	}
}
