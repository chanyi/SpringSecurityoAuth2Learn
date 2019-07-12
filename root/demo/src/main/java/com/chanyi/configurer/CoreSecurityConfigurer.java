package com.chanyi.configurer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(CustomSecurityConfigurer.class)
public class CoreSecurityConfigurer{
	//加载所有的配置类
}