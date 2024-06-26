package model;

import java.io.Serializable;
import java.sql.Date;

public class Tasks implements Serializable {

	//field
	private int id; //管理番号
	private int group_number;	//グループDB_管理番号
	private String task; 	//タスク名
	private	String contents;	//内容
	private java.sql.Date deadline;	//期限
	private String register;	//from
	private String to;	//to
	private boolean checkbox;	//チェックボックス
	private String manual_link;	//マニュアルリンク
	private int manual_id;


	public Tasks(int id, int group_number, String task, boolean checkbox) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.checkbox = checkbox;
	}
	//constructor
	public Tasks() {
		//処理なし
	}
	public Tasks(String to) {
		this.to = to;
	}
	public Tasks(int id) {
		super();
		this.id = id;
	}
	public Tasks(Date deadline) {
		super();
		this.deadline = deadline;
	}
	public Tasks(int id , boolean checkbox , String task) {
		super();
		this.id = id;
		this.checkbox = checkbox;
		this.task = task;
	}
	public Tasks(int id,boolean checkbox , String task, String to) {
		super();
		this.id = id;
		this.task = task;
		this.checkbox = checkbox;
		this.to = to;
	}
	public Tasks(int id , boolean checkbox, String task, String to, Date deadline) {
		super();
		this.id = id;
		this.task = task;
		this.deadline = deadline;
		this.to = to;
		this.checkbox = checkbox;
	}
	public Tasks( String task, String contents, Date deadline, String register, String to, boolean checkbox, int id) {
		super();
		this.id = id;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
	}
	public Tasks(int id, String task, String contents, Date deadline, String register, String to, boolean checkbox) {
		super();
		this.id = id;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
	}
	public Tasks(int id, String task, String contents, Date deadline, String register, String to, boolean checkbox,
			String manual_link) {
		super();
		this.id = id;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
		this.manual_link = manual_link;
	}
	public Tasks(int id, int group_number, String task, String contents, Date deadline, String register, String to,
			boolean checkbox, String manual_link) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
		this.manual_link = manual_link;
	}

	public Tasks(int id, String task, String contents, Date deadline, String register, String to, boolean checkbox,
			String manual_link, int manual_id) {
		super();
		this.id = id;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
		this.manual_link = manual_link;
		this.manual_id = manual_id;
	}
	public Tasks(String task, String contents, Date deadline, String register, String to, boolean checkbox,
			String manual_link, int manual_id,int id) {
		super();
		this.id = id;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
		this.manual_link = manual_link;
		this.manual_id = manual_id;
	}
	public Tasks(int id, int group_number, String task, String contents, Date deadline, String register, String to,
			boolean checkbox, String manual_link, int manual_id) {
		super();
		this.id = id;
		this.group_number = group_number;
		this.task = task;
		this.contents = contents;
		this.deadline = deadline;
		this.register = register;
		this.to = to;
		this.checkbox = checkbox;
		this.manual_link = manual_link;
		this.manual_id = manual_id;
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
	public java.sql.Date getDeadline() {
		return deadline;
	}
	public void setToday(java.sql.Date deadline) {
		this.deadline = deadline;
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
	public int getManual_id() {
		return manual_id;
	}
	public void setManual_id(int manual_id) {
		this.manual_id = manual_id;
	}
	public void setDeadline(java.sql.Date deadline) {
		this.deadline = deadline;
	}



}
