<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var ="MotorURL" value="/home-list"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Motor</title>
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ MOTOR</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
			 	<c:if test="${not empty messageResponse}">
					<div class="alert alert-${alert}">
  						${messageResponse}
					</div>
				</c:if>
				<div class="widget-box table-filter">
					<div class="table-btn-controls">
						<div class="pull-right tableTools-container">
							<div class="dt-buttons btn-overlap btn-group">
								<a flag="info"
									class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Add motor'
									href='<c:url value="/motor-list?type=edit"/>'> <span>
										<i class="fa fa-plus-circle bigger-110 purple"></i>
								</span>
								</a>
								<button id="btnDelete" type="button"
									class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
									data-toggle="tooltip" title='Delete motor'>
									<span> <i class="fa fa-trash-o bigger-110 pink"></i>
									</span>
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Policy No</th>
									<th>Inception Date</th>
									<th>Expiry Date</th>
									<th>Policy Owner</th>
									<th>Engine No</th>
									<th>Chassis No</th>
									<th>Vehicle Registration No</th>
									<th>Billing Currency</th>
									<th>Sum Insured</th>
									<th>Rate</th>
									<th>Annual Premium</th>
									<th>Posted Premium</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${model.listResult}">
									<tr>
										<td><c:out value="${item.policyNo}" /></td>
										<td>${item.inceptionDate}</td>
										<td>${item.expiryDate}</td>
										<td>${item.policyOwner}</td>
										<td>${item.engineNo}</td>
										<td>${item.chassisNo}</td>
										<td>${item.vehicleRegistrationNo}</td>
										<td>${item.billingCurrency}</td>
										<td>${item.sumInsured}</td>
										<td>${item.rate}</td>
										<td>${item.annualPremium}</td>
										<td>${item.postedPremium}</td>
										<c:if test = "${item.status == 1}">
									         <td>Pending</td>
									     </c:if>
										<c:if test = "${item.status != 1}">
									         <td>In force</td>
									     </c:if>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<input type="hidden" value="list" id="list" name="list"/>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	<script>

	</script>
</body>
</html>