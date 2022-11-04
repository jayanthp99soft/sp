package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.example.demo.Service.CustomUserDetailsService;
@Configuration
@EnableAuthorizationServer
//will generate the token will  to communicate with another appn
//configure tokenstore/authenticationmanager/userservice
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
	
	//connect the authorization and resourse server connection we are using
  private static final String RESOURCE_ID = "myrestservice";
  
   TokenStore tokenStore=new InMemoryTokenStore();
  @Autowired
  @Qualifier("authenticationManagerBean")
  AuthenticationManager authenticationManager;
 
  
  //in aothorizationserver by injecting the authenticationmanager and user details
  private CustomUserDetailsService userDetailsServices;
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager).userDetailsService(userDetailsServices);
	}
	
	@Bean
	@Primary
	//it will take default services token as the priority insted of taking the internal springprovide token services
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices =new DefaultTokenServices();
		tokenServices.setTokenStore(this.tokenStore);
		return tokenServices;
	}
	//configure the client details
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory().withClient("MyClientApp").authorizedGrantTypes("password","refresh_token")
				.scopes("read","write").secret(encoder().encode("9999")).resourceIds(RESOURCE_ID);
	}

	
	
	
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	

}
