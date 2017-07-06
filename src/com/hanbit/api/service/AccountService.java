package com.hanbit.api.service;

import java.util.Vector;

import com.hanbit.api.domain.AccountBean;

public interface AccountService {
	public void  createAccount(AccountBean bean);
	public int accountUsers();
	public Vector <AccountBean> listAccount();
	public AccountBean findByAccountNo(int accountNo);
	public Vector<AccountBean> findByName(String name);
	public void modifyPassword(AccountBean bean);
	public void updateDeposit(AccountBean bean);
	public void updateWithraw(AccountBean bean);
	public void deleteAccount(int accountNo);
}
