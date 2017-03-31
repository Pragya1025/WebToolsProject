<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    
 
    <meta name="description" content="">
   

    <title>Signin</title>

  <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>  
 
 <script type="text/javascript">
    function validateForm()
    {
    var a=document.forms["Form"]["username"].value;
    var b=document.forms["Form"]["password"].value;
    if (a==null || a=="",b==null || b=="")
      {
      alert("Please Fill All Required Field");
      return false;
      }
    }
    </script>
  </head>

  <body>
  
    
<form:form action="signIn.htm" name="Form" onsubmit="return validateForm()" commandName="user" method="post">
    <div class="container">
<div class="col-md-6">
      
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" name="username" class="sr-only">Email address</label>
         <input type="username" name="username"/><font color="red"><form:errors path="username"/></font><br/><br/>
        
        <label for="inputPassword" name="password" class="sr-only">Password</label>
      <input  type="password" name="password"/><br/><font color="red"><form:errors path="password"/></font><br/><br/>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
		<div class="forgot">
		
          
            New User?/  </a><a href="createUser.htm" >Create Login</a>
          
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
     
</div>
    </div> <!-- /container --> 
    </form:form>
    
    
    
  </body>
</html>