<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>




<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    
 
    <meta name="description" content="">
   

    <title>Sign Up</title>

  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>  

  </head>
    

  <body>

    <div class="container">
<div class="col-md-6">

      <form:form  name="myForm" method="post" action="createUserDetails.htm" commandName="person">
        <h2 class="form-signin-heading">New User</h2>
		
        
		
        <label for="inputName" class="col-md-6">Username</label>
        <form:input path="user.username" name="username" /><form:errors path="user.username"/><br/><br/>
		
		  <label for="inputName" class=" col-md-6">Email Address</label>
        <form:input path="email" name="email" type="email"/><br/><form:errors path="email"/><br/><br/>
		
		  <label for="inputPassword" class="col-md-6">Password</label>
        <form:password path="user.password" name="password"/><br/><form:errors path="user.password"/><br/><br/>
		
		<label for="inputName" class=" col-md-6">Phone Number</label>
        <form:input path ="phoneNumber" name="phonenumber"/><br/><form:errors path="phoneNumber"/><br/><br/>
		
		 <label for="inputPassword" class="col-md-6">Address</label>
		 <form:input path ="address" name="address"/><br/><form:errors path="address"/><br/><br/>
		 
		<label for="inputPassword" class="col-md-6">Role</label>
		<form:select path="user.role" ><br/><br/>
		
	<option value="jobSeeker">Job Seeker</option>
  <option value="employer">Employer</option>
 
  </form:select><br/><br/>
		 <button class="btn btn-lg btn-primary btn-block" type="submit">Create Account</button>
      </form:form>
</div>
    </div> <!-- /container --> 
  </body>
</html>