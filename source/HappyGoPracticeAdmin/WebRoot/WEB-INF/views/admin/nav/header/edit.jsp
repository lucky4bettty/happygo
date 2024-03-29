<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/include.jsp"%>
<link rel="stylesheet"
	href="<c:out value="${resourcesPath}"/>admin/css/datepicker.css"
	type="text/css" />
<link rel="stylesheet"
	href="<c:out value="${resourcesPath}"/>admin/css/jquery-ui-1.10.4.custom.css"
	type="text/css" />
<script type="text/javascript"
	src="<c:out value="${resourcesPath}"/>admin/js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript"
	src="<c:out value="${resourcesPath}"/>admin/js/jquery.ui.datepicker-zh-TW.js"></script>
<script type="text/javascript"
	src="<c:out value="${resourcesPath}"/>admin/js/jquery-ui-timepicker-addon.js"></script>
<div class="mainBlock">
	<div class="breadcrumbs">
		<ul>
			<li><a href="<c:out value="${contextPath}"/>admin/index.do">首頁</a></li>
			<li><a href="#">Header</a></li>
			<li><a href="#"><c:out value="${menuName}" /></a></li>
		</ul>
	</div>
	<h3 class="titline">
		<span class="edit">編輯區</span>
	</h3>
	<form:form method="post" id="sForm" name="sForm" action="save.do"
		enctype="multipart/form-data">
		<form:hidden path="id" />
		<table class="tbType" cellspacing="0" cellpadding="0" border="0"
			width="100%">
			<tbody>
				<tr>
					<th scope="row"><span class="red">※</span>Footer標題</th>
					<td><form:input path="name" maxlength="50" /> <form:errors
							path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<th scope="row"><span class="red">※</span>連結</th>
					<td><form:input path="url" maxlength="50" /> <form:errors
							path="url" cssClass="error" /></td>
				</tr>
				<tr>
					<th scope="row"><span class="red">※</span>連結開啟方式</th>
					<td><form:radiobuttons path="opening_method"
							items="${targetOption}" /> <form:errors path="opening_method"
							cssClass="error" /></td>
				</tr>
				<tr>
					<th scope="row"><span class="red">※</span>狀態</th>
					<td><form:radiobuttons path="status" items="${statusOption}" />
						<form:errors path="status" cssClass="error" /></td>
				</tr>
			</tbody>
		</table>
		<div class="btnSet line">
			<a href="#" onclick="$('#sForm').submit();">儲存</a> <a href="list.do">取消</a>
		</div>
	</form:form>
	<script>
	$("#start_time").datepicker({
        changeYear: true,
        showOn: 'both',
        showMinute: true,
        showSecond: true,
        dateFormat: 'yy-mm-dd',
        buttonImage: '<c:out value="${resourcesPath}"/>admin/images/calendar.jpg'
    });
	$("#end_time").datepicker({
        changeYear: true,
        showOn: 'both',
        showMinute: true,
        showSecond: true,
        dateFormat: 'yy-mm-dd',
        buttonImage: '<c:out value="${resourcesPath}"/>admin/images/calendar.jpg'
    });
	</script>
</div>
<script type="text/javascript"
	src="<c:out value="${resourcesPath}"/>admin/js/tinymce/tinymce.min.js"></script>
<script>var tinymce_selector = "#description";</script>
<script type="text/javascript"
	src="<c:out value="${resourcesPath}"/>admin/js/tinymce/tinymce.custom.js"></script>