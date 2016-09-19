package com.hr_system.bean;

public class InfoBean {

	private int infoid, uid;
	private String infotitle, infocontent, infodate;

	public int getInfoid() {
		return infoid;
	}

	public void setInfoid(int infoid) {
		this.infoid = infoid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getInfotitle() {
		return infotitle;
	}

	public void setInfotitle(String infotitle) {
		this.infotitle = infotitle;
	}

	public String getInfocontent() {
		return infocontent;
	}

	public void setInfocontent(String infocontent) {
		this.infocontent = infocontent;
	}

	public String getInfodate() {
		return infodate;
	}

	public void setInfodate(String infodate) {
		this.infodate = infodate;
	}

	public InfoBean(int infoid, int uid, String infotitle, String infocontent,
			String infodate) {
		super();
		this.infoid = infoid;
		this.uid = uid;
		this.infotitle = infotitle;
		this.infocontent = infocontent;
		this.infodate = infodate;
	}

	public InfoBean() {
		super();
	}

}
