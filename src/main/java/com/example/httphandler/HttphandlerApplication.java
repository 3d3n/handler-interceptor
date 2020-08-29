package com.example.httphandler;

import com.example.httphandler.config.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HttphandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttphandlerApplication.class, args);
	}

	@Bean
	public RequestInterceptor myCustomHandlerInterceptor() {
		return new RequestInterceptor();
	}

	@Bean
	public WebMvcConfigurer adapter() {
		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(myCustomHandlerInterceptor());
			}
		};
	}

}
