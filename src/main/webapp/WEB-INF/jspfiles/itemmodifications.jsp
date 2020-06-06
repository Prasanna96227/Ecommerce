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



<script>

    $(document).ready( function () {
        $('.table').DataTable();
    } );
</script>

<div class="container">
    <div class="row">
        <br/>
        <h1 align="center" >Item Modifications page</h1>

        <br/> <br/>
        <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
            <a href="<spring:url value="/append" />" class="btn btn-default">Add Item</a>
        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name  != 'admin'}">
            <a href="<spring:url value="/appendshopitem" />" class="btn btn-default">Add Item</a>
        </c:if>

            <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                <a href="<c:url value="/apage" />" class="btn btn-default pull-right">Back</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name  != 'admin'}">
                <a href="<c:url value="/shop/${pageContext.request.userPrincipal.name}" />" class="btn btn-default pull-right">Back</a>
            </c:if>


<br><br>

        <table class="table table-bordered" style="background-color: snow">
            <thead>
            <tr class="bg-info">
                <th>Picture</th>
                <th>Name</th>
                <th>Type of Item</th>
                <th>modify item</th>
            </tr>
            </thead>
            <c:forEach items="${item}" var="i">
                <tr>
                    <td width= "200px" height="160px"><img src="<c:url value="/resources/pictures/${i.itemsId}.png" /> " alt="image"
                                                           width= "200px" height="160px"/></td>
                    <td align="center" width= "200px" height="160px">${i.iName}</td>
                    <td align="center" width= "200px" height="160px">${i.iTypeOfProduct}</td>
                    <td align="center" width= "200px" height="160px">
                        <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                            <a href="<spring:url value="/update/${i.itemsId}" />" class="btn btn-default">update</a>
                        <a href="<spring:url value="/removeitem/${i.itemsId}" />" class="btn btn-default">delete</a>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name  != 'admin'}">

                            <a href="<spring:url value="/updateshopitem/${i.itemsId}" />"  class="btn btn-default">update</a>
                            <a href="<spring:url value="/removeshopitem/${i.itemsId}" />" class="btn btn-default">delete</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </div>
</div>
