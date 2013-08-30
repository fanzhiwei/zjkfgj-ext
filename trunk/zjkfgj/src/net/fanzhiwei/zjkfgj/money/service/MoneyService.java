package net.fanzhiwei.zjkfgj.money.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.money.domain.Money;
import net.fanzhiwei.zjkfgj.money.domain.MoneyList;
import net.fanzhiwei.zjkfgj.money.persistence.MoneyMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
//默认将类中的所有函数纳入事务管理.
@Transactional
public class MoneyService {
	@Autowired
	private MoneyMapper moneyMapper;
	/**
	 * 获取消费列表的总条数
	 * @return
	 */
	@Transactional(readOnly = true)
	public int getMoneyListCount() {
		return moneyMapper.getMoneyListCount();
	}
	
	/**
	 * 获取消费列表
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Money> getMoneyList(Map<String,Integer> pageParam) {
		return moneyMapper.getMoneyList(pageParam);
	}
	/**
	 * 获取消费Id
	 * @return
	 */
	@Transactional(readOnly = true)
	public Long getMoneyId() {
		return moneyMapper.getMoneyId();
	}
	/**
	 * 增加消费信息
	 * @param money
	 * @param moneyList
	 */
	public void insertMoneyAndMoneyList(Money money,List<MoneyList> moneyListList) {
		moneyMapper.insertMoney(money);
		Iterator<MoneyList> it = moneyListList.iterator();
		while(it.hasNext()) {
			MoneyList moneyList = it.next();
			moneyMapper.insertMoneyList(moneyList);
		}
	}
	/**
	 * 编辑消费信息
	 * @param money
	 * @param moneyList
	 */
	public void updateMoneyAndMoneyList(Money money,List<MoneyList> moneyListList,Map<String,Object> param) {
		moneyMapper.updateMoney(money);
		moneyMapper.deleteMoneyList(param);
		Iterator<MoneyList> it = moneyListList.iterator();
		while(it.hasNext()) {
			MoneyList moneyList = it.next();
			moneyMapper.insertMoneyList(moneyList);
		}
	}
	/**
	 * 删除消费信息
	 * @param param
	 */
	public void deleteMoneyAndMoneyList(Map<String,Object> param) {
		String ids = (String)param.get("ids");
		String[] idsArray = ids.split(",");
		for(int i=0;i<idsArray.length;i++) {
			param.put("id", idsArray[i]);
			param.put("money_id", idsArray[i]);
			moneyMapper.deleteMoneyList(param);
			moneyMapper.deleteMoney(param);
		}
	}
}
