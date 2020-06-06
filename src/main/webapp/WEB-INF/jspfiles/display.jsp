<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<body  style="background-color: #c4e3f3">
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
                    <li><a href="<c:url value="/signupsm" />">ShopManager register</a></li>
                    <li><a href="<c:url value="/signin" />">Login</a></li>
                    <li><a href="<c:url value="/signupuser" />">User Register</a></li>

                </c:if>
            </ul>
        </div>
    </div>
</nav>




<div class="container">
    <br/>

    <h1 align="center">Users list</h1>

    <br/> <br/>

        <table class="table table-bordered" style="background-color: snow">
            <thead>
            <tr class="bg-info">
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Username</th>

            </tr>
            </thead>
            <c:forEach items="${l}" var="display">
                <tr>
                    <td>${display.fname}</td>
                    <td>${display.lname}</td>
                    <td>${display.cEmail}</td>
                    <td>${display.cPhone}</td>
                    <td>${display.uname}</td>
                </tr>
            </c:forEach>
        </table>

        <h4>
            <c:if test ="${pageContext.request.userPrincipal.name != 'admin' }">
            <a href="<c:url value="/shop/${pageContext.request.userPrincipal.name}" />" class="btn btn-default">Back</a>
            </c:if>
            <c:if test ="${pageContext.request.userPrincipal.name == 'admin' }">
            <a href="<c:url value="/apage" />" class="btn btn-default">Back</a>
            </c:if>

        </h4>
