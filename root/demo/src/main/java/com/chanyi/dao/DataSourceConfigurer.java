package com.chanyi.dao;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfigurer{

	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		//使用hikari数据连接池
//		return DataSourceBuilder.create().build();
		//使用druid数据库连接池
		return new DruidDataSource();
	}
	
	@ResponseBody
	@GetMapping("/test")
	public String test(){
		return "this is test";
	}

}