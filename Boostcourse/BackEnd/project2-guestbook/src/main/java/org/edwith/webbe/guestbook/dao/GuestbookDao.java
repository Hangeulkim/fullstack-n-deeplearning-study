package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = null;

        MongoTemplate mongoTemplate = DBUtil.getConnection();
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC,"nid"));
        		
        list = mongoTemplate.find(query,Guestbook.class, "Books");
        
        return list;
    }

    public void addGuestbook(Guestbook guestbook){
    	MongoTemplate mongoTemplate = DBUtil.getConnection();
    	Query query = new Query();
        
        Long id = mongoTemplate.count(query,Guestbook.class, "Books");
    	guestbook.setnid(id+1);
    	mongoTemplate.insert(guestbook, "Books");
    }
}
