package com.bismus.thirdLab.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class I18nConfig {
    @Bean
    public MessageSource messageSource() {
        var src = new ReloadableResourceBundleMessageSource();
        src.setDefaultEncoding("UTF-8");
        src.setBasename("interfaceLanguage");
        src.setUseCodeAsDefaultMessage(true);
        return src;
    }

}
