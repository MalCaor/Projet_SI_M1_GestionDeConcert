

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import concertDAO.PersistenceKind;
import donnees.TSoireesor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import concertDAO.AbstractDAOFactory;
import concertDAO.ConcertDAOFactory;
import concertDAO.DAO;
import concertDAO.DAOException;
import concertDAO.DAO_JPA_Soiree;

/**
 * Servlet implementation class SoireeServlet
 */
public class SoireeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoireeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public List<TSoireesor> getListeSoirees() throws DAOException {
    	 ConcertDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
    	 DAO_JPA_Soiree daoSoiree = (DAO_JPA_Soiree)factory.getDAOSoiree(); 
		return daoSoiree.findAll();
	}
    public TSoireesor getSoiree(int id) throws DAOException {
   	 ConcertDAOFactory factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
   	 DAO_JPA_Soiree daoSoiree = (DAO_JPA_Soiree)factory.getDAOSoiree(); 
		return daoSoiree.find(id);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String operation = request.getParameter("operation");
		if (operation.equals("listeSoirees")) {
			try {
				// r�cup�re la liste des sportifs et l'associe � la requ�te HTTP
				request.setAttribute("soirees", this.getListeSoirees());
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/soirees.jsp")
				.forward(request, response);
		}else if(operation.equals("informationSoiree")){
			int idSoiree =Integer.parseInt(request.getParameter("soiree"));
			try {
				request.setAttribute("soiree", this.getSoiree(idSoiree));
			} catch (DAOException e) {
				e.printStackTrace();
			}
			// forwarde la requ�te � la page JSP
			getServletConfig().getServletContext().getRequestDispatcher("/soiree.jsp")
				.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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

}
