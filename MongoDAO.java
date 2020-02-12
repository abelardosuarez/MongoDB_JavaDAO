package profesores;

import org.bson.Document;
import org.bson.types.ObjectId;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.MalformedJsonException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoDAO {
	/*	External Archives
	 * 	bson-3.8.2.jar
	 * 	gson-2.2.2.jar
	 * 	mongodb-driver-3.11.0-.jar
	 * 	mongodb-driver-core-3.11.0-.jar
	 * 	mongo-java-driver-3.12.1.jar
	 */
	
	private MongoClient server;
	private MongoDatabase db;
	private  MongoCollection<Document> collection;
	
	public MongoDAO(String uriName, String dbName, String collectionName) {
		MongoClientURI uri = new MongoClientURI(uriName);
		server = new MongoClient(uri);
		db = server.getDatabase(dbName);
		collection = db.getCollection(collectionName);
	}
	
	public  void listarResultados() {
		FindIterable<Document> cursor = collection.find();
		System.out.println("---------------Inicio de coleccion--------------------");
		for(Document doc : cursor) {
			System.out.println(doc.toJson());
		}
		System.out.println("---------------Fin de coleccion--------------------");
	}

	public  List<Profesor> obtener() throws MalformedJsonException {
		List< Profesor> profesores = new ArrayList<Profesor>();
		try {
			Gson gson = new Gson();        
	    	FindIterable<Document> cursor = collection.find();
			for (Document doc : cursor) {
				profesores.add( (Profesor) gson.fromJson(doc.toJson(), Profesor.class));
				}
			}
			catch(MongoException e) {
				System.out.println( e.getMessage()); 
			}
			System.out.println("get Ok = toda la coleccion");
			return profesores;
	}

	public  Boolean registrar(Profesor profesor) throws MalformedJsonException {
		Gson gson = new Gson(); 
		Document docProfesor = parse(gson.toJson(profesor));
		try {
			collection.insertOne(docProfesor);
			}
			catch(MongoException e) {
				System.out.println("Error Mongo = "+ e.getMessage());
				return false;
			}
		System.out.println("registrar Ok "+parse(gson.toJson(profesor)));
		return true;	
	}
	
	public  void drop() {
		collection.drop();
		}
	
	public  Boolean actualizar(Profesor profesor) throws MalformedJsonException {
		Gson gson = new Gson(); 
		Document docProfesor = parse(gson.toJson(profesor));
		Document searchById = new Document();
		searchById.put("_id", new ObjectId(profesor.get_id()));
	    try {
			collection.replaceOne(searchById,docProfesor);
			}
			catch(MongoException e) {
				System.out.println("Error Mongo = "+ e.getMessage()); 
				return false;
				}
			System.out.println("actualizar Ok "+parse(gson.toJson(profesor)));
			return true;	
		}
	
	public  Boolean eliminar(Profesor profesor) throws MalformedJsonException {
		Document searchById = new Document();
		searchById.put("_id", new ObjectId(profesor.get_id()));
		try {
			collection.deleteOne(searchById);
			}
			catch(MongoException e) {
				System.out.println("Error Mongo = "+ e.getMessage()); 
				return false;
			}
			System.out.println("eliminar Ok "+profesor);
			return true;	
		}
	
	private  Document parse(String source) throws MalformedJsonException {
		try {
		    return Document.parse(source);
		  } catch (JsonIOException | org.bson.json.JsonParseException o_O) {
		    throw new MalformedJsonException("Error al generar JSON", o_O);
		  }
		}
}