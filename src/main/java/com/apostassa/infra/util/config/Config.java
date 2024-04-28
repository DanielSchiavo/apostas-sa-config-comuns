package com.apostassa.infra.util.config;

import com.apostassa.infra.util.config.yml.DatabaseConfig;
import com.apostassa.infra.util.config.yml.FlywayConfig;

public class Config {
	
    private DatabaseConfig database;
    
    private FlywayConfig flyway;

    public DatabaseConfig getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfig database) {
        this.database = database;
    }

	public FlywayConfig getFlyway() {
		return flyway;
	}

	public void setFlyway(FlywayConfig flyway) {
		this.flyway = flyway;
	}
}