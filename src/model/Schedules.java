package model;

import java.io.Serializable;

public class Schedules implements Serializable {

	//field
	private int id;					//管理番号
	private int group_number;		//グループDB_管理番号
	private String task;			//予定名
	private String contents;		//内容
	private String register;		//from


	//constructor
	public Schedules() {
		//処理なし
	}

	public Schedules(int group_number, String task, String contents, String register) {
		super();
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.register = register;
	}

	public Schedules(int id, int group_number, String task, String contents, String register) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.register = register;
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

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}



}
