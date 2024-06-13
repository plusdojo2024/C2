package model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	//field
	private String loginUserId; //ログインユーザーIDの取得

	//constructor
	public LoginUser() {
		this(null);
	}
	public LoginUser(String loginUserId) {
		super();
		this.loginUserId = loginUserId;
	}

	//method
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}


}
