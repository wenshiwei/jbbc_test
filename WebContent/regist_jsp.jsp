<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>regist.jsp</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/regist_jsp/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="files/regist_jsp/data.js"></script>
    <script src="resources/scripts/axure/legacy.js"></script>
    <script src="resources/scripts/axure/viewer.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
</head>
<body>
	<form action="RegistServlet" method="post">
  		<div id="base" class="">

      <!-- Unnamed (Shape) -->
      <div id="u0" class="ax_shape">
        <img id="u0_img" class="img " src="images/regist_jsp/u0.png"/>
        <!-- Unnamed () -->
        <div id="u1" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u2" class="ax_image">
        <img id="u2_img" class="img " src="images/admin_jsp/u2.png"/>
        <!-- Unnamed () -->
        <div id="u3" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Text Field) -->
      <div id="u4" class="ax_text_field">
        <input id="u4_input" type="text" value="" name="username"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u5" class="ax_paragraph">
        <img id="u5_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u6" class="text">
          <p><span>用&nbsp; 户 名：</span></p>
        </div>
      </div>

      <!-- Unnamed (Text Field) -->
      <div id="u7" class="ax_text_field">
        <input id="u7_input" type="password" value="" name="password"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u8" class="ax_paragraph">
        <img id="u8_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u9" class="text">
          <p><span>密&nbsp; &nbsp; &nbsp; 码：</span></p>
        </div>
      </div>

      <!-- Unnamed (Text Field) -->
      <div id="u10" class="ax_text_field">
        <input id="u10_input" type="password" value="" name="surepassword"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u11" class="ax_paragraph">
        <img id="u11_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u12" class="text">
          <p><span>重复密码：</span></p>
        </div>
      </div>

      <!-- Unnamed (Text Field) -->
      <div id="u13" class="ax_text_field">
        <input id="u13_input" type="text" value="" name="address"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u14" class="ax_paragraph">
        <img id="u14_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u15" class="text">
          <p><span>联系地址：</span></p>
        </div>
      </div>

      <!-- Unnamed (Text Field) -->
      <div id="u16" class="ax_text_field">
        <input id="u16_input" type="text" value="" name="telephone"/>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u17" class="ax_paragraph">
        <img id="u17_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u18" class="text">
          <p><span>联系方式：</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u19" class="ax_paragraph">
        <img id="u19_img" class="img " src="resources/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u20" class="text">
          <p><span>用户类型：</span></p>
        </div>
      </div>

      <!-- Unnamed (Droplist) -->
      <div id="u21" class="ax_droplist">
        <select id="u21_input" name="usertype">
        	<option>普通用户</option>
        	<option>会员用户</option>
        </select>
      </div>

      <!-- Unnamed (HTML Button) -->
      <div id="u22" class="ax_html_button">
        <input id="u22_input" type="submit" value="注册"/>
      </div>
    </div>
  	</form>
</body>
</html>