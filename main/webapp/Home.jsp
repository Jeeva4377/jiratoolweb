<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<header>
  <a href="" class="app-logo">Jira Dashboard </span></a>
  <nav class="main-nav">
    <a href="showCreateJiraScreen" class="text-link -active">Create jira</a>
    <a href="viewJira" class="text-link">View jira</a>
    <a href="contact.html" class="text-link">Contact</a>
    <a href="logout" class="text-link">Logout <% out.print(request.getAttribute("uname")); %></a>
  </nav>
</header>
</body>
</html>