<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Jira"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 1rem 2rem;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	font-weight: normal;
	font-size: .875rem;
	color: #666;
	background: #eee;
	position: sticky;
	top: 0;
}

img {
	width: 80px;
	display: block;
	margin: 0 auto;
	margin-bottom: .5rem;
}

@media ( max-width : 500px) {
	.heading {
		display: none;
	}
	td {
		display: block;
	}
	.car-name {
		background: #eee;
	}
}

h1 {
	text-align: center;
	font-size: 2.5rem;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String message="";
	if(request.getAttribute("msg") != null){
		message=(String)request.getAttribute("msg");	
	}
%>
	<%
	String tableDetails = "";

	ArrayList<Jira> jiras = (ArrayList<Jira>) request.getAttribute("jiraList");

	for (Jira jira : jiras) {
		tableDetails = tableDetails + "<tr>	" + "<td>" + jira.getId() + "</td>" + " <td>" + jira.getAssignee() + "</td>"
		+ " <td>" + jira.getReporter() + "</td>" + " <td>" + jira.getHead() + "</td>" + "<td>" + jira.getStatus()
		+ "</td> " + "<td>" + "<button type=\"button\"><a href=\"editJira?id="+jira.getId()+"\" class=\"text-link\">Edit</a></button>"
		+ "<br><br>" + "<button type=\"button\"><a href=\"delete?id="+jira.getId()+"\" class=\"text-link\">Delete</a></button>"
		+ "</td> " + "</tr>";
	}
	%>
	<%
String usl="";
ArrayList<String> userlist=new ArrayList<String>();
userlist=(ArrayList<String>)request.getAttribute("userList");

for(String str:userlist){
	usl=usl+"<option >"+str+"</option>"	;
	
}

%>
	<a href="Home">HOME</a>
	<div class="table-reponsive box">
		<table id="example" class="table table-striped table-bordered">
		<%= message %>
			<thead>
				<tr>
					<th>ID</th>
					<th>Assignee</th>
					<th>Reporter</th>
					<th>Problem</th>
					<th>Status</th>
					<th>Option</th>
				</tr>
			</thead>
			<tbody>

				<%=tableDetails%>


			</tbody>
		</table>
<form method="get" action="/JiraToolWeb/viewJira">
<div class="box">
<input type="checkbox" name="search">consider filter
<br>
<input type="checkbox" name="assgineeCheckBox" >
<label >Assignee:</label>
<select name="assignee" class="email2">
<%=usl %>
</select> 
<input type="checkbox" name="ReporterCheckBox" >
<label>Reporter:</label>
<select name="reportee" class="email2">
<%=usl %>
<input type="checkbox" name="statusCheckBox" >
<label >Status:&nbsp&nbsp&nbsp</label>
<select name="status" id="status" class="email2">
  <option name="To-do" >To-do</option>
  <option name="Analysis Wip">Analysis Wip</option>
  <option name="Analysis Done">Analysis Done</option>
  <option name="Dev Wip">Dev Wip</option>
   <option name="Dev Done">Dev Done</option>
</select>
<button class="btn" type="submit">search</button> 


  
</div> <!-- End Box -->
  
</form>
		
	</div>
</body>
</html>