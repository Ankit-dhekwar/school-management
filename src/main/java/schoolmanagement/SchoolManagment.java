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
@WebServlet("/signup")
public class SchoolManagment extends HttpServlet {
 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		principal principal=new principal();
		
		principal.setName(req.getParameter("name"));
		principal.setAge(Integer.parseInt(req.getParameter("age")));
		principal.setMobileno(Long.parseLong(req.getParameter("mobileno")));
		principal.setEmail(req.getParameter("email"));
		principal.setPassword(req.getParameter("password"));
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pro1");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(principal);
		et.commit();
		
		
		PrintWriter w=resp.getWriter();
		w.write("please login");
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
		
	} {
		
		
		

	}
}
