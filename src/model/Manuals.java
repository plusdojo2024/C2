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

	public Manuals(int id, int group_number, String manual_name) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.manual_name = manual_name;
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
