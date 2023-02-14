import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import donnees.*;

public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	public List<Sportif> getListeSportifs() {
		// requ�te JPQL pour r�cup�rer les sportifs dans la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpasport");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("SELECT s FROM Sportif s");
		return (List<Sportif>) requete.getResultList();
	}
	
	public void addSport(String intitule) {
		// requ�te JPQL pour r�cup�rer les sportifs dans la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpasport");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("insert into sport values (null,'"+intitule+"'");
		return ;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("listeSportif")) {
			// r�cup�re la liste des sportifs et l'associe � la requ�te HTTP
			request.setAttribute("sportifs", this.getListeSportifs());
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/afficheSportifs.jsp")
				.forward(request, response);
		}else if(operation.equals("ajouterSport")) {
			 String intitule = request.getParameter("intitule");
			// ajouter sport

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpasport");
			EntityManager em = emf.createEntityManager();
			Sport s = new Sport();
			s.setIntitule(intitule);
			EntityTransaction trans=null;
			try {
				trans = em.getTransaction();
				trans.begin();
				em.persist(s);
				trans.commit();
			}catch(Exception e) {
				if(trans!=null)trans.rollback();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void processRequest(
			 HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 String action = request.getParameter("action");
		 
		 if (action.equals("creer")) {
			 String intitule = request.getParameter("intitule");
		 }
	}
		*/	 
	

}
