<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <title>Edit Motor</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Edit Motor</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
                        <form id="formSubmit">
                           
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Inception Date</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="inceptionDate" name="inceptionDate" value="${model.inceptionDate}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Expiry Date</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="expiryDate" name="expiryDate" value="${model.expiryDate}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Policy Owner</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="policyOwner" name="policyOwner" value="${model.policyOwner}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Engine No</label>
                                <div class="col-sm-9"> 
                                	<input type="text" class="form-control" id="engineNo" name="engineNo" value="${model.engineNo}"/>                                
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Chassis No</label>
                                <div class="col-sm-9">                                 
                                	<input type="text" class="form-control" id="chassisNo" name="chassisNo" value="${model.chassisNo}"/> 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Vehicle Registration No</label>
                                <div class="col-sm-9">
                                	<input type="text" class="form-control" id="vehicleRegistrationNo" name="vehicleRegistrationNo" value="${model.vehicleRegistrationNo}"/>                                  
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Billing Currency</label>
                                <div class="col-sm-9"> 
                                	<input type="text" class="form-control" id="billingCurrency" name="billingCurrency" value="${model.billingCurrency}"/>                                 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Sum Insured</label>
                                <div class="col-sm-9">  
                                	<input type="text" class="form-control" id="sumInsured" name="sumInsured" value="${model.sumInsured}"/>                                
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Rate</label>
                                <div class="col-sm-9">    
                                	<input type="text" class="form-control" id="rate" name="rate" value="${model.rate}"/>                              
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Annual Premium</label>
                                <div class="col-sm-9">  
                                	<input type="text" class="form-control" id="annualPremium" name="annualPremium" value="${model.annualPremium}"/>                                
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Posted Premium</label>
                                <div class="col-sm-9"> 
                                	<input type="text" class="form-control" id="postedPremium" name="postedPremium" value="${model.postedPremium}"/>                                 
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Save" id="btnAddMotor"/>
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Refresh" id="btnRefreshMotor"/>
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Issue" id="btnIssue"/>
                                </div>
                            </div>
                            <input type="hidden" value="edit" id="type" name="type"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	
</script>
</body>
</html>
