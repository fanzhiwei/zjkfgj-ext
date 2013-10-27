package net.fanzhiwei.zjkfgj.statistics.dto;

public class UserRecordStatistics {
	private String userName;
	private String recordFlag;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRecordFlag() {
		if (recordFlag == null) {
			return recordFlag;
		}
		if ("-1".equals(recordFlag)) {
			return "未填";
		}
		if ("-2".equals(recordFlag)) {
			return "已填";
		}
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}
}
