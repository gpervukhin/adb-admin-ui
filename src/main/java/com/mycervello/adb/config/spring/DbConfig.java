package com.mycervello.adb.config.spring;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycervello.adb.config.AppSettings;

/**
 * This class is used to configure connection to DB in Spring app.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-11-2018
 */
@Configuration
public class DbConfig {
	
	@Bean
	public DataSource dataSource() throws URISyntaxException {
		URI dbUri = new URI(AppSettings.DATABASE_URL);

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort()
			+ dbUri.getPath() + "?sslmode=require";

		return DataSourceBuilder.create()
			.url(dbUrl).username(username).password(password)
			.build();
	}
}