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

@WebServlet("/teacherinsert")
public class Addteacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	teacher t=new teacher();
	t.setId(Integer.parseInt(req.getParameter("id")));
	t.setName(req.getParameter("name"));
	t.setSalary(Double.parseDouble(req.getParameter("salary")));
	t.setSubject(req.getParameter("subject"));
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pro1");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	et.begin();
	em.persist(t);
	et.commit();
	
	
	PrintWriter w=resp.getWriter();
	w.write("sucessfully inserted");
	
	RequestDispatcher rd=req.getRequestDispatcher("teacher.html");
	rd.include(req, resp);
	resp.setContentType("text/html");
	}

}
