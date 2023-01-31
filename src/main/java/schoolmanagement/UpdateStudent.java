package schoolmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pro1") ;
		     EntityManager em = emf.createEntityManager() ;
		     EntityTransaction et = em.getTransaction() ;
		     
		     String id = req.getParameter("id") ;
		     String name = req.getParameter("name") ;
		     String branch = req.getParameter("branch") ;
		     String fees = req.getParameter("fees") ;
		     
		     student s = new student() ;
		     s.setId(Integer.parseInt(id));
		     s.setName(name);
		     s.setBranch(branch);
		     s.setFees(Double.parseDouble(fees));
		     
		     
		     et.begin();
		     em.merge(s) ;
		     et.commit();
		     
		     resp.setContentType("text/html");
				PrintWriter pw = resp.getWriter() ;
				pw.write("updated successfully");
				
				RequestDispatcher rd = req.getRequestDispatcher("student.html") ;
				rd.include(req, resp);
	    }
	

}
