<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

                </c:if>
            </ul>
        </div>
    </div>
</nav>




<div class="container">
    <br/>
    <h2 align="center">User registration form</h2>

    <br/> <br/>

        <form:form action="/shoppingwebsite/signupuser" method="post"
                   modelAttribute="customer">

    <div class="form-group row">
        <label for="f" class="col-sm-2 col-form-label"> First Name</label>
        <div class="col-sm-10">
            <form:input path="cFirstName" id="f" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="l" class="col-sm-2 col-form-label">Last Name</label>
        <div class="col-sm-10">
            <form:input path="cLastName" id="l" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="e" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <form:input path="cEmail" id="e" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="p" class="col-sm-2 col-form-label">Phone</label>
        <div class="col-sm-10">
            <form:input path="cPhone" id="p" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="username" class="col-sm-2 col-form-label">User Name</label>
        <div class="col-sm-10">
            <form:input path="uname" id="username" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-10">
            <form:password path="pword" id="password" class="form-Control"/>
        </div>
    </div>

        <h3 align="center">Address</h3>

    <div class="form-group row">
        <label for="street" class="col-sm-2 col-form-label">Street Name</label>
        <div class="col-sm-10">
            <form:input path="streetAddress" id="street" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="anum" class="col-sm-2 col-form-label">Apartment Number</label>
        <div class="col-sm-10">
            <form:input path="aptNumber" id="anum" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="city" class="col-sm-2 col-form-label">City</label>
        <div class="col-sm-10">
            <form:input path="city" id="city" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="state" class="col-sm-2 col-form-label">State</label>
        <div class="col-sm-10">
            <form:input path="state" id="state" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="zipcode" class="col-sm-2 col-form-label">Zip Code</label>
        <div class="col-sm-10">
            <form:input path="zipCode" id="zipcode" class="form-Control"/>
        </div>
    </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/signin" />" class="btn btn-default">Cancel</a>
        </form:form>



