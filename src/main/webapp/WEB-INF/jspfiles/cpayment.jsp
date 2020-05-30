<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="page-header">
            <h1 align="center">Enter Card information</h1>
        </div>

        <div class="container">

            <div class="row">

                <form:form action="/shoppingwebsite/orderplaced/${no}"  class="form-horizaontal">

                    <div class="row">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="credit-card-div">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <h5 class="text-muted"> Credit Card Number</h5>

                                            </div>
                                            <div class="col-md-12 pad-adjust">
                                                <input type="text" class="form-control" required />
                                            </div>
                                        </div>
                                        <div class="row ">
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <span class="help-block text-muted show"> Expiry Month</span>
                                                <input type="text" class="form-control" required />
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <span class="help-block text-muted show"> Expiry Year</span>
                                                <input type="text" class="form-control" required/>
                                            </div>

                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <span class="help-block text-muted show">Enter CCV</span>
                                                <input type="text" class="form-control" required/>
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row ">
                                            <div class="col-md-12 pad-adjust">
                                                <input type="text" class="form-control" placeholder="Name On The Card"  required/>
                                            </div>
                                        </div>
                                        <br/>
                                        <input type="hidden" name="_flowExecutionKey" />
                                        <div class="row ">
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <a href="<spring:url value="/displayallitems" />" class="btn btn-default">Cancel</a>
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <input type="submit" value="Submit" class="btn btn-default" />
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <a href="<spring:url value="/buyitem/${no}" />" class="btn btn-default">Back</a>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>
