<%@page import="schoolmanagement.teacher"%>
<%@page import="schoolmanagement.student"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<center><h1 >  <a style="text-decoration: none " href="welcome.html">Menu</a></h1></center>

<h2 style="color:black">____________________________________________________________________________________________________________________________________________________________________________________________________</h2><br>


<%
EntityManagerFactory emf = Persistence.createEntityManagerFactory("pro1") ;
EntityManager em = emf.createEntityManager() ;

Query q=em.createQuery("select a from teacher a");

List<teacher> l=q.getResultList();
%>
<center>
<table border="2" cellspacing="5" style="border: 2px black;">
<th>Id</th>
<th>Name</th>
<th>Salary</th>
<th>Subject</th>

<% for(teacher t:l)
	{
	%>
	<tr><td><%= t.getId() %></td>
	<td><%= t.getName() %></td>
	<td><%= t.getSalary() %></td>
	<td><%= t.getSubject() %></td></tr>
	
	<%} %>
</table>
</center>

</body>
</html>