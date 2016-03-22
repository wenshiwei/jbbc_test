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
<link href="files/clothes_jsp/styles.css" type="text/css"
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
<script src="files/clothes_jsp/data.js"></script>
<script src="resources/scripts/axure/legacy.js"></script>
<script src="resources/scripts/axure/viewer.js"></script>

<script type="text/javascript">

function CheckMessage() {
	var ClothesNumbers=document.getElementById("ClothesNumbers").value;
	var ClothesMessage=document.getElementById("ClothesMessage").value;
	if(ClothesNumbers==""||ClothesMessage==""){
		alert("衣服数量或衣服备注为空请填写！");
		return false;
	}
	else{
		if(!/^[0-9]*$/.test(ClothesNumbers)){
			alert("衣服数量应该为整数！");
			return false;
		}
		return true;
	}
	
}



</script>

</head>
<body>
	<div>
		<div style="width: 100%; height: auto;" align="center">
			<img src="images/factory1_jsp/u0.png" />
		</div>
		<div style="margin-top: 15px;" align="center">
			<fieldset style="width: 88%; height: 300px; border: 1px solid black;">
				<div>
					<form action="AddClothesServlet" method="post" id="CheckClothes" onsubmit="return CheckMessage()">
						<div>
							<p>
								<span>衣物类型：</span> <select name="ClothType">
									<option>西装</option>
									<option>羽绒服</option>
									<option>衬衫</option>
									<option>毛衣</option>
									<option>棉衣</option>
								</select>
							</p>
						</div>
						<div>
							<p>
								<span>衣物等级：</span> <select style="width: 65px;"
									name="ClothGrade">
									<option>1</option>
									<option>2</option>
									<option>3</option>
								</select>
							</p>
						</div>
						<div>
							<p>
								<span>衣物数量：</span> <input type="text" name="NumberofCloth"
									id="ClothesNumbers" style="width: 70px;"  />
							</p>
						</div>
						<div>
							<p>
								<span>衣物备注：</span> <input type="text" name="MessagofCloth" 
								     id="ClothesMessage"/>
							</p>
						</div>
						<div style="margin-top: 5px;">
							<input type="submit" value="增加并继续" />
						</div>
					</form>
				</div>
				<div style="margin-top: 5px;">
					<input type="button" value="完成并返回"
						onclick="window.location.href='UpdaOrderStaeServlet'" />
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