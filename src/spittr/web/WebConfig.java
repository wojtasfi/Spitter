package spittr.web;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Thymeleaf and Spring MVC configuration.
 */

@Configuration
@EnableWebMvc
@ComponentScan("spittr")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	ServletContext context;

	@Bean
	public MultipartResolver multipartResolver() throws IOException {
		return new StandardServletMultipartResolver();
	}

	@Bean(name = "templateResolver")
	public ServletContextTemplateResolver getTemplateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}

	@Bean(name = "templateEngine")
	public SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		return templateEngine;
	}

	@Bean(name = "viewResolver")
	public ThymeleafViewResolver getViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(getTemplateEngine());
		return viewResolver;
	}


    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
      ContentNegotiatingViewResolver cnvr =
          new ContentNegotiatingViewResolver();
      cnvr.setContentNegotiationManager(cnm);
      return cnvr;
    }
    
    @Bean
    public ViewResolver beanNameViewResolver() {
       return new BeanNameViewResolver();
    }
    
    @Bean
    public View spittles() {
      return new MappingJackson2JsonView();
    }
    
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

}