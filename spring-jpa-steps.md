## Spring JPA Demo (Using JPA 2.x & Hibernate 5)


1.  Create new Maven Project

    ```yaml
    Name:       jpademo1
    groupId:    com.cg
    artifactId: jpademo1
    packaging:  JAR
    ```

2.  Open jpademo1/pom.xml file, add few dependencies:

    *  Spring-ORM, Version 5.1.6.RELEASE
    *  Spring-Context, Version 5.1.6.RELEASE
    *  Oracle JDBC Driver, version 11.2.0.3
    *  Hibernate Core, Version 5.3.9.Final

    > NOTE : Oracle JDBC Driver is NOT available in your regular maven repository. please use [this](repository.zip) repository.
    
    Click [here]() for complete pom.xml

3.  Create new Java Class

    ```yaml
    Name:       AppConfig
    Package:    com.cg.jpademo1.config
    ```

    ```java
    @Configuration
    @ComponentScan("com.cg")
    public class AppConfig {

	// 1: Data Source BEAN
	@Bean
	public DataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.oracle.jdbc.OracleDriver");
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
		factory.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
		
		factory.getJpaPropertyMap().put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		factory.getJpaPropertyMap().put("hibernate.hbm2ddl.auto","update");
		
		return factory;
	    }
    }
    ```

4.  