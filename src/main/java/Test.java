import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.bson.Document;

import concertDAO.AbstractDAOFactory;
import concertDAO.ConcertDAOFactory;
import concertDAO.DAOException;
import concertDAO.DAO_JPA_Soiree;
import concertDAO.PersistenceKind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConcertDAOFactory factory;
	
	public Test() {
		super();
		 factory = AbstractDAOFactory.getDAOFactory(PersistenceKind.JPA);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//this.connexionMongo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String operation = request.getParameter("operation");
		String json = "";
		if (operation.equals("listeSoirees")) {
			 DAO_JPA_Soiree daoSoiree;
			try {
				daoSoiree = (DAO_JPA_Soiree)factory.getDAOSoiree();
				daoSoiree.findAll();
				json += "[";
				//	for (Document doc : this.sportifs.find()) {
				//		json += doc.toJson() + ",";
				//	}
					if (json.length() > 1)
						json = json.substring(0, json.length() - 1);
					json += "]";
					out.write(json);
				
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
			
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}