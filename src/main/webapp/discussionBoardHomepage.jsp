<%-- 
    Document   : newPost
    Created on : Jul 25, 2015, 5:45:44 PM
    Author     : cameronthomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Discussion Board Homepage</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/navbar-static-top/navbar-static-top.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   
    <script type="text/javascript">
        function validateThreadName()
        {
           var validThreadName = true;
           var threadName = $("#threadNameTextbox").val()
            
            // Check if text box is empty or is just spaces
            if (threadName===null || threadName.trim()==="" 
                    || threadName === undefined) {    
                validThreadName = false;
            }
            
            return validThreadName;
        }
    </script>
  </head>

  <body>

    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div>         
            <label class="navbar-brand">Discussion Board</label>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          
          <ul class="nav navbar-nav navbar-right">
            
            <li><a href="signIn.html">Sign Out</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>


    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Discussion Threads</h1>
<!--        <div class="list-group">
            <a href="CreateThreadsPage?threadName=test" class="list-group-item">Test</a>
        </div>-->
        ${noThreadsLabel}
        <c:forEach var="thread" items="${threadList}">       
                <a href="ViewPostsPage?threadName=${thread[0]}&username=${username}" class="list-group-item">
                   <h4>${thread[0]}</h4> 
                            ${thread[1]} <br />
                            ${thread[2]}
                </a>
        </c:forEach>
        <%--<c:out value="${username}"/>--%>
<!--        <h3 visibility="${threadListStatus}">There are no current threads</h3>-->
        <br />
        <div class="form-group">
            <form method="POST" onsubmit="return validateThreadName()"  action="CreateThread">
                <h3 for="usr">Add a new thread</h3>
                <input type="text" class="form-control" id="threadNameTextbox" name="threadName" placeholder="Enter name of new thread"/>
                <input type="hidden" name="username" value="${username}"/>
                <br />
                <button type="submit" class="btn btn-primary">Add Thread</button>
                <!--<button type="button" class="btn btn-danger">Delete All Threads</button>-->
            </form>
                <br />
            ${deleteButton}
            
        </div>
      </div>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

