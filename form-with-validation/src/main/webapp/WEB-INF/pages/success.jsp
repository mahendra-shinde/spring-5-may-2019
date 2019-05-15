<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Everything inside curly braces is CaseSensitive !
	If value is NULL, then it prints nothing!
	 -->
<h2>${message}</h2>
	<!-- customer.lastName is translated into customer.getLastName() -->
Customer : ${customer.lastName } ${customer.firstName}
</body>
</html>