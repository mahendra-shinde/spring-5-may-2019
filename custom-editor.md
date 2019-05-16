## Custom Editor Demo
1. Edit "Employee.java"
	
	1.1 Add import for java.util.Date
	
	1.2 add new property 
		private Date dob;
	
	1.3 Generate Getter & Setter for property "dob"

2. Create new class "CustomDateEditor"

	```java
	public class CustomDateEditor  extends PropertyEditorSupport	{

	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	@Override
	public String getAsText() {
		return df.format(getValue());
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			setValue(df.parse(text));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IllegalArgumentException("Invalid Date syntax, please use dd-MM-yyyy");
		}
	  }
	}
	```

3.	Edit "spring.xml" file with new BEAN:

	```xml
	<bean id="customEditor" class="org.springframework.beans.factory.config.CustomEditorConfigurer">
		<property name="customEditors">
			<map>
				<entry key="java.util.Date" 
				value="com.cg.models.CustomDateEditor" />
			</map>
		</property>
	</bean>
	```
		
3.	Modify "employee" bean definition:

	```xml
	<bean id="emp" class="com.cg.models.Employee" autowire="byName">
		<property name="firstName" value="Shivaji" />
		<property name="lastName" value="Gaekwad"/>
		<property name="dob" value="12-05-1959"/>
	</bean>
	```

4.	Modify Main method:

	```java	
	AbstractApplicationContext context =
			new ClassPathXmlApplicationContext("spring.xml");
	Employee e = context.getBean(Employee.class);
	System.out.println(e.getFirstName());
	System.out.println(e.getDepartment().getLocation());
	System.out.println(e.getDob());
		
	System.out.println("Shutdown the Spring IOC COntainer");
	context.close();
	```