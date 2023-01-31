package schoolmanagement;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewstudent")
public class ViewStudent extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pro1");
    EntityManager em=emf.createEntityManager();
    
    int id=Integer.parseInt(req.getParameter("id"));
    
    student s=em.find(student.class, id);
    
    
}
}
