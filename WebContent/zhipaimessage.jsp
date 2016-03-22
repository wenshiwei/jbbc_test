<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>factory3</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/factory3_jsp/styles.css" type="text/css"
	rel="stylesheet" />
<script src="resources/scripts/jquery-1.7.1.min.js"></script>
<script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
<script src="resources/scripts/axure/axQuery.js"></script>
<script src="resources/scripts/axure/globals.js"></script>
<script src="resources/scripts/axutils.js"></script>
<script src="resources/scripts/axure/annotation.js"></script>
<script src="resources/scripts/axure/axQuery.std.js"></script>
<script src="resources/scripts/axure/doc.js"></script>
<script src="data/document.js"></script>
<script src="resources/scripts/messagecenter.js"></script>
<script src="resources/scripts/axure/events.js"></script>
<script src="resources/scripts/axure/action.js"></script>
<script src="resources/scripts/axure/expr.js"></script>
<script src="resources/scripts/axure/geometry.js"></script>
<script src="resources/scripts/axure/flyout.js"></script>
<script src="resources/scripts/axure/ie.js"></script>
<script src="resources/scripts/axure/model.js"></script>
<script src="resources/scripts/axure/repeater.js"></script>
<script src="resources/scripts/axure/sto.js"></script>
<script src="resources/scripts/axure/utils.temp.js"></script>
<script src="resources/scripts/axure/variables.js"></script>
<script src="resources/scripts/axure/drag.js"></script>
<script src="resources/scripts/axure/move.js"></script>
<script src="resources/scripts/axure/visibility.js"></script>
<script src="resources/scripts/axure/style.js"></script>
<script src="resources/scripts/axure/adaptive.js"></script>
<script src="resources/scripts/axure/tree.js"></script>
<script src="resources/scripts/axure/init.temp.js"></script>
<script src="files/factory3_jsp/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>
</head>
<body>
	<div>

		<div style="width: 100%; height: auto;" align="center">
			<img src="images/factory1_jsp/u0.png" />
		</div>

		<div style="margin-top: 15px;" align="center">
			<fieldset style="width: 88%; height: 300px; border: 1px solid black;">
				<div style="margin-top: 10%;">
					<form action="ZhiDinOpreaterServlet" method="post" id="CheckClothes"
						onsubmit="return CheckMessage()">

						<div>
							<p>
								<span>订&nbsp; 单&nbsp; ID：</span>${OrderID }
							</p>
						</div>

						<div>
							<p>
								<span>订单地址：</span>${OrderAddress }
							</p>
						</div>

						<div>
							<p>
								<span>处理门店：</span> <select name="FacID" >
									<c:forEach items="${listFacadeData }" var="FacadeId">
									<option value="${FacadeId.operaterId }">${FacadeId.address }</option>
									</c:forEach>
								</select>
							</p>
						</div>

						<div style="margin-top: 5px;">
							<input type="submit" value="指派" />
						</div>
					</form>
				</div>
			</fieldset>
		</div>

		<div align="center">
			<fieldset
				style="width: 88%; height: 50px; border: 1px solid black; margin-top: 5px;">
				<p>
					<span>版权所有</span>
				</p>
			</fieldset>
		</div>

	</div>
</body>
</html>