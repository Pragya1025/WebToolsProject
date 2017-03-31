<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
	
	
	<script>
        function registrationFormDisplay() {
            if (document.getElementById("registrationForm").style.display == "none") {
                document.getElementById("registrationForm").style.display = "block";
                document.getElementById("myForm").reset();
                document.getElementById("success").innerHTML = "";
                document.getElementById("searchForm").style.display = "none"
            } else {
                document.getElementById("registrationForm").style.display = "none"
            }
        }

        function searchFormDisplay() {
            if (document.getElementById("searchForm").style.display == "none") {
                document.getElementById("searchForm").style.display = "block";
                document.getElementById("search").reset();
                document.getElementById("results").innerHTML = "";
                document.getElementById("registrationForm").style.display = "none";
            } else {
                document.getElementById("searchForm").style.display = "none";
            }
        }

        //AJAX

        var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function saveUser() {
          if (xmlHttp == null){
              alert("Your browser does not support AJAX");
              return;
          }
          var jobID= document.getElementById("jobID").value;
          var title= document.getElementById("title").value;
          var description= document.getElementById("description").value;
          var skills = document.getElementById("skills").value;
          var salary = document.getElementById("salary").value;
		  var date = document.getElementById("date").value;
		  var email = document.getElementById("email").value;
		  var location = document.getElementById("location").value;
          
          
          var query= "jobID="+jobID+"&title="+title+"&description="+descriptionr+"&skills="+skills+"&salary="+salary+"&date="+date+"&email="+email+"&location="+location;
                  xmlHttp.onreadystatechange= function statechanged()
          {
              if(xmlHttp.readyState==4){
                  var json=JSON.parse(xmlHttp.responseText);
                  document.getElementById("success").innerHTML= json.successmsg;
              }
          };
          
          xmlHttp.open("post","register.htm",true);
          xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
          xmlHttp.send(query);
          return false;
          
        }

        function getResults() {
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var key = document.getElementById("name").value;
            var flag = document.querySelector('input[name = "search"]:checked').value;
            var query = "action=searchuser&key=" + key.trim() + "&flag=" + flag.trim();
            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    document.getElementById("results").innerHTML = "";
                    var json = JSON.parse(xmlHttp.responseText);
                    if (json.users.length > 0) {
                        var x = document.createElement("TABLE");
                        x.setAttribute("id", "myTable");
                        document.getElementById("results").appendChild(x);
                        var y = document.createElement("TR");
                        y.setAttribute("id", "myTr");
                        document.getElementById("myTable").appendChild(y);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("jobID");

                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("title");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("description");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("skills");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);
						
						var z = document.createElement("TH");
                        var t = document.createTextNode("salary");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);
						
						var z = document.createElement("TH");
                        var t = document.createTextNode("date");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);
						
						var z = document.createElement("TH");
                        var t = document.createTextNode("email");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);
                        
                        var z = document.createElement("TH");
                        var t = document.createTextNode("location");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        var z = document.createElement("TH");
                        var t = document.createTextNode("Delete");
                        z.appendChild(t);
                        document.getElementById("myTr").appendChild(z);

                        for (var count = 0; count < json.users.length; count++) {
                            var y = document.createElement("TR");
                            y.setAttribute("id", "myTr" + count);
                            document.getElementById("myTable").appendChild(y);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].jobID);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].title);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].description);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);
                            
                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].skills);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);
                            
                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].salary);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);
                            
                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].date);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);
                            
                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].location);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var t = document.createTextNode(json.users[count].email);
                            z.appendChild(t);
                            document.getElementById("myTr" + count).appendChild(z);

                            var z = document.createElement("TD");
                            var a = document.createElement('a');
                            var id = json.users[count].id;
                            var rowID = "myTr" + count;
                            var linkText = document.createTextNode("Delete");
                            a.appendChild(linkText);
                            a.title = "Delete";
                            a.onclick = (function (id, rowID) {
                                return function () {
                                    deleteRow(id, rowID);
                                }
                            })(id, rowID);
                            z.appendChild(a);
                            document.getElementById("myTr" + count).appendChild(z);
                        }
                    } else {
                        document.getElementById("results").innerHTML="Nothing Found";
                    }
                }
            };
            xmlHttp.open("POST", "searchjob.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            return false;
        }

        function deleteRow(userID, rowID) {
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }

            var query = "action=delete&user=" + userID;

            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    var row = document.getElementById(rowID);
                    row.parentNode.removeChild(row);
                }
            };
            xmlHttp.open("POST", "searchjob.htm", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);
            return false;
        }

        function GetXmlHttpObject()
        {
            var xmlHttp = null;
            try
            {
                // Firefox, Opera 8.0+, Safari
                xmlHttp = new XMLHttpRequest();
            } catch (e)
            {
                // Internet Explorer
                try
                {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e)
                {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
            }
            return xmlHttp;
        }
    </script>
	
	
 <body>
         <button onclick="registrationFormDisplay()">Post Job</button><br><br>
        <button onclick="searchFormDisplay()">Search Job</button><br><br>
        <div id="registrationForm" style="display: none;">
            <h3>Job Form</h3>
            <form onsubmit="return saveJob();" id="myForm" action="postnSearch.htm" method="POST" enctype="multipart/form-data">
			      Job ID : <input id="jobId" type="text" required/><br><br>
                  Job Title : <input id="title" type="text" required/><br><br>
  			      Job description : <input id="description" type="text" required/><br><br>
				  Skills : <input id="skills" type="text" required/><br><br>
				  Salary : <input id="salary" type="text" required/><br><br>
				  Location : <input id="location" type="text" required/><br><br>
				  Date : <input id="date" type="text" required/><br><br>
				  Contact Email : <input id="email" type="text" required/><br><br>

            

                <input type="submit" name="Post Job">Post Job<br/><br/>

            </form>
        </div>

        <div id="searchForm" style="display: none;">
            <h3>Search Form</h3>
            <form id="search" onsubmit="return getResults();">

                Search Job<input type="text" id="name" name="job" required /> <br><br>

                <label>Search By:</label>
                <input type="radio" name="search" value="jobID" > Job ID
                <input type="radio" name="search"  value="title">Job Title
                <input type="radio" name="search"  value="location">Location
                <input type="radio" name="search"  value="description">Job Description
                <input type="radio" name="search"  value="salary">Salary<br><br>
                <input type="submit" name="search"/>Search<br><br>
            </form>
            <div id="results">

            </div>
        </div>
    </body>
</html>