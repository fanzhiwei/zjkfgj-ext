<%@page contentType="text/html;charset=UTF-8"%>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<%@ include file="/commons/taglibs.jsp"%>
<html>
  <head>
    <%@ include file="/commons/meta.jsp"%>
    <script type="text/javascript">
    	//登录用户名
    	var loginUserName = '<%=session.getAttribute("loginUserName")%>';
    </script>
    <title>张家口市房地产市场数据统计系统</title>
<style type="text/css">
	body {background-image: url(images/background.jpg);
	background-position: center;
	background-repeat: no-repeat;
	background-attachment: fixed;}
</style>
  </head>
  <body>
    <%@ include file="/scripts/loading/loading.jsp"%>
    <%@ include file="/scripts/ext-3.4.0/extjs.jsp"%>
    <link rel="stylesheet" type="text/css" href="${ctx}/scripts/ux/ext-patch.css" />
    <script type="text/javascript" src="${ctx}/scripts/ux/patcher.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/styles/MultiSelect.css" />
    <script type="text/javascript" src="${ctx}/scripts/ux/MultiSelect.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/ux/SearchField.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/ChangePasswordDialog.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/Main.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/jquery/jquery-1.8.2.min.js"></script>
  </body>
</html>
