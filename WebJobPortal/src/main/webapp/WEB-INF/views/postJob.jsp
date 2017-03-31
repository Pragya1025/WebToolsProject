<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post Job</title>
</head>
<body>
<a href="logout.htm">Logout</a><br/>
<div class="container">


      <form:form commandName="jobs" method="post" action="postJob.htm">
        <h2>Post Job</h2>
		
        
		<div>
       <label>Job Title</label>
        <form:input path="jobtitle" /><font color="red"><form:errors path="jobtitle"/></font><br/>
        <label>Job Description</label>
        <form:input path="jobdescription" /><font color="red"><form:errors path="jobdescription"/></font><br/>
        <label>Skills</label>
         <form:input path="skills" /><font color="red"><form:errors path="skills"/></font><br/>
         <label>Salary</label>
         <form:input path="salary" /><font color="red"><form:errors path="salary"/></font><br/>
         <label>Location</label>
       <form:input path="location" /><font color="red"><form:errors path="location"/></font><br/>
		</div>
		
		 <button class="btn btn-lg btn-primary btn-block" type="submit">Post Job</button>
      </form:form>
</div>
  
  </body>
</html>

