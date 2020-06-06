<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">

    <title>E Commerce</title>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js" > </script>


    <link href="http://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>

    <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">



</head>
<body style="background-color: #c4e3f3">
<nav class="navbar navbar-inverse" >
    <div class="container-fluid" style="margin: auto">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value="/" />">Shopping Website</a>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/displayallitems" />">All items</a></li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a> ${pageContext.request.userPrincipal.name}'s page</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>


                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name  == null}">
                    <li><a href="<c:url value="/signin" />">Login</a></li>
                     <li>   <a href="<c:url value="/signupsm" />" >ShopManager register</a></li>
                    <li>  <a href="<c:url value="/signupuser" />">User Register</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>




<div class="container">

            <h1 align="center">Sign in</h1>

            <c:if test="${not empty i}">
                  <h4 align="center" style="color: #4cae4c">${i}</h4>
            </c:if>


            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
                <br>
                <c:if test="${not empty r}">
                    <h4 align="center" style="color: #c9302c">${r}</h4>
                </c:if>

                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  Username</label>
                    <div class="col-sm-10" >
                        <input type="text" class="form-control" name="username" id="username" placeholder="Username" required>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">&emsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Password</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" id="password" placeholder="password" required>
                    </div>
                </div>



               &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <input type="submit" value="Sign in" class="btn btn-default" align="center">&emsp;&emsp;
            </form>



</div>
