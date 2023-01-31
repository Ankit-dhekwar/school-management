package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteteacher")
public class DeleteTeacher extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pro1");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	int id=(Integer.parseInt(req.getParameter("id")));
	
	teacher t=em.find(teacher.class, id);
	et.begin();
	em.remove(t);
	et.commit();
	
	if(t!=null)
	{
		PrintWriter w=resp.getWriter();
		w.write("sucessfully removed");
		
		RequestDispatcher rd=req.getRequestDispatcher("teacher.html");
		rd.include(req, resp);
		resp.setContentType("text/html");;
	}
	else
	{
		PrintWriter w=resp.getWriter();
		w.write("invalid id");
		
		RequestDispatcher rd=req.getRequestDispatcher("Deleteteacher.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
}
}
