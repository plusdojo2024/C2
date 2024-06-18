package model;

import java.io.Serializable;

public class LoginUser implements Serializable {

	//field
	private String loginUserId; //ログインユーザーIDの取得
	private int group_id;

	//constructor
	public LoginUser() {
		this(null);
	}
	public LoginUser(String loginUserId) {
		super();
		this.loginUserId = loginUserId;
	}

	public LoginUser(int group_id) {
		super();
		this.group_id = group_id;
	}
	public LoginUser(String loginUserId, int group_id) {
		super();
		this.loginUserId = loginUserId;
		this.group_id = group_id;
	}

	//method
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public int getGroupId() {
		return group_id;
	}
	public void setGroupId(int GroupId) {
		this.group_id = GroupId;
	}


}
