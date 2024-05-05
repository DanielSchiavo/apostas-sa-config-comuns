package com.apostassa.infra.db;

import com.apostassa.infra.util.config.Config;
import com.apostassa.infra.util.config.ConfigReader;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public class ConnectionFactoryPostgreSQL {

	public HikariDataSource initialize() {
		Config config = new ConfigReader().getConfig();

		String url = config.getDatabase().getUrl();
		String username = config.getDatabase().getUsername();
		String password = config.getDatabase().getPassword();
		String driver = config.getDatabase().getDriver();

		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		hikariConfig.setDriverClassName(driver);
		hikariConfig.setMaximumPoolSize(3);
		hikariConfig.setMinimumIdle(1);
		hikariConfig.setIdleTimeout(10000);
		hikariConfig.setConnectionTimeout(30000);
		hikariConfig.setAutoCommit(false);

		return new HikariDataSource(hikariConfig);
	}
}
