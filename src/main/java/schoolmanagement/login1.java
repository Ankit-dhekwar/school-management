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
@WebServlet("/login")
public class login1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("pro1");
		EntityManager em=emf.createEntityManager();
	  
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Query q=em.createQuery("select a from principal a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		
		List<principal>p=q.getResultList();
		
		if(p.size()>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
			rd.forward(req, resp);
			
		}
		else
		{
			PrintWriter w=resp.getWriter();
			w.write("invalid credetial");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		}
		
	}

}
