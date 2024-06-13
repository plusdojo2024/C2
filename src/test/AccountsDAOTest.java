package test;

import dao.AccountsDAO;
import model.Accounts;

public class AccountsDAOTest {
	public static void main(String[] args) {
		AccountsDAO dao = new AccountsDAO();
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Accounts insRec = new Accounts("user1", "gmail.com","pass","パパ",1);
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		}
		else {
			System.out.println("登録失敗！");
		}

//		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Accounts upRec = new Accounts("user1", "upGmail.com", "upPass","upパパ",1);
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}
		// changeGroup()のテスト
		System.out.println("---------- changeGroup()のテスト ----------");
		Accounts CGRec = new Accounts(10,"user1");
		if (dao.changeGroup(CGRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

	}


}
