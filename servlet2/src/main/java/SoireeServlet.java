

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import concertDAO.PersistenceKind;
import donnees.TBilletbil;
import donnees.TConcertcon;
import donnees.TSallesal;
import donnees.TSoireesor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import concertDAO.AbstractDAOFactory;
import concertDAO.ConcertDAOFactory;
import concertDAO.DAO;
import concertDAO.DAOException;
import concertDAO.DAO_JPA_Billet;
import concertDAO.DAO_JPA_Salle;
import concertDAO.DAO_JPA_Soiree;
import concertDAO.DAO_JPA_Concert;

/**
 * Servlet implementation class SoireeServlet
 */
public class SoireeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConcertDAOFactory factory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoireeServlet() {
        super();
        factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
    }

    public List<TSoireesor> getListeSoirees() throws DAOException {
    	 DAO_JPA_Soiree daoSoiree = (DAO_JPA_Soiree)factory.getDAOSoiree(); 
		return daoSoiree.findAll();
	}
    
    public TSoireesor getSoiree(int id) throws DAOException {
   	 DAO_JPA_Soiree daoSoiree = (DAO_JPA_Soiree)factory.getDAOSoiree(); 
   	TSoireesor t =daoSoiree.find(id);
 
   	return t;
	}
    public TConcertcon getConcert(int id) throws DAOException {
     	 DAO_JPA_Concert daoConcert = (DAO_JPA_Concert)factory.getDAOConcert(); 
  		return daoConcert.find(id);
  	}
    public TSallesal getAgendaSalle(int id) throws DAOException {
      	 DAO_JPA_Salle daoSalle = (DAO_JPA_Salle)factory.getDAOSalle(); 
   		return daoSalle.find(id);
   	}
    public void postAcheterBillet(int idConcert,int nbBillet) throws DAOException {
     	 DAO_JPA_Billet daoBillet = (DAO_JPA_Billet)factory.getDAOBillet(); 
     	 DAO_JPA_Concert daoConcert = (DAO_JPA_Concert)factory.getDAOConcert(); 
     	 for(int i=0;i<nbBillet;i++) {
     		  TBilletbil t = new TBilletbil();
     		  t.setTConcertconconid(daoConcert.find(idConcert));
     		  daoBillet.create(t);
     	 }
     	
  		
  	}
    public List<TSallesal> getListeSalles() throws DAOException {
      	 DAO_JPA_Salle daoSalle = (DAO_JPA_Salle)factory.getDAOSalle(); 
   		return daoSalle.findAll();
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		if(operation==null) {
			try {
				// r�cup�re la liste des sportifs et l'associe � la requ�te HTTP
				request.setAttribute("soirees", this.getListeSoirees());
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/soirees.jsp")
				.forward(request, response);
		}
		else if(operation.equals("informationSoiree")){
			int idSoiree =Integer.parseInt(request.getParameter("soiree"));
			try {
				request.setAttribute("soiree", this.getSoiree(idSoiree));
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/soiree.jsp")
				.forward(request, response);
		}else if(operation.equals("agendaSalle")) {
			int idSalle =Integer.parseInt(request.getParameter("salleId"));
			try {
				request.setAttribute("salle", this.getAgendaSalle(idSalle));
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/agendaSalle.jsp")
				.forward(request, response);
		}else if(operation.equals("formBillet")) {
			int id =Integer.parseInt(request.getParameter("id"));
			String type=request.getParameter("type");
			try {
				request.setAttribute("concert", this.getConcert(id));
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/formBillet.jsp")
				.forward(request, response);
		}else if(operation.equals("acheterBillet")) {
			int nbBillet =Integer.parseInt(request.getParameter("nbBillet"));
			int idConcert =Integer.parseInt(request.getParameter("concert"));
			try {
				this.postAcheterBillet(idConcert, nbBillet);
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/formBillet.jsp")
				.forward(request, response);
		}else if(operation.equals("listeSalles")) {
			try {
				// r�cup�re la liste des sportifs et l'associe � la requ�te HTTP
				request.setAttribute("soirees", this.getListeSalles());
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/soirees.jsp")
				.forward(request, response);
			//PrintWriter out;
			//out = response.getWriter();
			//out.print(" reponse");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doGet(request, response);
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

}
