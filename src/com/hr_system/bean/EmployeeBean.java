package com.hr_system.bean;

public class EmployeeBean {
	private int uid, depid, rankid, perid;
	private String uname, upassword, ugender, utelphone;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}

	public int getRankid() {
		return rankid;
	}

	public void setRankid(int rankid) {
		this.rankid = rankid;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUgender() {
		return ugender;
	}

	public void setUgender(String ugender) {
		this.ugender = ugender;
	}

	public String getUtelphone() {
		return utelphone;
	}

	public void setUtelphone(String utelphone) {
		this.utelphone = utelphone;
	}

	public EmployeeBean(int uid, int depid, int rankid, int perid, String uname,
			String upassword, String ugender, String utelphone) {
		super();
		this.uid = uid;
		this.depid = depid;
		this.rankid = rankid;
		this.perid = perid;
		this.uname = uname;
		this.upassword = upassword;
		this.ugender = ugender;
		this.utelphone = utelphone;
	}

	public EmployeeBean() {
		super();
	}

}
