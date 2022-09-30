package kr.or.connect.jdbcexam.dao;
import kr.or.connect.jdbcexam.dto.Role;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonValue;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class RoleDao {
	String uri = "mongodb://localhost:27017"; //mysql 에서의 myurl과 같은 역할입니다.
	BasicDBObject query = new BasicDBObject(); // 쿼리문을 사용하기 위한 String sql과 동일한 역할입니다.
	Document doc = null;
	
	public Role getRole(Integer roleId) {
		Role role = null;
		
		try (MongoClient mongoClient = MongoClients.create(uri)){
			MongoDatabase database = mongoClient.getDatabase("JDBC_EXAM"); //정하신 DB명
			MongoCollection<Document> collection = database.getCollection("role"); // 정하신 collection 명
			
			query.put("role_id", roleId); //기본적으로 put은 eq 동일한 걸 찾아줍니다.
			doc = collection.find(query).first();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(doc);
		
		role = new Role(roleId,doc.getString("description")); //Document 타입에서 특정 value값을 가져오는 방법
		return role;
	}
	
	public BsonValue addRole(Role role) {
		 InsertOneResult insertRole = null;
		
		try (MongoClient mongoClient = MongoClients.create(uri)){
			MongoDatabase database = mongoClient.getDatabase("JDBC_EXAM"); //정하신 DB명
			MongoCollection<Document> collection = database.getCollection("role"); // 정하신 collection 명
			
			doc = new Document();
			doc.put("role_id", role.getRoleId());
			doc.put("description", role.getDescription());
			
			insertRole = collection.insertOne(doc);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return insertRole.getInsertedId();
	}
	
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<>();
		
		try{
			SimpleMongoClientDatabaseFactory simpleMongoDbFactory = new SimpleMongoClientDatabaseFactory(uri+"/JDBC_EXAM");
		    MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		    
			Query query = new Query();
			query.with(Sort.by("role_id").descending());//role_id를 기준으로 desc정렬
			
			list = mongoTemplate.find(query,Role.class,"role");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		return list;
	}
	
	public int deleteRole(Integer role_id) {
		try{
			SimpleMongoClientDatabaseFactory simpleMongoDbFactory = new SimpleMongoClientDatabaseFactory(uri+"/JDBC_EXAM");
		    MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		    
		    Criteria criteria = new Criteria("role_id");
		    criteria.is(role_id);
			Query query = new Query(criteria);
			
			mongoTemplate.remove(query,"role");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return role_id;
	}
	
	public int updateRole(Role role) {
		try{
			SimpleMongoClientDatabaseFactory simpleMongoDbFactory = new SimpleMongoClientDatabaseFactory(uri+"/JDBC_EXAM");
		    MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		    
		    Criteria criteria = new Criteria("role_id");
		    criteria.is(role.getRoleId());
			Query query = new Query(criteria);
			Update update = new Update();
			update.set("description", role.getDescription());
			
			mongoTemplate.updateFirst(query,update,"role");
			//전부 바꿀때 mongoTemplate.updateMulti(query,update,"role");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return role.getRoleId();
	}
}
