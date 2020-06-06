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
                <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                    <li><a href="<c:url value="/apage" />">${pageContext.request.userPrincipal.name}</a></li>
                </c:if>
                <c:forEach items="${sales}" var="s">

                    <c:if test ="${pageContext.request.userPrincipal.name == s.uname }">
                        <li><a href="<c:url value="/shop/${pageContext.request.userPrincipal.name}" />">${pageContext.request.userPrincipal.name}</a></li>
                    </c:if>
                </c:forEach>

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
    <div class="row" align="center">
        <h1>Complete information of the Item</h1>
    </div>
       <br>
        <div class="block" >
                <div class="col-xs-6">
                    <img src="<c:url value="/resources/pictures/${item.itemsId}.png" /> " alt="image"
                         style="width:100%"/>
                </div>

                <div class="col-xs-6">
                    <h2> <p> Name : ${item.iName} </p></h2>
                    <h2> <p> Description : ${item.iInformation}</p> </h2>
                    <h2> <p> Brand : ${item.iBrand} </p> </h2>
                    <h2> <p> Item Type : ${item.iTypeOfProduct} </p> </h2>
                    <h2> <p> Item Price : ${item.iPrice} </p> </h2>
                    <h2> <p> No of items in stock : ${item.itemAvailable} </p> </h2>

                    <br>

                    <p ng-controller="cartCtrl" >
                        <a href="<spring:url value="/displayallitems" />" class="btn btn-default">Back</a>

                    <form:form action="/shoppingwebsite/display/item/${item.itemsId}/${pageContext.request.userPrincipal.name}" method="post">
                    <c:if test="${not empty s}">
                        <div class="msg">${s}</div>
                    </c:if>

                    <c:forEach items="${consumers}" var="c">

                        <c:if test ="${pageContext.request.userPrincipal.name == c.uname }">
                            <input type="submit" value="order" class="btn btn-default" />
                        </c:if>

                    </c:forEach>

                    </form:form>
                    <c:if test ="${pageContext.request.userPrincipal.name == null }">
                        <a href="<c:url value="/signin" />" class="btn btn-default">Order</a>
                    </c:if>
                    <c:forEach items="${consumers}" var="c">

                        <c:if test ="${pageContext.request.userPrincipal.name == c.uname }">
                            <a href="<spring:url value="/vieworder/${pageContext.request.userPrincipal.name}" />"
                               class="btn btn-default">View Cart</a>
                        </c:if>
                    </c:forEach>

                    </p>
                </div>

        </div>

    </div>
</div>
</body>
