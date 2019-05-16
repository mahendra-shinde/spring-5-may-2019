package com.cg.jpademo1.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.cg")
@EnableTransactionManagement
public class AppConfig {

	// 1: Data Source BEAN
	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUsername("hr"); // Please Update Values
		ds.setPassword("hr"); // Please Update Values
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//Please Update Values
		
		return ds;
	}
	
	// 2: EntityManagerFactory BEAN
	@Bean
	public LocalContainerEntityManagerFactoryBean factory() {
		LocalContainerEntityManagerFactoryBean factory = 
					new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(ds());
		factory.setPackagesToScan("com.cg.jpademo1.entities");
		factory.setPersistenceProviderClass
			(org.hibernate.jpa.HibernatePersistenceProvider.class);
		
		factory.getJpaPropertyMap()
			.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		factory.getJpaPropertyMap()
			.put("hibernate.hbm2ddl.auto","create-drop");
		
		return factory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(
				factory().getNativeEntityManagerFactory());
		return tm;
	}
	
}
