package net.fanzhiwei.zjkfgj.user.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.fanzhiwei.zjkfgj.role.domain.Role;


public class User implements Serializable {
	private static final long serialVersionUID = -5268898209820709788L;
	
	private Long id;
	private String name;
	private String otherName;
	private Integer userType;
	private String password;
	private Date createDate;
	private List<Role> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
}
