<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="resources/css/jquery-ui-themes.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="data/styles.css" type="text/css" rel="stylesheet" />
<link href="files/admin_jsp/styles.css" type="text/css" rel="stylesheet" />
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
<script src="files/admin_jsp/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>

</head>
<body>

	<div align="center">
		<div align="center">
			<img src="images/admin_jsp/u2.png" />
		</div>
		<form action="StoreOperatorServlet" method="post"
			style="margin-top: 5px;">
			<div style="margin-top: 5px;">
				<p>
					<span>登陆ID：</span> <input id="userId" type="text"
						value="请输入用户账号全为数字" name="userName" />
				</p>
				<script type="text/javascript">
					var userId = document.getElementById("userId");
					var onoff = true;
					userId.onfocus = function() {
						if (onoff) {
							userId.value.color = "red";
							userId.value = "";
							onoff = false;
						}
					}
					userId.onblur = function() {

						var userName = document.getElementById("userId").value;
						var reg = new RegExp("^[0-9]*$");
						//判断用户名格式
						if (!reg.test(userName)) {
							alert("账号应全为数字，请重新输入");
							userId.value = "";
							onoff = true;
						}

						if (userId.value == '') {
							userId.value = "请输入账号";
							userId.color = "#000";
							onoff = true;
						}
					}
				</script>
			</div>

			<div style="margin-top: 5px;">
				<p>
					<span>密&nbsp;&nbsp; 码：</span> <input type="password" value=""
						name="userPwd" />
				</p>
			</div>

			<div style="margin-top: 5px;">
				<p>
					<span>门店操作员</span> <input type="radio" value="1" name="u1" /> <span>工厂操作员</span>
					<input type="radio" value="2" name="u1" />
				</p>

			</div>

			<div style="margin-top: 5px;">
				<input type="submit" value="登陆" style="width: 100px;" />
			</div>

		</form>
	</div>

</body>
</html>