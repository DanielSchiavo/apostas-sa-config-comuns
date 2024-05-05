package com.apostassa.infra.util.config;

import com.apostassa.infra.util.config.yml.DatabaseConfig;
import com.apostassa.infra.util.config.yml.FlywayConfig;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
	
    private DatabaseConfig database;
    
    private FlywayConfig flyway;
}