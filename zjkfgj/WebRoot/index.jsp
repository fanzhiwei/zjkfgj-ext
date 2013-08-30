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
    <title>Store</title>
  </head>
  <body>
    <%@ include file="/scripts/loading/loading.jsp"%>
    <%@ include file="/scripts/ext-3.4.0/extjs.jsp"%>
    <script type="text/javascript" src="${ctx}/scripts/LoginDialog.js"></script>
    <script type="text/javascript" src="${ctx}/scripts/App.js"></script>
  </body>
</html>
