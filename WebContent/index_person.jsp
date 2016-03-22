<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/index_jsp/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="files/index_jsp/data.js"></script>
    <script src="resources/scripts/axure/legacy.js"></script>
    <script src="resources/scripts/axure/viewer.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <script type="text/javascript">
    var request;
	function createRequest(){
		if(window.ActiveXObject)
		{
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest)
		{
			request = new XMLHttpRequest();
		}
		else{
			alert("不支持");
		}
	}
	function process(){
		if(request.readyState==4&&request.status==200){
			document.getElementById("notice").innerHTML=msg;
		}
	}
	function send(){
		createRequest();
		request.onreadystatechange=process;
		request.open("POST", "PriceAndNoticeServlet", true);
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		request.send(null);
		
	}
    </script>
 	<script type="text/javascript">
 	
	function pre(currentPage) {
		if(currentPage==1){
			alert("已经是第一页了");
		}else{
			currentPage--;
			window.location.href = "PriceAndNoticeServlet?currentPage="+${currentPage}+"&flag=pre";
		}
	}
	function next(currentPage,pageCount) {
		if(currentPage<pageCount){
			window.location.href = "PriceAndNoticeServlet?currentPage="+${currentPage}+"&flag=next";
		}
		else{
			alert("已经是最后一页");
		}
			
	}
	</script>
</head>
<body>
<div style="width: 90%;height: 120px;margin-left: 100px;background-image: url(images/index_jsp/13.png)">
	</div>
	<form action="IndexServlet" method="post">
	
       <div style="float: left;">
      	 <!-- Unnamed (Shape) -->
      <div style="width: 650px;height: 350px;margin-top: 300px;margin-left: 100px;float: left;">
        
        <table border="1px" rules="rows">
      	<c:forEach items="${list}" var="list">
      	<a href="ShoppingCarServlet&clothesType=${list.clothesType}&clothesLevel=${list.clothesLevel}&charge=${list.charge}">
      		<fieldset style="width: 130px;height: 130px;float: left;">
      		
      		<img style="width: 95%;
      				height: 60%;margin-left: 1px;margin-top: 1px;" src="${list.imageUrl }"/>
      					类型：${list.clothesType}<br/>
    					等级：${list.clothesLevel}<br/>
    					价格：${list.charge}
      				
      		</fieldset>
      	</a>
      		
      	</c:forEach>
      </table>
       <input style="width: 100px;height: 30px;margin-top: 10px;margin-left: 230px" type="submit" onclick="pre(${currentPage})" value="上一页"/>
      <font color="blue" size="4">${currentPage}页/${pageCount}页</font>
      <input style="width: 100px;height: 30px;" type="submit" onclick="next(${currentPage},${pageCount})" value="下一页"/> 
      
     </div>
     
     <div style="width: 170px;height: 280px;margin-left: 820px;margin-top: 300px;" id="notice">
	  	<table border="1px" rules="rows" style="width: 170px;height: 280px">
      	<c:forEach items="${list1}" var="list1">
      	<tr>
      			<td width="50px" align="center">
	      			<a href="NoticeServlet?title=${list1.title}" style="text-decoration: none;">
		      			<font color="blue" size="5">${list1.title}
		      			</font>
	      			</a>
      			</td></tr>
      	</c:forEach>
      </table>
	  </div>
   </div>
        
	<div id="u72" class="ax_h2" style="margin-left: 850px;margin-top: 200px; "
	align="center">
		<img id="u72_img" class="img" src="images/index_jsp/11.jpg"><br/>
		<font>昵称：&nbsp;${loginId}</font>
	</div>
      
      

      <!-- Unnamed (Shape) -->
      <div id="u97" class="ax_shape">
        <img id="u97_img" class="img " src="images/facade_jsp/u4.png"/>
        <!-- Unnamed () -->
        <div id="u98" class="text">
          <p><span>版全所有</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u101" class="ax_shape">
        <img id="u101_img" class="img " src="images/index_jsp/u101.png"/>
        <!-- Unnamed () -->
        <div id="u102" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u103" class="ax_h2">
        <img id="u103_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u104" class="text">
          <a href="#" style="text-decoration: none;">首页</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u105" class="ax_h2">
        <img id="u105_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u106" class="text">
          <a href="NoticeServlet?loginId=${loginId }" style="text-decoration: none;">优惠</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u107" class="ax_h2">
        <img id="u107_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u108" class="text">
          <a href="CompanyCustServlet" style="text-decoration: none;">企业用户</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u109" class="ax_h2">
        <img id="u109_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u110" class="text">
          <p><a href="PersonServlet?username=${loginId }&&detail=${detail}" 
          style="text-decoration: none;">个人用户</a></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u111" class="ax_h2">
        <img id="u111_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u112" class="text">
          <a href="about.jsp" style="text-decoration: none;">关于</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u115" class="ax_paragraph">
        <img id="u115_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u117" class="ax_paragraph">
        <img id="u117_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u119" class="ax_paragraph">
        <img id="u119_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u123" class="ax_paragraph">
        <img id="u123_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u125" class="ax_paragraph">
        <img id="u125_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u127" class="ax_paragraph">
        <img id="u127_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u131" class="ax_paragraph">
        <img id="u131_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u133" class="ax_paragraph">
        <img id="u133_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u135" class="ax_paragraph">
        <img id="u135_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u139" class="ax_paragraph">
        <img id="u139_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u141" class="ax_paragraph">
        <img id="u141_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u143" class="ax_paragraph">
        <img id="u143_img" class="img " src="resources/images/transparent.gif"/>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u147" class="ax_image">
        <img id="u147_img" class="img " src="images/index_jsp/14.jpg"/>
        <!-- Unnamed () -->
        <div id="u148" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u149" class="ax_image">
        <img id="u149_img" class="img " src="images/index_jsp/15.jpg"/>
        <!-- Unnamed () -->
        <div id="u150" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u151" class="ax_paragraph">
        <img id="u151_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u152" class="text">
          <p><span>蒸湘医院优质合作伙伴</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u153" class="ax_paragraph">
        <img id="u153_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u154" class="text">
          <p><span>蒸湘医院优质合作伙伴</span></p>
        </div>
      </div>
  </form>
</body>
</html>