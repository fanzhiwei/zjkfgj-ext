package net.fanzhiwei.zjkfgj.role.domain;

import java.io.Serializable;
import java.util.List;

import net.fanzhiwei.zjkfgj.menu.domain.Menu;






public class Role implements Serializable {

	private static final long serialVersionUID = -6179411339504526803L;
	
	private Long id;
	private String name;
	private String description;
	/**
	 * 关联菜单
	 */
	private List<Menu> menus;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
