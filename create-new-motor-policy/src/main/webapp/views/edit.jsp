<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="ListURL" value="/motor-list" />

<html>
<head>
<title>Edit Motor</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value="/motor-list?type=list"/>">Trang
							chủ</a></li>
					<li class="active">Edit Motor</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">${messageResponse}</div>
						</c:if>
						<form id="formSubmit">
							<div class="form-group">
								<input type="hidden" name="status" id="status" />
							</div>

							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Inception
									Date</label>
								<div class="col-sm-6">
									<input type="date" required class="form-control"
										id="inceptionDate" name="inceptionDate"
										value="${model.inceptionDate}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Expiry
									Date</label>
								<div class="col-sm-6">
									<input type="date" class="form-control" id="expiryDate"
										name="expiryDate" value="${model.expiryDate}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Policy
									Owner</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="policyOwner"
										name="policyOwner" value="${model.policyOwner}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Engine
									No</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="engineNo"
										name="engineNo" value="${model.engineNo}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Chassis
									No</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="chassisNo"
										name="chassisNo" value="${model.chassisNo}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Vehicle
									Registration No</label>
								<div class="col-sm-6">
									<input type="text" class="form-control"
										id="vehicleRegistrationNo" name="vehicleRegistrationNo"
										value="${model.vehicleRegistrationNo}" />
								</div>
							</div>
							<br />
							<br />
							<div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Billing Currency</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="billingCurrency" name="billingCurrency" >
  											<option value="VND">VND</option>
  											<option value="USD">USD</option>
  											<option value="SGD">SGD</option>
 
										</select>
                                   
                                    </select>
                                </div>
                            </div> 
							<br />
							<%-- <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Billing
									Currency</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="billingCurrency"
										name="billingCurrency" value="${model.billingCurrency}" />
								</div>
							</div>
							<br /> --%> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Sum
									Insured</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="sumInsured"
										name="sumInsured" value="${model.sumInsured}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Rate</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="rate" name="rate"
										value="${model.rate}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Annual
									Premium</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="annualPremium"
										name="annualPremium" value="${model.annualPremium}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Posted
									Premium</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="postedPremium"
										name="postedPremium" value="${model.postedPremium}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
								 <c:if test="${not empty model.id}">
                                         <input type="button" class="btn btn-white btn-warning btn-bold" value="Save" id="btnAddOrUpdateMotor" /> 
                                         <input type="button" class="btn btn-white btn-warning btn-bold" value="Refresh" id="btnRefreshMotor" />
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Save" id="btnAddOrUpdateMotor" /> 
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Refresh" id="btnRefreshMotor" /> 
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Issue" id="btnIssue" />
                                    </c:if>
									<!-- <input type="button" class="btn btn-white btn-warning btn-bold"
										value="Save" id="btnSaveMotor" /> <input type="button"
										class="btn btn-white btn-warning btn-bold" value="Refresh"
										id="btnRefreshMotor" /> <input type="button"
										class="btn btn-white btn-warning btn-bold" value="Issue"
										id="btnIssue" /> -->
								</div>
								
							</div>
							<input type="hidden" value="edit" id="type" name="type" />
							<input type="hidden" value="${model.id}" id="id" name="id"/>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateMotor').click(
			function(e) {
				e.preventDefault();
				var data = {};
				$('#status').val('1');
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var policyOwner = $('#policyOwner').val();
				var engineNo = $('#engineNo').val();
				var chassisNo = $('#chassisNo').val();
				var vehicleRegistrationNo = $('#vehicleRegistrationNo').val();
				var billingCurrency = $('#billingCurrency').val();
				var sumInsured = $('#sumInsured').val();
				var rate = $('#rate').val();
				var annualPremium = $('#annualPremium').val();
				var postedPremium = $('#postedPremium').val();
				if (!policyOwner || !engineNo || !chassisNo || !vehicleRegistrationNo
					|| !billingCurrency || !sumInsured || !rate || !annualPremium || !postedPremium) {
					window.location.href = "${ListURL}?type=edit&message=error_system";
				}
				var id = $('#id').val();
				if (id == "") {
					addMotor(data);
				} else {
					updateMotor(data);
				}
		});
		function addMotor(data) {
			$.ajax({
				url : '/create-new-motor-policy/motor-list',
				type : 'POST',
				contentType : "application/json",
				data : JSON.stringify(data),
				success : function(result) {
					if(result.iSuccess)
						window.location.href = "${ListURL}?type=edit&message=insert_success&contentMessage="+result.message;
					else{
						window.location.href = "${ListURL}?type=edit&message=insert_error&contentMessage="+result.message;
					}
				},
				error : function(error) {
					window.location.href = "${ListURL}?type=edit&message=error_system";
					console.log(error);
				}
			});
		}
	
			function updateMotor(data) {
				$.ajax({
					url : '/create-new-motor-policy/motor-list',
					type : 'PUT',
					contentType : "application/json",
					data : JSON.stringify(data),
					success : function(result) {
						if(result.isSuccess)
							window.location.href = "${ListURL}?type=edit&id="+result.id+"&message=update_success&contentMessage="+result.message;
						else{
							window.location.href = "${ListURL}?type=edit&id="+result.id+"&message=update_error&contentMessage="+result.message;
						}
					},
					error : function(error) {
						window.location.href = "${ListURL}&message=error_system";
						console.log(error);
					}
				});
			}


		$('#btnRefreshMotor').click(
				function(e) {

					var sumInsured = $('#sumInsured').val();
					var rate = $('#rate').val();

					var annualPremium = sumInsured * rate / 100;
					$('#annualPremium').val(annualPremium);

					var inceptionDate = new Date($('#inceptionDate').val());
					var expiryDate = new Date($('#expiryDate').val());

					var Difference_In_Time = expiryDate.getTime()
							- inceptionDate.getTime();
					var Difference_In_Days = Difference_In_Time
							/ (1000 * 3600 * 24);

					var postedPremium = annualPremium * Difference_In_Days
							/ 365;
					$('#postedPremium').val(postedPremium);
					var postedPremium;
					if (leapYear(expiryDate.getFullYear())) {
						postedPremium = annualPremium
								* (Difference_In_Days / 366);
					} else {
						postedPremium = annualPremium
								* (Difference_In_Days / 365);
					}
					$('#postedPremium').val(postedPremium);

		});

		function leapYear(year) {
			return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
		}
		$('#btnIssue').click(
			function(e) {
				e.preventDefault();
				var data = {};
				$('#status').val('2');
				var formData = $('#formSubmit').serializeArray();
				$.each(formData, function(i, v) {
					data["" + v.name + ""] = v.value;
				});
				var policyOwner = $('#policyOwner').val();
				var engineNo = $('#engineNo').val();
				var chassisNo = $('#chassisNo').val();
				var vehicleRegistrationNo = $('#vehicleRegistrationNo').val();
				var billingCurrency = $('#billingCurrency').val();
				var sumInsured = $('#sumInsured').val();
				var rate = $('#rate').val();
				var annualPremium = $('#annualPremium').val();
				var postedPremium = $('#postedPremium').val();
				if (!policyOwner || !engineNo || !chassisNo || !vehicleRegistrationNo
					|| !billingCurrency || !sumInsured || !rate || !annualPremium || !postedPremium) {
						window.location.href = "${ListURL}?type=edit&message=error_system";
				}
				var id = $('#id').val();
				if (id == "") {
					addMotor(data);
				}
		});
	</script>
</body>
</html>
