<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<script>

    $(document).ready( function () {
        $('.table').DataTable();
    } );
</script>


<div class="container-wrapper">
    <div class="container">
            <br/>  <br/> <br/> <br/>
            <p class="lead">The below are the available Products</p>


        <table class="table table-bordered" >
            <thead>
            <tr class="bg-primary">
                <th>Image</th>
                <th>Product Name</th>
                <th>Category</th>
                <th></th>
            </tr>
            </thead>

            <c:forEach items="${products}" var="product">

                <tr>
                    <td width= "200px" height="160px"><img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image"
                                                           width= "200px" height="160px" /></td>
                    <td align="center" width= "200px" height="160px">${product.productName}</td>
                    <td align="center" width= "200px" height="160px">${product.productCategory}</td>
                    <td align="center" width= "200px" height="160px"><a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                    >View product</a></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>


