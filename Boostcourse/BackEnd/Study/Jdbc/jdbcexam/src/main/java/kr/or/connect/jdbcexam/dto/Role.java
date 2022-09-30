package kr.or.connect.jdbcexam.dto;

public class Role {
	private Integer role_id;
	private String description;
	
	public Role() {
		
	}
	
	public Role(Integer role_id, String description) {
		super();
		this.role_id = role_id;
		this.description = description;
	}
	
	public Integer getRoleId() {
		return role_id;
	}
	public void setRoleId(Integer role_id) {
		this.role_id = role_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", description=" + description + "]";
	}
	
}
