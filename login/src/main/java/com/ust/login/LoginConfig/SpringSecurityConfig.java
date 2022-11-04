package com.ust.login.LoginConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebMvcConfigurerAdapter{
	
@Override
protected void configure(AuthenticationManagerBuilder auth)throws Exception
{
	auth.inMemoryAuthentication().withUser("alfy").password("alfy123").roles("admin");
	
}
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
	}

}
