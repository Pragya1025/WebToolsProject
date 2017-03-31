<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
Job Portal
</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
</head>

<body>

   <div class="container-fixed">
   
 <div class="row">
 <div class="col-md-12">

<nav class="navbar navbar-default ">
 
  <div class="navbar-header">
    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><img src="resources/images/logo.jpg" alt="logo"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">Resume</a></li>
        <li><a href="#">Resources</a></li>
		<li><a href="postjob.htm">Employers/Post Job</a></li>
		<form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <button type="button" class="btn btn-default">
          <span class="glyphicon glyphicon-search"></span>Search Jobs<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br/>
		   <button type="button" class="btn btn-default">
          <span class="glyphicon glyphicon-map-marker"></span>Location
        </div>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Companies</a></li>
        <li class="dropdown">
           <a href="adduser.htm" ><span class="glyphicon glyphicon-user"></span>Login</a>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  
</nav>
</div>
</div>
<div class="row">
		<div class="col-md-12">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
						  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						  <li data-target="#myCarousel" data-slide-to="1"></li>
						  <li data-target="#myCarousel" data-slide-to="2"></li>
						  <li data-target="#myCarousel" data-slide-to="3"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">

						  <div class="item active">
							<img src="resources/images/carousel1.jpg" alt="snow" width="1500" height="400">
							<div class="carousel-caption">
							  <h3>Tech News</h3>
							  <p>10 key tips to help you land an exec gig</p>
							</div>
						  </div>

						  <div class="item">
							<img src="resources/images/carousel2.jpg" alt="windy"width="1500" height="400">
							<div class="carousel-caption">
							  <h3>Together We Know More</h3>
							  <p>This green energy field has had record job openings in 2016</p>
							</div>
						  </div>
						
						  <div class="item">
							<img src="resources/images/carousel3.jpg" alt="cloudy" width="1500" height="400" >
							<div class="carousel-caption">
							  <h3>Data as Design</h3>
							  <p>How being ‘original’ will help you land your next job</p>
							</div>
						  </div>

						  <div class="item">
							<img src="resources/images/carousel4.jpg" alt="sunny" width="1500" height="400">
							<div class="carousel-caption">
							  <h3>An Alternative Outlook</h3>
							  <p>What recruiters really wish job seekers knew</p>
							</div>
						  </div>
					  
						</div>

						<!-- Left and right controls -->
						<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
						  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						  <span class="sr-only">Previous</span>
						</a>
						<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
						  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						  <span class="sr-only">Next</span>
						</a>
					  </div>
		</div><!--end of carousel div-->
	</div>
	
			
			
			<div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
          <img class="img-rounded" src="resources/images/tech.JPG" alt="tech" width="140" height="140">
          <h2>Tech News</h2>
          <p>5 programming languages that every techie should master</p>
          <p><a  class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="resources/images/grad.JPG" alt="grad" width="140" height="140">
          <h2>Job Search</h2>
          <p>5 job search tricks every grad should know</p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-rounded" src="resources/images/dream.JPG" alt="dream job" width="140" height="140">
          <h2>Market Info</h2>
          <p>The job market continued to expand in April, thanks to these industries</p>
          <p><a  class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->


  

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">Best places to work<span class="text-muted">   2016 Employer's choice award</span></h2>
          <p class="lead">Employees' Choice Awards honor the Best Places to Work across North America and parts of Europe. Winners are determined by the people who know these companies best—their employees.</p>
        </div>
        <div class="col-md-5">
          <img src="resources/images/office.jpg"  class="img-rounded"alt="office">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading">Top Companies for <span class="text-muted"> Culture & Values.</span></h2>
          <p class="lead">Want to work for a company where employees are satisfied with the culture and values? Glassdoor has announced its report of the Top 25 Companies for Culture & Values, based on workplace insights shared by the people who know companies best – the employees. The following companies stand out for high culture & values ratings and insightful reviews.</p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img src="resources/images/collegues.jpg"  class="img-rounded"alt="colleagues">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading">25 Best Jobs <span class="text-muted">in America </span></h2>
          <p class="lead">Want a new job? Online Jobs is here to help, identifying the 25 Best Jobs in America for 2016. The jobs that make this list have the highest overall Online Job Score, determined by combining three key factors – number of job openings, salary and career opportunities rating.</p>
        </div>
        <div class="col-md-5">
          <img src="resources/images/bestoffice.jpg"  class="img-rounded"  alt="Best Jobs ">
        </div>
      </div>

      <hr class="featurette-divider">

      
	
	<footer>
    <div class="navbar navbar-default ">

		<div class="row">
		<div class="col-md-12 footer4">
			<div class="col-md-6">
				<span>For Employers:  Post Jobs |Search| Resumes |Advertise</span>
				<span>About Online Jobs| Career|Contact Us</span>
				<span>Terms of Use Privacy Center |Accessibility Center| Help |Security </span>
				<span>Copyright © 2016 Online Jobs Worldwide (NYSE: MWW)</span>
			</div>
			<div class="col-md-6">
				<img src="resources/images/social.JPG" alt="OnlineJobPortal">
			</div>
		</div>
	</div>

	</div>
	</footer>
	
</div><!-- /.container-fluid -->
</body>
</html>