package net.fanzhiwei.zjkfgj.money.persistence;

import java.util.List;
import java.util.Map;

import net.fanzhiwei.zjkfgj.money.domain.Money;
import net.fanzhiwei.zjkfgj.money.domain.MoneyList;


public interface MoneyMapper {
	int getMoneyListCount();
	List<Money> getMoneyList(Map<String,Integer> pageParam);
	Long getMoneyId();
	void insertMoney(Money money);
	void insertMoneyList(MoneyList moneyList);
	void updateMoney(Money money);
	void deleteMoneyList(Map<String,Object> param);
	void deleteMoney(Map<String,Object> param);
}
