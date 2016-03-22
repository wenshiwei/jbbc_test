<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<title>promotion.jsp</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/promotion_jsp/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="files/promotion_jsp/data.js"></script>
    <script src="resources/scripts/axure/legacy.js"></script>
    <script src="resources/scripts/axure/viewer.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    
<title>Insert title here</title>
</head>
<body>
<div id="base" class="">

      <!-- Unnamed (Image) -->
      <div id="u0" class="ax_image">
        <img id="u0_img" class="img " src="images/index_jsp/13.png"/>
        <!-- Unnamed () -->
        <div id="u1" class="text">
          <p><span></span></p>
        </div>
      </div>

      <div style="width: 260px;height: 550px;margin-left: 100px;margin-top: 180px;float: left;" id="notice">
      	<table border="1px" rules="rows" style="width: 170px;height: 280px">
      	<c:forEach items="${list1}" var="list1">
      		<tr>
      			<td width="50px" align="center">
      			<a href="NoticeServlet?title=${list1.title }" style="text-decoration: none;">
      			<font color="blue" size="5">${list1.title}
      			</font>
      			</a>
      			</td></tr>
      			
      	</c:forEach>
      </table>
     </div>
     <div style="width: 615px;height: 550px;margin-left: 380px;margin-top: 180px;">
     	<font size="10px">${message}</font>
     </div>

      <!-- Unnamed (Shape) -->
      <div id="u4" class="ax_shape">
        <img id="u4_img" class="img " src="images/factory1_jsp/u4.png"/>
        <!-- Unnamed () -->
        <div id="u5" class="text">
          <p><span>版全所有</span></p>
        </div>
      </div>

     

      <!-- Unnamed (Shape) -->
      <div id="u42" class="ax_shape">
        <img id="u42_img" class="img " src="images/index_jsp/u101.png"/>
        <!-- Unnamed () -->
        <div id="u43" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u44" class="ax_h2">
        <img id="u44_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u45" class="text">
          <a href="IndexServlet" style="text-decoration: none;">首页</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u46" class="ax_h2">
        <img id="u46_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u47" class="text">
          <a href="#" style="text-decoration: none;">优惠</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u48" class="ax_h2">
        <img id="u48_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u49" class="text">
          <a href="IndexServlet?loginId=${companyId }" style="text-decoration: none;">企业用户</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u50" class="ax_h2">
        <img id="u50_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u51" class="text">
          <a href="PersonServlet?username=${loginId }" style="text-decoration: none;">个人用户</a>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u52" class="ax_h2">
        <img id="u52_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u53" class="text">
          <a href="about.jsp" style="text-decoration: none;">关于</a>
        </div>
      </div>
    </div>
</body>
</html>