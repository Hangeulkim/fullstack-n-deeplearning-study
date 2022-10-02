package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {
String uri = "mongodb://localhost:27017/JDBC_EXAM";
	
    public List<BusinessCard> searchBusinessCard(String keyword){
    	List list = new ArrayList<BusinessCard>();
    	
    	try {
    		SimpleMongoClientDatabaseFactory simpleMongoDbFactory = new SimpleMongoClientDatabaseFactory(uri);
    		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
    		
    		Criteria regax = Criteria.where("name").regex(".*"+keyword+".*","i");
    		Query query = new Query(regax);
    		
    		list = mongoTemplate.find(query, BusinessCard.class, "BusinessCard");
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard){
    	try {
    		SimpleMongoClientDatabaseFactory simpleMongoDbFactory = new SimpleMongoClientDatabaseFactory(uri);
    		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
    		
    		mongoTemplate.insert(businessCard, "BusinessCard");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return businessCard;
    }
}
