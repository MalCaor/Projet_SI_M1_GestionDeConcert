package donnees;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mongoPojo.Federation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.bson.codecs.configuration.CodecProvider;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import static com.mongodb.client.model.Filters.eq;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SportifServletM extends HttpServlet{
private static final long serialVersionUID = 0;
	
	public List<Sportif> getListeSportifs() {
		// requête JPQL pour récupérer les sportifs dans la BDD
		// connexion à la base Mongo et à la base "sports"
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
		MongoClient mongoClient = MongoClients.create(connectionString);
		MongoDatabase database = mongoClient.getDatabase("sports").withCodecRegistry(pojoCodecRegistry);
		
		MongoCollection<Sportif> sportifs = database.getCollection("sportifs", Sportif.class);
		
		List<Sportif> sp= new ArrayList<Sportif>();
		for(Sportif sportif : sportifs.find()) {
			sp.add(sportif);
		}
		return sp;
	}
	/*
	public void addSport(String intitule) {
		// requête JPQL pour récupérer les sportifs dans la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpasport");
		EntityManager em = emf.createEntityManager();
		Query requete = em.createQuery("insert into sport values (null,'"+intitule+"'");
		return ;
	}*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if (operation.equals("listeSportif")) {
			// récupère la liste des sportifs et l'associe à la requête HTTP
			request.setAttribute("sportifs", this.getListeSportifs());
			// forwarde la requête à la page JSP
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
}
