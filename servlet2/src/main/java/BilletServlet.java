

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mapper.AcheterBilletMapper;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import concertDAO.AbstractDAOFactory;
import concertDAO.ConcertDAOFactory;
import concertDAO.DAOException;
import concertDAO.DAO_JPA_Billet;
import concertDAO.DAO_JPA_Concert;
import concertDAO.PersistenceKind;
import donnees.TBilletbil;

/**
 * Servlet implementation class BilletServlet
 *  inutile
 */
public class BilletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcertDAOFactory factory;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BilletServlet() {
        super();
        factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
		 ObjectMapper objectMapper = new ObjectMapper();
		 AcheterBilletMapper myItem = objectMapper.readValue(request.getInputStream(),AcheterBilletMapper.class);
		 if(myItem.getOperation().equals("acheterBillet")) {
				int nbBillet = myItem.getNbBillet();
				int idConcert =myItem.getConcertId();
				try {
					this.postAcheterBillet(idConcert, nbBillet);
				} catch (DAOException e) {
					e.printStackTrace();
				}
			}
	}

}
