<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply Job</title>


</head>
<body>
<a href="logout.htm">Logout</a><br/>
<form action="searchJobByValue.htm" method="post">
Job Search: <input type="text" name="searchValue">

<input type="radio" name="searchBy" id="one" value="jobTitle" >Job Title
<input type="radio" name="searchBy" id="two" value="jobId" checked>Job Id
<input type="radio" name="searchBy" id="three" value="jobLocation">Job Location<br/>
<input type="submit" name="submit" value="Go" ><br/>
</form>

 <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>Job ID</b></td>
                <td><b>Job Title</b></td>
                <td><b>Job Description</b></td>
                <td><b>Salary</b></td>
                <td><b>Skills</b></td>
                
                <td><b>Location</b></td>
                <td><b>Apply</b></td>
            </tr>
            <c:forEach var="job" items="${jobs}">
                <tr>
                    <td>${job.jobid}</td>
                    <td>${job.jobtitle}</td>
                    <td>${job.jobdescription}</td>
                    <td>${job.salary}</td>
                    <td>${job.skills}</td>
                    <td>${job.location}</td>
                   <td><a href ="<c:url value="/ApplyNewJob.htm?id=${job.jobid}"/>">Apply</a></td> 
                </tr>
            </c:forEach>
            
        </table>
    


</body>
</html>