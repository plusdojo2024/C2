package model;


import java.io.Serializable;

public class Accounts implements Serializable {
//フィールド
	private String user_ID;//
	private String mail;
	private String pw;
	private String newPassword;
	private String nickname;
	private int pr_group;

//コンストラクター
	public Accounts() {
		//処理なし
	}

	public Accounts(String user_ID) {
		super();
		this.user_ID = user_ID;
	}

	public Accounts(String user_ID,String pw) {
		super();
		this.user_ID = user_ID;
		this.pw = pw;
	}

	public Accounts(int pr_group,String user_ID) {
		super();
		this.pr_group = pr_group;
		this.user_ID = user_ID;
	}

	public Accounts(String user_ID, String mail, String nickname) {
		super();
		this.user_ID = user_ID;
		this.mail = mail;
		this.nickname = nickname;
	}

	public Accounts(String user_ID, String mail, String pw, String nickname) {
		super();
		this.user_ID = user_ID;
		this.mail = mail;
		this.pw = pw;
		this.nickname = nickname;
	}
	public Accounts(String user_ID, String mail, String pw, String nickname, int pr_group) {
		super();
		this.user_ID = user_ID;
		this.mail = mail;
		this.pw = pw;
		this.nickname = nickname;
		this.pr_group = pr_group;
	}

public Accounts(String user_ID, String mail, String pw, String newPassword, String nickname, int pr_group) {
		super();
		this.user_ID = user_ID;
		this.mail = mail;
		this.pw = pw;
		this.newPassword = newPassword;
		this.nickname = nickname;
		this.pr_group = pr_group;
	}

	//メソッド
	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPr_group() {
		return pr_group;
	}
	public void setPr_group(int pr_group) {
		this.pr_group = pr_group;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}



