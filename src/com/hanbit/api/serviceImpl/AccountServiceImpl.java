package com.hanbit.api.serviceImpl;

import java.util.Vector;

import com.hanbit.api.domain.AccountBean;
import com.hanbit.api.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountBean bean;
	Vector<AccountBean> list;

	public AccountServiceImpl() {
		bean = new AccountBean();
		list = new Vector<>(10,10);
	}

	@Override
	public void createAccount(AccountBean bean) {
		int randomNo=(int)(Math.random()*(99999999+10000000));
		System.out.println("ronadomNO: "+randomNo);
		bean.setAccountNo(randomNo);
		list.add(bean);
		System.out.println("check: "+bean.toString());
	}

	@Override
	public int accountUsers() {
		// 계좌 수
		return list.size();
	}

	@Override
	public Vector<AccountBean> listAccount() {
		//계좌 목록
		return list;
	}

	@Override
	public AccountBean findByAccountNo(int accountNo) {
		bean=new AccountBean();
		for(int i=0;i<list.capacity();i++){
			if(accountNo==list.indexOf(i)){
				bean=list.get(i);
				break;
			}
		}
		return bean;
	}

	@Override
	public Vector<AccountBean> findByName(String name) {
		// 계좌번호 조회
		Vector<AccountBean> findByName = new Vector<>();
		for(int i=0;i<list.capacity();i++){
			if(name.equals(list.get(i).getName())){
			    
			}
		}
		return findByName;
	}

	@Override
	public void modifyPassword(AccountBean bean) {
		// 비밀번호 변경
		
	}

	@Override
	public void updateDeposit(AccountBean bean) {
		// 예금

	}

	@Override
	public void deleteAccount(int accountNo) {
		// 계좌 해지
	}

	@Override
	public void updateWithraw(AccountBean bean) {
		// 출금
		
	}

}
