<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                    <li><a href="<c:url value="/signupsm" />">ShopManager register</a></li>
                    <li><a href="<c:url value="/signin" />">Login</a></li>
                    <li><a href="<c:url value="/signupuser" />">User Register</a></li>

                </c:if>
            </ul>
        </div>
    </div>
</nav>



<div class="container-wrapper">
    <div class="container">
        <form:form action="/shoppingwebsite/payment/${no}" modelAttribute="s" class="form-horizaontal">

        <h3 align="center">confirm the details</h3>
            <br><br><br><br>

        <div class="form-group row">
            <label for="fname" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;First Name</label>
            <div class="col-sm-10">
            <form:input path="cFirstName" id="fname" class="form-Control"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="lname" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Last Name</label>
            <div class="col-sm-10">
                <form:input path="cLastName" id="lname" class="form-Control"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="e" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Email</label>
            <div class="col-sm-10">
            <form:input path="cEmail" id="e" class="form-Control"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="p" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Mobile</label>
            <div class="col-sm-10">
            <form:input path="cPhone" id="p" class="form-Control"/>
            </div>
        </div>
<br>
        <h3 align="center">Address</h3>
<br><br>
        <div class="form-group row">
            <label for="street" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;Street Name</label>
            <div class="col-sm-10">
            <form:input path="streetAddress" id="street" class="form-Control"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="no" class="col-sm-2 col-form-label">&emsp;&emsp;Apartment Number</label>
            <div class="col-sm-10">
            <form:input path="aptNumber" id="no" class="form-Control"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="city" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;City</label>
            <div class="col-sm-10">
            <form:input path="city" id="city" class="form-Control"/>
            </div>
        </div>

        <div class="form-group row">
            <label for="state" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;State</label>
            <div class="col-sm-10">
            <form:input path="state" id="state" class="form-Control"/>
            </div>
        </div>


        <div class="form-group row">
            <label for="zipcode" class="col-sm-2 col-form-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Zipcode</label>
            <div class="col-sm-10">
            <form:input path="zipCode" id="zipcode" class="form-Control"/>
            </div>
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br><br>
        <input type="submit" value="Next" class="btn btn-default pull-right"  />
        <a href="<spring:url value="/vieworder/${pageContext.request.userPrincipal.name}" />" class="btn btn-default ">Back</a>
        </form:form>

