
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mongo_DAO.DAO_Mongo_Informations;

import java.io.IOException;
import java.io.PrintWriter;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MongoCollection<Document> informations;
	private DAO_Mongo_Informations dao;


	@Override
	public void init(ServletConfig config) throws ServletException {
		dao = new DAO_Mongo_Informations("mongodb://obiwan.univ-brest.fr:27017","zde_keryo");
		informations = dao.getAllInformation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Headers",
				"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		response.addHeader("Access-Control-Max-Age", "1728000");

		response.setContentType("application/json; charset=UTF-8");*/
		PrintWriter out = response.getWriter();
		String json = "";
		
		String type = request.getParameter("table");
		int id =Integer.parseInt(request.getParameter("id"));
			json += "[";
			for (Document doc : dao.getInformations(type,id)) {
				json += doc.toJson() + ",";
			}
			if (json.length() > 1)
				json = json.substring(0, json.length() - 1);
			json += "]";
			out.write(json);
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
