package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
//take the token and communicate with authorization server make the token is valid it has approprite rule prosses the req and send the response
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{
	private static final String RESOURCE_ID = "myrestservice";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		resources.resourceId(RESOURCE_ID);
	}
//allows the url
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeHttpRequests().antMatchers("/admin/*").hasRole("ADMIN").antMatchers("/helo/*").authenticated();
	}
	

}
