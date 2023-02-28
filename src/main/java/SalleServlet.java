

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import concertDAO.AbstractDAOFactory;
import concertDAO.ConcertDAOFactory;
import concertDAO.DAOException;
import concertDAO.DAO_JPA_Salle;
import concertDAO.PersistenceKind;
import donnees.TSallesal;


/**
 * Servlet implementation class SalleServlet
 */
public class SalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ConcertDAOFactory factory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalleServlet() {
        super();
        factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
    }
    
    public List<TSallesal> getListeSalles() throws DAOException {
   	 DAO_JPA_Salle daoSalle = (DAO_JPA_Salle)factory.getDAOSalle(); 
		return daoSalle.findAll();
	}
    
    public TSallesal getSalle(int id) throws DAOException {
     	 DAO_JPA_Salle daoSalle = (DAO_JPA_Salle)factory.getDAOSalle(); 
  		return daoSalle.find(id);
  	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operation = request.getParameter("operation");
		if(operation.equals("listeSalles")) {
			try {
				PrintWriter out;
				out = response.getWriter();
				out.print("[");
				String salles="";
				for(TSallesal t :this.getListeSalles()) {
					salles+="{\"capacite\":"+t.getSalCapacité()+",\"nom\":\""+t.getSalNom() 
					+"\",\"adresse\":\""+t.getSalAdresse()+ "\",\"gestionnaireId\":null,"
							+ "\"id\":"+t.getSalId()+"},";
				}
				if(!salles.equals("")) {
					StringBuffer sb= new StringBuffer(salles);  
					sb.deleteCharAt(sb.length()-1);
					out.print(sb);
				}else {
					out.print(salles);
				}
				out.print("]");
			} catch (DAOException e) {
				e.printStackTrace();
			}			
		}else if(operation.equals("agendaSalle")) {
			int idSalle =Integer.parseInt(request.getParameter("salleId"));
			try {
				TSallesal t =this.getSalle(idSalle);
				String json="{\"capacite\":"+t.getSalCapacité()+",\"nom\":\""+t.getSalNom() 
				+"\",\"adresse\":\""+t.getSalAdresse()+ "\",\"gestionnaireId\":"+t.gettGestionnaireGstGstId().tojson()+","
				+ "\"id\":"+t.getSalId()+
				", \"soirees\""+"}";
				
				
				PrintWriter out;
				out = response.getWriter();
				out.print(json);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
