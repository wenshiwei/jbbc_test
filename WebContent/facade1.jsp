<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>门面用户</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/facade1_jsp/styles.css" type="text/css"
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
<script src="files/facade1_jsp/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>
<script type="text/javascript">
function luru(id)
{
		window.location.href="OrderIDServlet?OrderID="+id+"&Status=1";
}


function upPageCheck(nowpage,allpage) {
	if(1<nowpage){
		window.location.href="UpDatePagesServlet?NowPage="+(nowpage-1)+"&Status="+1;
	}
	else{
	alert("当前为第一页，没有上一页！");	
	}
	}
	
function belowPageCheck(nowpage,allpage) {
	if(nowpage<allpage){
		window.location.href="UpDatePagesServlet?NowPage="+(nowpage+1)+"&Status="+1;
	}
	else{
		alert("当前为最后一页，没有下一页！");	
	}
	}

</script>

</head>
<body>
	<div>
		<div style="width: 100%; height: auto;" align="center">
			<img src="images/factory1_jsp/u0.png" />
		</div>
		<div style="margin-top: 15px;">
			<div
				style="float: left; width: 10%; height: 400px; margin-left: 55px; float: left;">
				<fieldset style="width: 100%; height: 93%; border: 1px solid black;">
					<ul>
						<li class="home"><span>首页</span></li>
						<li><a href="OpenOrderPagServlet?Status=1"><span>未处理
							</span></a></li>
						<li><a href="OpenOrderPagServlet?Status=2"><span>已处理</span></a></li>
						<li><a href="OpenOrderPagServlet?Status=5"><span>订单派送处理</span></a></li>
					</ul>
				</fieldset>
			</div>
			<div
				style="margin-left: 40px; float: left; width: 72%; height: 300px;">
				<fieldset style="width: 100%; height: 93%; border: 1px solid black;">
					<table border="" style="width: 100%; border: 0px;">
						<tr style="width: 100%; height: 5px; border: 2px solid;"
							align="center">
							<th style="width: 20%; height: 5px; border: 2px solid;"><span>订单ID</span></th>
							<th style="width: 20%; height: 5px; border: 2px solid;"><span>客户ID</span></th>
							<th style="width: 20%; height: 5px; border: 2px solid;"><span>客户地址</span></th>
							<th style="width: 20%; height: 5px; border: 2px solid;"><span>衣服登记</span></th>
						</tr>
						<c:forEach items="${facadesimpojo }" var="facadOrdeDate">
							<tr align="center">
								<th style="width: 20%; height: 30px; border: 1px solid;"><span>${facadOrdeDate.getOrderId() }</span></th>
								<th style="width: 20%; height: 30px; border: 1px solid;"><span>${facadOrdeDate.getCustormerId() }</span></th>
								<th style="width: 20%; height: 30px; border: 1px solid;"><span>${facadOrdeDate.getDetail() }</span></th>
								<th style="width: 20%; height: 30px; border: 1px solid;"><span>
										<input type="button" value="点击登记"
										style="width: 100%; height: 30px;"
										onclick="luru(${facadOrdeDate.orderId})" />
								</span></th>
							</tr>
						</c:forEach>
					</table>
				</fieldset>
			</div>
			<div
				style="margin-left: 40px; float: left; width: 72%; height: 100px;"
				align="center">
				<input type="button" value="上一页" style="margin-top: 20px;"
					onclick="upPageCheck(${nowPages },${nowPages })" />
				&nbsp;&nbsp;&nbsp;&nbsp; <input
					value="当前第${nowPages }页/ 共${allPages }页" disabled="disabled" /> <input
					type="button" value="下一页"
					onclick="belowPageCheck(${nowPages },${allPages })" />
			</div>
		</div>
		<div style="float: left; width: 85%; margin-left: 60px;"
			align="center">
			<fieldset style="width: 100%; height: 60px; border: 1px solid black;">
				<p></p>
				<span>版权所有</span>
			</fieldset>
		</div>
	</div>
</body>
</html>