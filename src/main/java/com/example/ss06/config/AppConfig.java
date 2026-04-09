package com.example.ss06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

public class AppConfig implements WebMvcConfigurer {
    // Định vị HTML
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // Khởi tạo trung tâm xử lý Thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    // Khởi tạo ThymeleafViewResolver
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}
