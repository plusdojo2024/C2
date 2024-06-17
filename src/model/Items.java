package model;

import java.io.Serializable;

public class Items implements Serializable {


	//field
	private int id; //管理番号
	private int manual_id; //マニュアルDB管理番号
	private String heading; //見出し
	private String contents; //内容
	private String image; //画像
	private java.sql.Date regist_day; //登録日
	private String esc;
	private String esc_g;

	//引数なしのconstructor

	public Items() {



	}

	//constructor
	//ManualRegistServletで使用
	public Items(int id, int manual_id, String heading, String contents, String image) {
		super();
		this.id = id;
		this.manual_id = manual_id;
		this.heading = heading;
		this.contents = contents;
		this.image = image;
	}
	public Items(int id, int manual_id, String heading, String contents, String image, java.sql.Date regist_day) {
		super();
		this.id = id;
		this.manual_id = manual_id;
		this.heading = heading;
		this.contents = contents;
		this.image = image;
		this.regist_day = regist_day;
	}
	public Items(int id, int manual_id, String heading, String contents, String image, java.sql.Date regist_day, String manual, String group) {
		super();
		this.id = id;
		this.manual_id = manual_id;
		this.heading = heading;
		this.contents = contents;
		this.image = image;
		this.regist_day = regist_day;
		this.esc = manual;
		this.esc_g = group;
	}

	//method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getManual_id() {
		return manual_id;
	}

	public void setManual_id(int manual_id) {
		this.manual_id = manual_id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public java.sql.Date getRegist_day() {
		return regist_day;
	}

	public void setRegist_day(java.sql.Date regist_day) {
		this.regist_day = regist_day;
	}
	public String getManual_Name() {
		return this.esc;
	}

	public String getGroup_number() {
		return this.esc_g;
	}

}

