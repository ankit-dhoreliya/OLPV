package org.itc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role{
	private int roleId;
	private String roleName;
	//private Set<User> users = new HashSet<User>(0);
	
	
	public Role(){
		
	}
	
	public Role(String roleName) {
		
		this.roleName = roleName;
	}

	
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		//this.users = users;
	}
	
	@Id
	@Column(name="roleId")
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Column(name="roleName")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}*/
	

}
