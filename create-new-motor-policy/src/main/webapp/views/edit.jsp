<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="ListURL" value="/motor-list"/>

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
                                    <input type="date" class="form-control" id="inceptionDate" name="inceptionDate" value="${model.inceptionDate}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Expiry Date</label>
                                <div class="col-sm-9">
                                    <input type="date" class="form-control" id="expiryDate" name="expiryDate" value="${model.expiryDate}"/>
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
                            <input type="hidden" value="edit" id="edit" name="edit"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

	$('#btnAddMotor').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if (id == undefined) {
            addMotor(data);
        }
    });
    function addMotor(data) {
        $.ajax({
            url: '/create-new-motor-policy/motor-list',
            type: 'POST',
            contentType: "application/json", 
            data: JSON.stringify(data),
            success: function (result) {
            	window.location.href = "${ListURL}?type=edit&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${ListURL}message=error_system";
            	console.log(error);
            }
        });
    }

	/*$("#btnAddMotor").click(function() {		
		$.ajax({
			url: "edit.jsp",
			type: "post",
			data: {
				inceptionDate:$('#inceptionDate').val(),
				expiryDate:$('#expiryDate').val(),
				policyOwner:$('#policyOwner').val(),
				engineNo:$('#engineNo').val(),
				chassisNo:$('#chassisNo').val(),
				vehicleRegistrationNo:$('#vehicleRegistrationNo').val(),
				billingCurrency:$('#billingCurrency').val(),
				sumInsured:$('#sumInsured').val(),
				rate:$('#rate').val(),
				annualPremium:$('#annualPremium').val(),
				postedPremium:$('#postedPremium').val(),
				success : function(data){
					alert(data);
				}
			}
		}); 
	});*/
	
</script>
</body>
</html>
