package model;


import java.io.Serializable;

public class Manuals implements Serializable {
//フィールド
	private int id;
	private int group_number;
	private String manual_name;


//コンストラクタ
	public Manuals() {
		//処理なし
	}

	public Manuals(String manual_name) {
		//manuals_nameだけ
		super();
		this.manual_name = manual_name;

	}

	public Manuals(String manual_name, int pr_group) {
		super();
		this.manual_name = manual_name;
		this.group_number = pr_group;
	}

	public Manuals(int group_number) {
		//group_numberだけ
		super();
		this.group_number = group_number;

	}
//メソッド
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroup_number() {
		return group_number;
	}
	public void setGroup_number(int group_number) {
		this.group_number = group_number;
	}
	public String getManual_name() {
		return manual_name;
	}
	public void setManual_name(String manual_name) {
		this.manual_name = manual_name;
	}

}
