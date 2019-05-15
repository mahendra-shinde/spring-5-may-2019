## JSR-303 : Annotation based Validation

Perform Server side validation of MVC forms.

### Pre-requisites:

	Please follow [these steps](spring-mvc-forms-steps.md) to create mvc forms project without validation. 

1. New Dependency "hibernate-validator"
   Open "pom.xml" file > Dependencies TAB
	
	Click "Add" button
	
	search for "validator" 
	
	select "hibernate-validator" press OK

   If you get NO search results write following lines in POM.xml

	```xml
	<dependency>
  		<groupId>org.hibernate.validator</groupId>
  		<artifactId>hibernate-validator</artifactId>
  		<version>6.0.16.Final</version>
  	</dependency>
	```


2. Modify the model class
	
	```java
		import javax.validation.constraints.*;

		public class Customer {
		
		@NotNull(message="Please enter Customer ID")
		private Integer customerId;
		
		@NotEmpty(message="Please enter firstname")
		@Size(min=3, max=20, message="Must contains atleast 3 and atmost 20 characters")
		private String firstName;

		//Optional fields
		private String lastName;
		//OPtional fields
		private String address;
		
		@Email(message="Invalid email address")
		private String email;
		//getters/setters
		}
	```

3.  Modify "CustomerController"

	```java
		@RequestMapping(value="/add-customer.obj",method=RequestMethod.POST)
		public ModelAndView submitForm(
				@Valid @ModelAttribute("customer") Customer customer,
				BindingResult result) {
			
			
			ModelAndView mv = null;
			System.out.println("Accepting customer object: ");
			
			if(result.hasErrors()) {
				mv = new ModelAndView("form");
				//Copy all error messages to form page
				mv.addObject(result.getModel());
			}
			else {
				mv = new ModelAndView("success");
				mv.addObject("customer",customer);
				mv.addObject("message","Your request has been accepted!");
			}
			return mv;
		}
	```

4.	Modify "form.jsp" page, add Error Tag for each field eg. error for firstName should be:
		
	```<s:errors path="firstName" />```

5.	Run Application on Server and try URL:

	<AppBaseURL>/add-customer.obj

	Click Submit button with ALL EMPTY fields.