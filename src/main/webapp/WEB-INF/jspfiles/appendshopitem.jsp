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
                    <li><a href="<c:url value="/signupsm" />">ShopManager register</a></li>
                    <li><a href="<c:url value="/signin" />">Login</a></li>
                    <li><a href="<c:url value="/signupuser" />">User Register</a></li>

                </c:if>
            </ul>
        </div>
    </div>
</nav>




<div class="container">
    <h2>Add item</h2>

        <form:form action="/shoppingwebsite/appendshopitem" method="post"

                   modelAttribute="items" enctype="multipart/form-data">
    <div class="form-group row">
        <label for="itemn" class="col-sm-2 col-form-label">Item Name</label>
        <div class="col-sm-10">
            <form:input path="iName" id="itemn" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="type" class="col-sm-2 col-form-label">Type of product &emsp; &emsp;</label>
        <div class="col-sm-10">
            <form:select path = "iTypeOfProduct" cssClass="btn btn-default">
                <form:option value = "NONE" label = "Select" id="type" />
                <form:options items = "${typeofitem}" id="type" />
            </form:select>
        </div>
    </div>

    <div class="form-group row">
        <label for="info" class="col-sm-2 col-form-label">Information</label>
        <div class="col-sm-10">
            <form:input path="iInformation" id="info" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="cost" class="col-sm-2 col-form-label">Cost</label>
        <div class="col-sm-10">
            <form:input path="iPrice" id="cost" class="form-Control"/>
        </div>
    </div>

        <form:input type="hidden" path="typeofperson" id="type" value = "${pageContext.request.userPrincipal.name}"/>

    <div class="form-group row">
        <label for="i" class="col-sm-2 col-form-label">No of Available Items</label>
        <div class="col-sm-10">
            <form:input path="itemAvailable" id="i" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label for="brand" class="col-sm-2 col-form-label">Brand Name</label>
        <div class="col-sm-10">
            <form:input path="iBrand" id="brand" class="form-Control"/>
        </div>
    </div>

    <div class="form-group row">
        <label  for="picture" class="col-sm-2 col-form-label">Add Image</label>
        <div class="col-sm-10">
            <form:input id="picture" path="iImage" type="file" class="form:input-large" />
        </div>

    </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/shop/itemmodifications/${pageContext.request.userPrincipal.name}" />" class="btn btn-default">Cancel</a>
        </form:form>
