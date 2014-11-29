package com.hcl.zuora.initialize;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@ComponentScan("com.hcl.zuora.initialize")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 
	 * @return ServletContextTemplateResolver ServletContextTemplateResolver.
	 */
	@Bean
	@Description("Thymeleaf template resolver for serving HTML 5")
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateresolver = new ServletContextTemplateResolver();
		templateresolver.setPrefix("/WEB-INF/views/");
		templateresolver.setSuffix(".html");
		templateresolver.setTemplateMode("LEGACYHTML5");
		templateresolver.setCacheable(false);
		return templateresolver;
	}
	
	@Bean
	@Description("Thymeleaf Template Engine with Spring Integration")
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}
	
	@Bean
	@Description("Thymeleaf View Resolver")
	public ThymeleafViewResolver thymeleafViewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}
	
	@Override   
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
}
