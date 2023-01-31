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
@WebServlet("/addstudent")
public class AddStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		student s=new student();
		s.setId(Integer.parseInt(req.getParameter("id")));
		s.setName(req.getParameter("name"));
		s.setBranch(req.getParameter("branch"));
		s.setFees(Double.parseDouble(req.getParameter("fees")));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pro1");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		
		PrintWriter w=resp.getWriter();
		w.write("sucessfully done");
		
		RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
		
	} 
}
