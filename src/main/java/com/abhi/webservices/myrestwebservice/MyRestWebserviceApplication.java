package com.abhi.webservices.myrestwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class MyRestWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestWebserviceApplication.class, args);
//		ApplicationContext
//				applicationContext =
//				SpringApplication.run(MyRestWebserviceApplication.class, args);
//
//		for (String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

	@Bean
	public LocaleResolver getLocaleResolver(){
		return new AcceptHeaderLocaleResolver(){
			@Override
			public void setDefaultLocale(Locale defaultLocale) {
				super.setDefaultLocale(Locale.US);
			}
		};
	}
	/*	public ResourceBundleMessageSource getResourceBundleMessageSource(){
		return new ResourceBundleMessageSource(){
			@Override
			public void setBasename(String basename) {
				super.setBasename("messages");
			}
		};
	}*/

/*	@Bean
	public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
		return new WebSecurityConfigurerAdapter() {
			@Override
			protected void configure(HttpSecurity http) throws Exception {
				super.configure(http);
					http.csrf().disable();
			}
		};
	}*/
}

