package model;


import java.io.Serializable;

public class Groups implements Serializable {
  //field
	private int id; //管理番号
	private String group_name; //グループ名
	private String user_ID; //メンバー
	private boolean editer; //編集者権限
	private String icon; //アイコン


	//引数無しのコンストラクタ
	public Groups() {


	}

	public Groups(int id) {
		super();
		this.id = id;
	}

	public Groups(String group_name) {
		super();
		this.group_name = group_name;
	}

	public Groups(String user_ID, String group_name) {
		super();
		this.user_ID = user_ID;
		this.group_name = group_name;
	}

	//引数ありのコンストラクタ
	public Groups(int id, String group_name, String user_ID, boolean editer, String icon) {
		super();
		this.id = id;
		this.group_name = group_name;
		this.user_ID = user_ID;
		this.editer = editer;
		this.icon = icon;
	}

	//引数三つのコンストラクタ
	public Groups(String group_name, String icon, String user_ID) {
		super();
		this.group_name = group_name;
		this.icon = icon;
		this.user_ID = user_ID;
	}

	//引数三つのコンストラクタ(グループ切り替えの際に使用＝groupsDao=SLECT)
	public Groups(String group_name, int id, String user_ID) {
		super();
		this.group_name = group_name;
		this.id = id;
		this.user_ID = user_ID;
	}



	//ゲッターとセッターの登録
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public boolean isEditer() {
		return editer;
	}
	public void setEditer(boolean editer) {
		this.editer = editer;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}


}
