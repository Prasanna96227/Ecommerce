<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<jsp:useBean id="now" class="java.util.Date" />


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order</h1>

            <p class="lead">Order confirmation</p>
        </div>

        <div class="container">

            <div class="row">

                <form:form commandName="order" class="form-horizaontal">

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
                                                <input type="text" class="form-control"  />
                                            </div>
                                        </div>
                                        <div class="row ">
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <span class="help-block text-muted show"> Expiry Month</span>
                                                <input type="text" class="form-control"  />
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <span class="help-block text-muted show"> Expiry Year</span>
                                                <input type="text" class="form-control" />
                                            </div>

                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <span class="help-block text-muted show">Enter CCV</span>
                                                <input type="text" class="form-control" />
                                            </div>
                                        </div>
                                        <br/>
                                        <div class="row ">
                                            <div class="col-md-12 pad-adjust">
                                                <input type="text" class="form-control" placeholder="Name On The Card" />
                                            </div>
                                        </div>
                                        <br/>
                                        <input type="hidden" name="_flowExecutionKey" />
                                        <div class="row ">
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <input type="submit" value="Submit" class="btn btn-default"
                                                       name="_eventId_orderConfirmed"/>
                                            </div>
                                            <div class="col-md-3 col-sm-3 col-xs-3">
                                                <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
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


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
