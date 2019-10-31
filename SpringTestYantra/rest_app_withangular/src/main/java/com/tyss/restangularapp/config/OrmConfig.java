package com.tyss.restangularapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class OrmConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean ormConfiguration() {
		LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
		bean.setPersistenceUnitName("customer-unit");
		return bean;
	}
}
