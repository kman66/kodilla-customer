package com.kodilla.customer;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@Getter
public class DataSource {
	@Value("${datasource.url}")
	private String databaseUrl;
	@Value("${datasource.username}")
	private String databaseUsername;
	@Value("${datasource.password}")
	private String databasePassword;
}
