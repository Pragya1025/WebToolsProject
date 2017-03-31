<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Job</title>
</head>
<body>
<a href="logout.htm">Logout</a><br/>

<div class="container">


     
        <h1>Welcome <c:out value = "${sessionScope.userName}"></c:out></h1>
		
		 <a href="postJob.htm">Post Job</a>
		 <a href="Search.jsp">Search Job</a>
      
</div>
  
  </body>
</html>