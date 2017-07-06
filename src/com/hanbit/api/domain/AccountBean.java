package com.hanbit.api.domain;

import java.util.Calendar;

public class AccountBean {
	private String name, pw, id, txDate, ssn;
	private int accountNo, money;
	// 상수값
	// 통장번호는 8자리 random 번호
	// 은행이름 KB 국민은행 - 상수는 overriding 하는 방식
	public final static String BANK = "KB국민은행";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getTxDate() {
		return txDate;
	}

	public void setTxDate() {
		Calendar now=Calendar.getInstance();
		int yy=now.get(now.YEAR);
		int mm= now.get(now.MONTH);
		int dd=now.get(now.DATE);
		String date=dd+"."+mm+"."+yy;
		this.txDate =date;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setAccountNo(int accounNO) {
		accountNo = accounNO;
	}

	public int getAccountNo() {
		return accountNo;
	}

	@Override
	public String toString() {
		return BANK+"\t 계좌정보: "
				+ " [이름 :" + name + ","
				+ "  계좌번호 :" + accountNo 
				+ "  잔액: " + money + "]";
	}

}
