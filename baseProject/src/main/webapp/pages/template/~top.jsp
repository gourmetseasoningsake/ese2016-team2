<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%-- check if user is logged in --%>
<security:authorize var="loggedIn" url="/profile" />

<%-- @Jerome
Use servletPath.lastIndexOf("/")+2 for tilde files. --%>
<%
	String servletPath = request.getServletPath();
	int indexFrom = servletPath.lastIndexOf("/")+1;
	int indexTo = servletPath.lastIndexOf(".");
	String pageName = servletPath.substring(indexFrom, indexTo);
%>

<!doctype html>
<html class="no-js" lang="de">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <title>FlatFindr | <% out.print(pageName); %></title>

  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%-- <link rel="apple-touch-icon" href="apple-touch-icon.png">
  <link rel="icon" href="favicon.png"> --%>

  <link rel="stylesheet" href="/resources/css/prod/app.css">

  <!--[if lt IE 9]>
      <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
      <script>window.html5 || document.write('<script src="js/dep/html5shiv.js"><\/script>')</script>
  <![endif]-->
</head>
<body <c:if test="${loggedIn}">logged</c:if> view class="<% out.print(pageName); %> headerPrimaryClosed headerPrimarySearchClosed sidebarClosed sidebarMessageClosed">
