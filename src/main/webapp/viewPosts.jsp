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

    <title>Static Top Navbar Example for Bootstrap</title>

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
  </head>

  <body>

    <!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div>
            <label class="navbar-brand">Discussion Board</lable>
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
        <h1>${threadName}</h1>
        
        ${noPostsLabel}
        
        <c:forEach var="post" items="${postList}">       
                <span class="list-group-item">
                   <h4>${post[1]}</h4> 
                       ${post[2]}<br /><br />
                       ${post[0]}
                </span>
        </c:forEach>

        <br />
        <div class="form-group">
                <h4 for="usr">Add a new Post</h4>
                <form method="POST" action="CreatePost">
                    <textarea class="form-control" name="postData" rows="6" placeholder="Enter a post"></textarea>
                    <input type="hidden" name="username" value="${username}"/>
                    <input type="hidden" name="threadName" value="${threadName}"/>

                <br />
                <button type="submit" class="btn btn-primary">Add Post</button>
                <!--<button type="button" class="btn btn-danger">Delete All Threads</button>-->
            </form>
                    <br />
            ${deleteButton}
        </div>
      </div>
<a class="navbar-brand" href="ViewThreadsPage?username=${username}">Discussion Board Home</a>
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

