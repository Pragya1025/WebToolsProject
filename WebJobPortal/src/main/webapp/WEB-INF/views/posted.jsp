<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Job has been posted Successfully</title>
    </head>
    <body>
    
    <a href="logout.htm">Logout</a><br/>
        New Job Posted Successfully: ${jobs.jobtitle}<br/>
        
        <a href="postJob.htm">Add Another Job</a><br/>
        <a href="#">View Application</a><br/>
        
    </body>
</html>