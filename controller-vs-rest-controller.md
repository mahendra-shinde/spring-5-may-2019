## Comparing Rest Controllers with Controllers

Controller     | RestControllers
---------------|---------
Used for defining multiple request handling methods which return Model+View to client | Used for defining multiple request handling methods which return ONLY Model (ie. Data but no View!)
Used in Typical MVC Application where every method returns a JSP view | Used in typical API application which acts as a back-end application and serves request from front end applications (A typical Javascript based front-ends)


### Example of Controller

```java
@Controller
public class HelloController{

	@RequestMapping("/hello")
	public ModelAndView sayHello(){
		return new ModelAndView(
			"hello","msg",
			"Welcome to Spring MVC"
		);
	}
}
```

### Example of RestController

```java
@RestController 
public class HelloController{
@RequestMapping("/hello")
	public String sayHello(){
		return "Welcome to Spring REST";
	}
}
```
### Example of Controller with No VIEW 
```java
@Controller 
public class HelloController{
@RequestMapping("/hello")
	public @ResponseBody String sayHello(){
		return "Welcome to Spring REST";
	}
}
```