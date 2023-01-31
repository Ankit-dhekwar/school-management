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

Query q=em.createQuery("select a from student a");

List<student> l=q.getResultList();
%>

<center><table  border="2" cellspacing="5" style="border: 2px black;" >
<th>Id</th>
<th>Branch</th>
<th>fees</th>
<th>name</th>

<% for(student s:l)
	{
	%>
	<tr><td><%= s.getId() %></td>
	<td><%= s.getBranch() %></td>
	<td><%= s.getFees() %></td>
	<td><%= s.getName() %></td></tr>
	
	<%} %>
</table>

</center>
</body>
</html>





