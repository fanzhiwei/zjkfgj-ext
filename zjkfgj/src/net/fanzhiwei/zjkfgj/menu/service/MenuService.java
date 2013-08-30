package net.fanzhiwei.zjkfgj.menu.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import net.fanzhiwei.zjkfgj.menu.domain.Menu;
import net.fanzhiwei.zjkfgj.menu.persistence.MenuMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class MenuService {
	@Autowired
	private MenuMapper menuMapper;
	/**
	 * 获取用户所对应的权限菜单
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Menu> getMenuListByUserId(Long userId) {
		Map<String,Object> param = new HashMap<String,Object>();
		List<Menu> mainMenuList = menuMapper.getMainMenuList(userId);
		Iterator<Menu> it = mainMenuList.iterator();
		//装载主菜单下所有的子菜单
		while(it.hasNext()) {
			Menu menu = it.next();
			//false:表示为主菜单
			menu.setLeaf(false);
			Long id = menu.getId();
			param.put("userId", userId);
			param.put("id", id);
			List<Menu> subMenuList = menuMapper.getSubMenuList(param);
			menu.setChildren(subMenuList);
		}
		return mainMenuList;
	}
	/**
	 * 获取所有的菜单(只包含了菜单id和菜单name)
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Menu> getMenuList() {
		List<Menu> menuList = menuMapper.getMenuList();
		return menuList;
	}
	/**
	 * 获取所有的菜单(包含了所有信息)
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Menu> getMenus() {
		List<Menu> menuList = menuMapper.getMenus();
		return menuList;
	}
	/**
	 * 获取所有的父菜单(只包含了菜单id和菜单name)
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Menu> getParentMenus() {
		List<Menu> menuList = menuMapper.getParentMenus();
		return menuList;
	}
	@Transactional(readOnly = true)
	public Long getId() {
		Long id = menuMapper.getId();
		return id;
	}
	/**
	 * 新增菜单
	 * @param menu
	 */
	public void insertMenu(Menu menu) {
		menuMapper.insertMenu(menu);
	}
	/**
	 * 修改菜单
	 * @param menu
	 */
	public void updateMenu(Menu menu) {
		menuMapper.updateMenu(menu);
	}
	/**
	 * 删除菜单
	 * @param menu
	 */
	public void deleteMenu(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++) {
			param.put("id", idsArray[i]);
			menuMapper.deleteMenu(param);
		}
	}
}
