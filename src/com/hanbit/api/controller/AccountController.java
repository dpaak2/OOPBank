package com.hanbit.api.controller;
import java.util.Vector;
import javax.swing.JOptionPane;
import com.hanbit.api.domain.AccountBean;
import com.hanbit.api.service.AccountService;
import com.hanbit.api.serviceImpl.AccountServiceImpl;

public class AccountController {
	public static void main(String[] args) {
		AccountBean account=null;
		AccountService service=new AccountServiceImpl();
		Vector<AccountBean> list;
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료, 1.새로운 계좌생성, 2.회원수 3.계좌목록 4.계좌검색  5.이름으로 검색 6.비밀번호 변경 7.입급 8.출금 9.계좌삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료 됩니다");			
			return;
			case "1":
				account=new AccountBean();
				String []info=JOptionPane.showInputDialog("name/ID/PassWord/Social Security Number/Deposit").split("/");
				account.setName(info[0]);
				account.setId(info[1]);
				account.setPw(info[2]);
				account.setSsn(info[3]);
				account.setMoney(Integer.parseInt(info[4]));
				service.createAccount(account);
				JOptionPane.showMessageDialog(null,"welcome KB국민은행!!!"
						+ "\n 예금주 계좌번호: "+account.getAccountNo());
				break;
			case "2":
				JOptionPane.showMessageDialog(null,"총 계좌수는: "+service.accountUsers());
				break;
				//0.종료, 1.새로운 계좌생성, 2.회원수 3.계좌목록 4.계좌검색 5.비밀번호 변경 6.예금 7.출금 8.계좌삭제")) {
			case "3":
				list=service.listAccount();
				String sList="";
				System.out.println("list.get(0).toString()"+list.get(0).toString());
				for(int i=0;i<service.accountUsers();i++){
					sList+=list.get(i).toString()+"\n";
				}
				System.out.println("list"+sList);
				JOptionPane.showMessageDialog(null, "계좌 목록\n"+sList);
				break;
			case "4":
			    account= service.findByAccountNo(Integer.parseInt(JOptionPane.showInputDialog("조회하실 계좌 번호 입력")));
				JOptionPane.showMessageDialog(null, account.toString());
				break;
			case "5":
				//이름 검색
				Vector<AccountBean> nameList= service.findByName(JOptionPane.showInputDialog("조회하실 이름 검색"));
				
				JOptionPane.showInternalMessageDialog(null, "이름으로 검색 결과");
				break;
			case "6":
				account=new AccountBean();
				account.setId(JOptionPane.showInputDialog("아이디 입력"));
				account.setPw(JOptionPane.showInputDialog("새로운 비밀번호 입력"));
				service.modifyPassword(account);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 완료");
				break;
			case "7":
				account= new AccountBean();
				account.setAccountNo(Integer.parseInt(JOptionPane.showInputDialog("예금할 계좌번호 입력")));
				account.setMoney(Integer.parseInt(JOptionPane.showInputDialog("예금할 금액")));
				service.updateDeposit(account);
				JOptionPane.showMessageDialog(null, "예금 되었습니다.");
				break;
			case "8":
				account = new AccountBean();
				account.setAccountNo(Integer.parseInt(JOptionPane.showInputDialog("출금할 계좌 입력")));
				account.setMoney(Integer.parseInt(JOptionPane.showInputDialog("출금할 금액")));;
				service.updateWithraw(account);
				break;
			case "9":
				int accountNo= Integer.parseInt(JOptionPane.showInputDialog("해지하실 계좌번호 입력"));
				service.deleteAccount(accountNo);
				JOptionPane.showMessageDialog(null, "삭제완료");
				break;
		
			}
		}
	}

}
