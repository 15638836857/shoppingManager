package com.palmble.sp.manger.web.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebConfig {

	@Bean(name = "privilegeFilter")
	public Filter privilegeFilter() {
		return new PrivilegeFilter();

	}
	@Bean(name = "loginFilter")
	public Filter LoginFilter() {
		return new LoginFilter();

	}

	@Bean
	public FilterRegistrationBean LoginFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DelegatingFilterProxy("loginFilter"));
		registration.addUrlPatterns("/*");
		registration.setName("loginFilter");
		registration.setOrder(1);
		return registration;
	}
	@Bean
	public FilterRegistrationBean privilegeFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DelegatingFilterProxy("privilegeFilter"));
		registration.addUrlPatterns("/*");
		registration.setName("privilegeFilter");
		registration.setOrder(2);
		return registration;
	}

}
