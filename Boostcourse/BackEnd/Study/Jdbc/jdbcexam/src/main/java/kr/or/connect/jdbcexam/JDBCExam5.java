package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;


public class JDBCExam5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roleId = 500;
		String description = "CEO";
		
		Role role = new Role(roleId,description);
			
		RoleDao dao = new RoleDao();
		int updateId = dao.updateRole(role);
		
		System.out.println(updateId);
	}

}
