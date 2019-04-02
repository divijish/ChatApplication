package com.divij.chatapplication.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.divij.chatapplication.constants.ConfigEnum;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "${spring.config.location}")
public class HibernateConf {

	@Value("${hibernate.hbm2ddl}")
	private String HIBERNATE_HBM2DDL;

	@Value("${db.driver.classname}")
	private String DB_DRIVER_CLASSNAME;

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;

	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;
	
	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setPackagesToScan(ConfigEnum.PACKAGES_TO_SCAN.getValue());
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DB_DRIVER_CLASSNAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty(ConfigEnum.HIBERNATE_HBM2DDL.getValue(), HIBERNATE_HBM2DDL);
		hibernateProperties.setProperty(ConfigEnum.HIBERNATE_DIALECT.getValue(), HIBERNATE_DIALECT);
		hibernateProperties.setProperty(ConfigEnum.SHOW_SQL.getValue(), HIBERNATE_SHOW_SQL);
		return hibernateProperties;
	}
}