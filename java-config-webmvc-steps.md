## Using Java Config for Web MVC Project

1.  Create new Maven project
    
        project name:       JavaConfigWebDemo
        groupId:            com.cg
        artifactId:         javaconfigwebdemo
        packaging:          WAR

2.  Open _pom.xml_ and add few dependencies:

  ```xml
  <dependencies>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-webmvc</artifactId>
  		<version>5.1.6.RELEASE</version>
  	</dependency>
  	<dependency>
  		<groupId>javax.servlet</groupId>
  		<artifactId>jstl</artifactId>
  		<version>1.2</version>
  	</dependency>
  </dependencies>
  ```
>The Complete POM.XML could be found [here](javaconfigwebdemo/pom.xml)

3.  Right click on project > properties > Targeted Runtime
        Select either Tomcat or Pivotal tc Press OK

4.  Create a new Java Class

    classname:  	MyInitializer

    package:    	com.cg.javaconfigweb

    Implements: 	WebApplicationInitializer

    ```java
    AnnotationConfigWebApplicationContext context
			= new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		
		AnnotationConfigWebApplicationContext dispatcherContext =
		        new AnnotationConfigWebApplicationContext();
		      dispatcherContext.register(DispatcherConfig.class);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher =
		     servletContext.addServlet("dispatcher", 
		    		 new DispatcherServlet(dispatcherContext));
		     dispatcher.setLoadOnStartup(1);
		     dispatcher.addMapping("/");
    ```
	> The Complete MyInitializer.java could be found [here](javaconfigwebdemo/src/main/java/com/cg/javaconfigweb/MyInitializer.java)

5.	Create new Java Class "DispatcherConfig"

	```java
	@Configuration	//This class is Configuration class
	@EnableWebMvc	//This application is Web MVC Application
	@ComponentScan("com.cg.controllers")	//Scan all classes and packages
											//for web components 
	public class DispatcherConfig {
		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver resolver 
				= new InternalResourceViewResolver();
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setSuffix(".jsp");
			return resolver;
		}
	}
	```
	> Complete DispatcherConfig.java could be found [here](javaconfigwebdemo/src/main/java/com/cg/javaconfigweb/AppConfig.java)

6.	Create new Java class "AppConfig"

	```java
	@Configuration
	public class AppConfig {

	}
	```
	> Complete AppConfig.java could be found [here](javaconfigwebdemo/src/main/java/com/cg/javaconfigweb/DispatcherConfig.java)

7.	Create a new Controller class	

	Classname:		HomeController
	Package:		com.cg.controllers	

	```java
	@Controller
	@RequestMapping("/") //Home page or Welcome page
	public class HomeController {

		@GetMapping
		public ModelAndView home() {
			ModelAndView mv = new ModelAndView("home",
					"message","Welcome to Spring MVC");
			return mv;
		}
	}	
	```	
	> The Complete HomeController could be found [here](javaconfigwebdemo/src/main/java/com/cg/controllers/HomeController.java)

8.	Create new JSP file "home.jsp" inside /src/main/webapp/WEB-INF/pages 

	```xml	
	<h2>Welcome to Spring MVC</h2>
	<h3>${message }</h3>
	```
	> The complete home.jsp could be found [here](javaconfigwebdemo/src/main/webapp/WEB-INF/pages/home.jsp)
