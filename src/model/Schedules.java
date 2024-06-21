package model;

import java.io.Serializable;
import java.sql.Date;

public class Schedules implements Serializable {

	//field
	private int id;					//管理番号
	public Schedules( String task, String contents, String register, Date deadline,int id) {
		super();
		this.id = id;
		this.task = task;
		this.contents = contents;
		this.register = register;
		this.deadline = deadline;
	}

	private int group_number;		//グループDB_管理番号
	private String task;			//予定名
	private String contents;		//内容
	private String register;		//from
	private java.sql.Date deadline;


	//constructor
	public Schedules() {
		//処理なし
	}

	public Schedules(String task) {
		super();
		this.task = task;
	}

	public Schedules(int id, String task) {
		super();
		this.id = id;
		this.task = task;
	}

	public Schedules(String task, String contents, String register) {
		super();
		this.task = task;
		this.contents = contents;
		this.register = register;
	}

	public Schedules(int group_number, String task, String contents, String register) {
		super();
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.register = register;
	}

	public Schedules(String task, String contents, String register, Date deadline) {
		super();
		this.task = task;
		this.contents = contents;
		this.register = register;
		this.deadline = deadline;
	}

	public Schedules(int id, int group_number, String task, String contents, String register) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.register = register;
	}


	public Schedules(int group_number, String task, String contents, String register, Date deadline) {
		super();
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.register = register;
		this.deadline = deadline;
	}

	public Schedules(int id, int group_number, String task, String contents, String register, Date deadline) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.register = register;
		this.deadline = deadline;
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

	public java.sql.Date getDeadline() {
		return deadline;
	}

	public void setDeadline(java.sql.Date deadline) {
		this.deadline = deadline;
	}



}
