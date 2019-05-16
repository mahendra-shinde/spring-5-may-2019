## Spring JPA Demo (Using JPA 2.x & Hibernate 5)

Demonstrating Layered application with DAO & Service layer (with Interfaces), uses Spring-ORM module (JPA 2.x with Hibernate As Provider).
For Spring-data-jpa demo, please click [here](spring-boot-data-jpa-steps.md)

1.  Create new Maven Project

    ```yaml
    Name:       jpademo1
    GroupId:    com.cg
    ArtifactId: jpademo1
    Packaging:  jar
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
		factory.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);
		
		factory.getJpaPropertyMap().put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		factory.getJpaPropertyMap().put("hibernate.hbm2ddl.auto","create");
		
		return factory;
	    }
    }
    @Bean
	public PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(
				factory().getObject());
		return tm;
	}
    ```

4.  Create a new Entity class 

    ```yaml
    Classname:  Movie
    Package:    com.cg.jpademo1.entities
    ```

    ```java
    @Entity @Table(name="movies")
    public class Movie {
	
	@Id private Integer id;
	
	@Column(length=40)
	private String title;
	
	@Column(length=40)
	private String director;
	
	private Double budget;
	
	@Column(length=10)
    private String genre;
    //add getters and setters
    }
    ```
    > The complete Movie.java could be found [here](jpademo1\src\main\java\com\cg\jpademo1\entities\Movie.java)

5.  Create new DAO Interface 

    ```yaml
    Interface:      MovieDAO
    Package:        com.cg.jpademo1.dao
    ```

    ```java
    public interface MovieDAO {

	    void save(Movie movie);
	    Movie findById(Integer id);
    }
    ```
    > The complete MovieDAO.java could be found [here](jpademo1\src\main\java\com\cg\jpademo1\dao\MovieDAO.java)

6.  Create new DAO Implementation

    ```yaml
    Classname:      MovieDAOImpl
    Package:        com.cg.jpademo1.dao
    ```

    ```java
    @Repository //DAO Annotation
    public class MovieDAOImpl implements MovieDAO {

        @PersistenceContext  // Injecting ready to use EntityManager
        private EntityManager em;
        
        // DAO Save without TRANSACTION !!
        public void save(Movie movie) {
            em.persist(movie);
        }

        public Movie findById(Integer id) {
            return em.find(Movie.class, id);
        }
    }
    ```    
    > The complete MovieDAO.java could be found [here](jpademo1\src\main\java\com\cg\jpademo1\dao\MovieDAOImpl.java)

7.  Create new Service interface

    ```yaml
    Interface:  MovieService
    Package:     com.cg.jpademo1.services
    ```

    ```java
    public interface MovieService {

	    void save(Movie m);
	    Movie findById(Integer id);
    }
    ```
    > The complete MovieService.java could be found [here](jpademo1\src\main\java\com\cg\jpademo1\services\MovieService.java)

8.  Create new Service Implementation class

    ```yaml
    Classname:  MovieServiceImpl
    Package:    com.cg.jpademo1.services
    ```

    ```java
    @Service // Special annotation for Services
    @Transactional // Enable Declarative transaction support 
    public class MovieServiceImpl implements MovieService {

        @Autowired private MovieDAO dao;
        
        @Transactional
        public void save(Movie m) {
            dao.save(m);
        }

        @Transactional(readOnly=true)
        public Movie findById(Integer id) {
            // TODO Auto-generated method stub
            return dao.findById(id);
        }
    }
    ```
    > The complete MovieServiceImpl.java could be found [here](jpademo1\src\main\java\com\cg\jpademo1\services\MovieServiceImpl.java)

9.  Create a new class with main method 

    ```yaml
    Classname:      Main
    Package:        com.cg.jpademo1.app
    Method:         main(String arg[])
    ```

    ```java
    AnnotationConfigApplicationContext context = 
		new AnnotationConfigApplicationContext(AppConfig.class);
	MovieService service = context.getBean(MovieService.class);
	System.out.println("Creating new movie");
	Movie m1 = new Movie();
	m1.setBudget(12500000D);
	m1.setDirector("Karan Johar");
	m1.setGenre("Comedy");
	m1.setTitle("SOTY2");
	m1.setId(10023);
		
	service.save(m1);
	System.out.println("Movie details "+m1.getTitle()+" by "+m1.getDirector());
		
	Movie m2 = service.findById(10023);
	System.out.println("Movie found: "+m2.getTitle()+" budget: "+m2.getBudget().longValue());
    ```

    > The complete Main.java could be found [here](jpademo1\src\main\java\com\cg\jpademo1\app\Main.java)    

