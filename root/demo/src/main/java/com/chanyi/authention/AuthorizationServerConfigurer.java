package com.chanyi.authention;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import com.chanyi.dao.DataSourceConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
	

	@Bean
	public ClientDetailsService jdbcClientDetails() {
		// 基于 JDBC 实现，需要事先在数据库配置客户端信息
		DataSourceConfigurer datasourceConfig = new DataSourceConfigurer();
		DataSource dataSource = datasourceConfig.dataSource();
		return new JdbcClientDetailsService(dataSource);
	}
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        配置客户端
//    	存入数据库的情况
    	clients.withClientDetails(jdbcClientDetails());
    	//存入内存的情况
//        clients
//                // 使用内存设置
//                .inMemory()
//                // client_id
//                .withClient("client")
//                // client_secret
//                .secret("secret")
//                // 授权类型
//                .authorizedGrantTypes("authorization_code")
//                // 授权范围
//                .scopes("app")
//                // 注册回调地址
//                .redirectUris("http://www.funtl.com");
    }
    
    	
}