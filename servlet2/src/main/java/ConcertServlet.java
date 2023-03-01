

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import concertDAO.AbstractDAOFactory;
import concertDAO.ConcertDAOFactory;
import concertDAO.DAOException;
import concertDAO.DAO_JPA_Concert;
import concertDAO.PersistenceKind;
import donnees.TConcertcon;

/**
 * Servlet implementation class ConcertServlet
 */
public class ConcertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcertDAOFactory factory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertServlet() {
        super();
        factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
    }
    public TConcertcon getConcert(int id) throws DAOException {
    	 DAO_JPA_Concert daoConcert = (DAO_JPA_Concert)factory.getDAOConcert(); 
 		return daoConcert.find(id);
 	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("getConcert")) {
			int id =Integer.parseInt(request.getParameter("id"));		
			 try {
				TConcertcon t=this.getConcert(id);
				PrintWriter out;
				out = response.getWriter();
				out.print(t.tojson());
			} catch (DAOException e) {
				// TODO Auto-generated catch block
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
