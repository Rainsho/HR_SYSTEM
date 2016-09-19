package com.hr_system.bean;

public class CandiBean {
	private int canid, recid;
	private String canname, cantelphone, caninfo;

	public int getCanid() {
		return canid;
	}

	public void setCanid(int canid) {
		this.canid = canid;
	}

	public int getRecid() {
		return recid;
	}

	public void setRecid(int recid) {
		this.recid = recid;
	}

	public String getCanname() {
		return canname;
	}

	public void setCanname(String canname) {
		this.canname = canname;
	}

	public String getCantelphone() {
		return cantelphone;
	}

	public void setCantelphone(String cantelphone) {
		this.cantelphone = cantelphone;
	}

	public String getCaninfo() {
		return caninfo;
	}

	public void setCaninfo(String caninfo) {
		this.caninfo = caninfo;
	}

	public CandiBean(int canid, int recid, String canname, String cantelphone,
			String caninfo) {
		super();
		this.canid = canid;
		this.recid = recid;
		this.canname = canname;
		this.cantelphone = cantelphone;
		this.caninfo = caninfo;
	}

	public CandiBean() {
		super();
	}

}
