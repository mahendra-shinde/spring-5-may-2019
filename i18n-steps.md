Build Multi-Lingual Applications?

i18n: Internationalization

1. Locale :  Country, Language, Formats (Date,Time,Currency)
	
	eg.
		en-IN	English India
		mr-IN	Marathi India
		te-IN	Telagu India
		od-IN	Odia India
		ta-IN	Tamil India
2.  Translations
	Resource Bundles : Set of Properties files for Single Locale

	Creating resource bundle with name "main"
		main.properties			Default 
		main_en_IN.properties
		main_mr_IN.properties
		main_te_IN.properties
		main_od_IN.properties
		main_ta_IN.properties

	main.properties
	message=welcome

3.  Create "messageSource" bean in Spring.xml file
	<bean id="messageSource" 		class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basename" value="main"/>
	</bean>

4.  Create main method:
AbstractApplicationContext context =
	new ClassPathXmlApplicationContext("spring.xml");
	
MessageSource source = context.getBean(MessageSource.class);
Locale tamil = new Locale("ta", "IN");
System.out.println(source.getMessage("message",null, tamil));
Locale hindi = new Locale("hi", "IN");
System.out.println(source.getMessage("message",null, hindi));
System.out.println(source.getMessage("message",null, Locale.getDefault()));
		
System.out.println("Shutdown the Spring IOC COntainer");
context.close();