package org.edwith.webbe.guestbook.util;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

public class DBUtil {
    public static MongoTemplate getConnection(){
        // 본인 database에 맞게끔 수정해주세요.
        return getConnection("mongodb://localhost:27017/project2_guestbook");
    }

    public static MongoTemplate getConnection(String dbURL){
    	MongoTemplate mongoTemplate = null;
        try{
        	SimpleMongoClientDatabaseFactory simpleMongoDbFactory = new SimpleMongoClientDatabaseFactory(dbURL);
    		mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
            return mongoTemplate;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
