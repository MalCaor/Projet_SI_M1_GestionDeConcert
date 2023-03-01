package mongo_DAO;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import com.mongodb.client.model.Filters;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

import mongoPojo.Information;
import org.bson.Document;

public class DAO_Mongo_Informations {
	private MongoDatabase database; 
	private MongoCollection<Document> collection;
	public DAO_Mongo_Informations(String URLconnection,String databaseName) {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		ConnectionString connectionString = new ConnectionString(URLconnection);
		MongoClient mongoClient = MongoClients.create(connectionString);
		database = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
		collection=database.getCollection("informations", Document.class);
	}
	
	public MongoCollection<Document> getAllInformation() {
		return this.collection;
	}
	
	public Document getOneInformation(String who,int id) {
		Bson filter = Filters.and(Filters.eq("informationDe",who),Filters.eq("informationDeID",id));
		collection.find(filter).first();
		return collection.find(filter).first();
	}
	public FindIterable<Document>getInformations(String who,int id) {
		Bson filter = Filters.and(Filters.eq("informationDe",who),Filters.eq("informationDeID",id));
		return collection.find(filter);
	}
	public void addInformation(Document data) {
		this.collection.insertOne(data);
	}
	
	public void updateOneInformation(Bson filter, Bson update) {
		UpdateResult result = this.collection.updateMany(filter, update);	
	}
	public void replaceOneInformation(Bson filter, Document replace) {
		this.collection.replaceOne(null, replace);
	}
	
	public void deleteADocument(Bson filter) {
		this.getAllInformation().deleteOne(filter);
	}
}
