package model;

import java.io.Serializable;
import java.sql.Date;

public class Tasks implements Serializable {

	//field
	private int id; //管理番号
	private int group_number;	//グループDB_管理番号
	private String task; 	//タスク名
	private	String contents;	//内容
	private java.sql.Date today;	//期限
	private String register;	//from
	private String to;	//to
	private boolean checkbox;	//チェックボックス
	private String manual_link;	//マニュアルリンク


	//constructor
	public Tasks() {
		//処理なし
	}
	public Tasks(String to) {
		this.to = to;
	}
	public Tasks(int id, int group_number, String task, String contens, Date today, String register, String to,
			boolean checkbox, String manual_link) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.contents = contens;
		this.today = today;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
		this.manual_link = manual_link;
	}

	//method
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
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contens) {
		this.contents = contens;
	}
	public java.sql.Date getToday() {
		return today;
	}
	public void setToday(java.sql.Date today) {
		this.today = today;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public String getManual_link() {
		return manual_link;
	}
	public void setManual_link(String manual_link) {
		this.manual_link = manual_link;
	}



}
