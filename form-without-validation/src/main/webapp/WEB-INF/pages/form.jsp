<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  Spring FORM tags uses "modelAttribute"
	Which must MATCH with both showForm and submitForm
	methods from CustomerController class -->
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
</body>
</html>