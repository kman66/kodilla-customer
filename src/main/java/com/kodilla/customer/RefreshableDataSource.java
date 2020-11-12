package com.kodilla.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
@RefreshScope
@Component
public class RefreshableDataSource {
	@Value("${spring.datasource.url}")
	private String databaseUrl;
	@Value("${spring.datasource.username}")
	private String databaseUsername;
	@Value("${spring.datasource.password}")
	private String databasePassword;
	@Value(("${spring.datasource.driver-class-name}"))
	private String databaseDriver;

	//@Autowired
	//DataSource dataSource;

	public void checkDbConnection() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(databaseDriver);
		dataSourceBuilder.url(databaseUrl);
		dataSourceBuilder.username(databaseUsername);
		dataSourceBuilder.password(databasePassword);
		DataSource dataSource = dataSourceBuilder.build();
		log.info("data source: {}, databaseDriver: {}, dbURL: {}, dbUsername: {}, dbPassword: {}", dataSource,
				databaseDriver, databaseUrl, databaseUsername, databasePassword);
		try {
			dataSource.getConnection();
			dataSource.getConnection().close();
		} catch (SQLException throwables) {
			log.warn("Connection to database couldn't be established");
			throwables.printStackTrace();
		}
	}

}
