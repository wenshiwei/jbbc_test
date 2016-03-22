<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>完成订单的详情</title>
<script type="text/javascript">
	function pre(currentPage,userName1,allPage) {
		if(currentPage==1){
			alert("当前为第一页，没有上一页！");
			
		}
		else{
			window.location.href="CompleteCustPageServlet?currentPage="+${currentPage}+"&flag=pre&username1="+userName1
			+"&allPage="+allPage;
		}
		}
		
	function next(currentPage,allPage,userName1) {
		if(currentPage<allPage){
			window.location.href="CompleteCustPageServlet?currentPage="+${currentPage}+"&flag=next&username1="+userName1
					+"&allPage="+allPage;
		}
		else{
			alert("当前为最后一页，没有下一页！");
		}
		}
</script>
</head>
<body>

	<div
		style="width: 1350px; height: 620px; background-image: url(images/index_jsp/background.png); float: left;">
		<img src="images/index_jsp/12.jpg"> <font color="blue"
			size="10px">昵称：${username1}&nbsp;&nbsp;&nbsp;&nbsp;完成订单详情</font>
		<div
			style="margin-left: 40px; float: left; width: 72%; height: 300px; margin-left: 20%; margin-top: 5%">

			<fieldset style="width: 100%; height: 93%; border: 1px solid black;">
				<table style="width: 100%; border: 0px;">

					<tr align="center">
						<th style="width: 20%; height: 25px; border: 2px solid;"><span>创建时间</span></th>
						<th style="width: 20%; height: 25px; border: 2px solid;"><span>订单ID</span></th>
						<th style="width: 20%; height: 25px; border: 2px solid;"><span>数量</span></th>
						<th style="width: 20%; height: 25px; border: 2px solid;"><span>结束时间</span></th>
					</tr>
					<c:forEach items="${listd}" var="listd">
						<tr align="center">
							<th style="width: 20%; height: 30px; border: 1px solid;"><span>${listd.createTime}</span></th>
							<th style="width: 20%; height: 30px; border: 1px solid;"><span>${listd.orderId}</span></th>
							<th style="width: 20%; height: 30px; border: 1px solid;"><span>${listd.number}</span></th>
							<th style="width: 20%; height: 30px; border: 1px solid;"><span>${listd.lastModifyTime}</span></th>
						</tr>
					</c:forEach>

				</table>

			</fieldset>

			<input value="上一页" type="submit"
				style="margin-top: 3px; margin-left: 300px; float: left;"
				onclick="pre(${currentPage},'${username1}',${allPage})" /> <font color="blue"
				style="margin-left: 150px;">${currentPage}页/${allPage}页</font> <input
				value="下一页" type="submit"
				style="margin-left: 100px; margin-top: 3px"
				onclick="next(${currentPage},${allPage},'${username1}')" />
		</div>
	</div>
</body>
</html>