<%@page contentType="text/html;charset=UTF-8"%>
<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("main.jsp");
    }
%>
<%@ include file="/commons/taglibs.jsp"%>
<html>
  <head>
    <%@ include file="/commons/meta.jsp"%>
    <title>张家口市房地产市场数据统计系统</title>
<style type="text/css">
	body {background-image: url(images/background.jpg);
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;}
	.title {
		font:normal small-caps bold 40px/2 Simsun,arial,sans-serif;
		text-align:center;
		padding-top:60px;
	}
</style>
  </head>
  
  <body>
  	<div class="title">张家口市房地产市场数据统计系统</div>
    <%@ include file="/scripts/loading/loading.jsp"%>
    <%@ include file="/scripts/ext-3.4.0/extjs.jsp"%>
  	<script type="text/javascript" src="${ctx}/scripts/jquery/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/LoginDialog.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/App.js"></script>
  </body>
</html>
<script type="text/javascript">
//$(document).ready(function(){
//	$("body").css("background-image","url(images/fengjing.jpg)");
//	$("body").css("background-repeat","repeat");
//});
</script>
