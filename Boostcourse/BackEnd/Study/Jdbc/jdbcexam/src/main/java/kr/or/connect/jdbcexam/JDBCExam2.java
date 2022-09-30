package kr.or.connect.jdbcexam;

import org.bson.BsonValue;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roleId = 500;
		String description = "TEST";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		BsonValue insertId = dao.addRole(role);
		
		System.out.println(insertId);
	}

}
