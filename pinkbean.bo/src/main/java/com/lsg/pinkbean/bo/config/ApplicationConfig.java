package com.lsg.pinkbean.bo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySources({@PropertySource(value="classpath:config/testProperties.properties")})
public class ApplicationConfig {

}
