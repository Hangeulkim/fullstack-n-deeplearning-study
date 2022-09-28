package kr.or.connect.jdbcexam.dao;
import kr.or.connect.jdbcexam.dto.Role;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RoleDao {
	String uri = "mongodb://localhost:27017"; //mysql 에서의 myurl과 같은 역할입니다.
	BasicDBObject query = new BasicDBObject(); // 쿼리문을 사용하기 위한 String sql과 동일한 역할입니다.
	
	public Role getRole(Integer roleId) {
		Role role = null;
		Document doc = null;
		
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
}
