package com.fly.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 配置资源服务器
 * @author zhangyf
 * 2020年3月28日
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("order").stateless(true);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().disable()
			.requestMatchers().anyRequest()
			.and()
			.anonymous()
			.and()
			.authorizeRequests()
//			.antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
			.antMatchers("/order/**").authenticated();
			
	}
	
}
