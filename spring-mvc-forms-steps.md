## Creating Spring MVC Forms Project (As Maven Project)


1. Create new Maven project 
   
		Name: 		webdemo2
		Packaging: 	WAR
		groupId: 	com.cg
		artifactId: 	webdemo2


2. Open POM.XML and ADD new dependencies:

	Switch to "Dependencies" TAB
	Click on "Add" Button
	
	Search for following dependencies
		
		spring-webmvc, version 5.1.6.RELEASE
		
		jstl, version 1.2

    The Complete POM.XML can be found [here](form-without-validation/pom.xml)
3. Right click on Project and choose "Java EE Tools" > Generate Deployment Descriptor Stub ("web.xml" file)

4. Open web.xml file and add following lines:
		(Make sure all these tags written are before ```</web-app>``` tag

	```xml
  	<servlet>
  	<servlet-name>dispatcher</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
   	<param-name>contextConfigLocation</param-name>
   	<param-value>
         /WEB-INF/spring.xml
   	</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
   	</servlet>
	<servlet-mapping>
  		<servlet-name>dispatcher</servlet-name>
  		<url-pattern>*.obj</url-pattern>
    </servlet-mapping>
	```
    The complete web.xml can be found [here](form-without-validation/src/main/webapp/WEB-INF/web.xml)

5.	Creating new "Spring Bean Configuration file" inside "WEB-INF" folder
	
	filename: "spring.xml"
	
	Choose THREE namespaces: 
	
		1. beans
		2. mvc
		3. context

6.	Add following lines inside "spring.xml" file
		
	```xml
	<context:component-scan base-package="com.cg"/>
	<mvc:annotation-driven/>
	<mvc:view-resolvers>
		<mvc:jsp suffix=".jsp" prefix="/WEB-INF/pages/"  />
	</mvc:view-resolvers>
	```

    The Complete spring.xml could be found [here](form-without-validation/src/main/webapp/WEB-INF/spring.xml)
7.	Create new Class :
		
	name: 		Customer
	
	package:	com.cg.models

	```java
    public class Customer {
        
        private Integer customerId; 
        private String firstName;
        private String lastName;
        private String address;
        private String email;
     
    ```
    DO GENERATE/ADD Getters and Setters for all properties

    The complete Customer.java could be found [here](form-without-validation/src/main/java/com/cg/models/Customer.java) 

8.  Create new Controller class:

    classname:  CustomerController

    package:    com.cg.controllers

    ```java
    @Controller
    public class CustomerController {

        // Method to Accept HTTP GET request on URL that ends with
        // /add-customer.obj
        // Create one EMPTY customer object and send it to
        // a Form page
        @RequestMapping(value="/add-customer.obj",
                method=RequestMethod.GET)
        public ModelAndView showForm() {
            ModelAndView mv = new ModelAndView("form");
            Customer customer = new Customer();
            mv.addObject("customer",customer);
            return mv;
        }
        
        // Method to Accept HTTP POST request on URL that ends with
        // /add-customer.obj
        // accept the Customer object with All properties filled
        // and return to success page
        @RequestMapping(value="/add-customer.obj",method=RequestMethod.POST)
        public ModelAndView submitForm(
                @ModelAttribute("customer") Customer customer) {
            ModelAndView mv = new ModelAndView("success");
            System.out.println("Accepting customer object: ");
            mv.addObject("customer",customer);
            mv.addObject("message","Your request has been accepted!");
            return mv;
        }   
    }
    ```

    The Complete CustomerController.java could be found [here](form-without-validation/src/main/java/com/cg/controllers/CustomerController.java)

9.  Create new JSP file inside "src/main/webapp/WEB-INF/pages" directory with name "form.jsp"

    9.1 Add new taglib using following line:
        
    ```xml
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
     ```
        
    9.2 Add following spring form inside body section of JSP page:
    
    ```xml
    <s:form method="post" modelAttribute="customer">
	<!-- variables from Customer class
		Possible Exception : NoSuchProperty if name doesn't match -->
    
	Enter ID : <s:input path="customerId" /><br/>
	First Name: <s:input path="firstName" /><br/>
	Last Name: <s:input path="lastName" /><br/>
	Address : <s:textarea path="address" rows="4" cols="30"/><br/>
	Email : <s:input path="email"/><br/>
	<input type="submit" value="submit"/> 
    </s:form>
    ```

    The Complete form.jsp could be found [here](form-without-validation/src/main/webapp/WEB-INF/pages/form.jsp)

10. Create new JSP file inside "src/main/webapp/WEB-INF/pages" folder with name "success.jsp"
    
    Add following inside body section:
    
    ```xml
    <!-- Everything inside curly braces is CaseSensitive !
	If value is NULL, then it prints nothing!
	 -->
    <h2>${message}</h2>
	<!-- customer.lastName is translated into customer.getLastName() -->
    Customer : ${customer.lastName } ${customer.firstName}
    ```

    The complete success.jsp could be found [here](form-without-validation/src/main/webapp/WEB-INF/pages/success.jsp)

11.	Right click on Project > Run On Server 

12.	Try URL:
	http://localhost:8080/webdemo2/add-customer.obj

