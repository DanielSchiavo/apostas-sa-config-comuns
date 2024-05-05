package com.apostassa.infra.db;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.sql.DataSource;

@WebListener
public class ConnectionPostgreContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		DataSource pool = new ConnectionFactoryPostgreSQL().initialize();

		servletContext.setAttribute("my-pool", pool);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HikariDataSource pool = (HikariDataSource) event.getServletContext().getAttribute("my-pool");
		if (pool != null) {
			pool.close();
		}
	}
}