<%@ page language="java" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<% 
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","application/force-download");
response.setHeader("Content-Type","application/vnd.ms-excel");
response.setHeader("Content-Disposition","attachment;filename=export.xls");
out.print(request.getParameter("exportContent")); 
%> 