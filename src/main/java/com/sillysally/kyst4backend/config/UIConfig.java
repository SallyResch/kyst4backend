package com.sillysally.kyst4backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class UIConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("adminPage");
        registry.addViewController("/").setViewName("homePage");
        registry.addViewController("/login").setViewName("loginPage");
        registry.addViewController("/logout").setViewName("logoutPage");
        registry.addViewController("/user").setViewName("userPage");
        registry.addViewController("/update").setViewName("updatePage");
        registry.addViewController("/register").setViewName("registerPage");
    }
}
