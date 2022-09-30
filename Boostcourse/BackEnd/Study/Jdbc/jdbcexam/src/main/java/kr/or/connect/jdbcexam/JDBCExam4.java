package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;


public class JDBCExam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roleId = 500;
		
		RoleDao dao = new RoleDao();
		int deleteId = dao.deleteRole(roleId);
		
		System.out.println(deleteId);
	}

}
