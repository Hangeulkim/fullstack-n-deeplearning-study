import dao.RoleDao;
import dto.Role;

public class JDBCExam5 {
    public static void main(String[] args){
        int roleId = 100;
        String description = "CEO";

        Role role = new Role(roleId,description);

        RoleDao dao = new RoleDao();
        int updateCount = dao.updateRole(role);

        System.out.println(updateCount);
    }
}
