package com.hr_system.bean;

public class ContractBean {
	private int conid, conyear, uid;
	private String conname, contype, coninfo;
	private String condate;// 数据库读取后直接转成yyyy-MM-dd格式
	private String uname, depname;

	public int getConid() {
		return conid;
	}

	public void setConid(int conid) {
		this.conid = conid;
	}

	public int getConyear() {
		return conyear;
	}

	public void setConyear(int conyear) {
		this.conyear = conyear;
	}

	public String getConname() {
		return conname;
	}

	public void setConname(String conname) {
		this.conname = conname;
	}

	public String getContype() {
		return contype;
	}

	public void setContype(String contype) {
		this.contype = contype;
	}

	public String getConinfo() {
		return coninfo;
	}

	public void setConinfo(String coninfo) {
		this.coninfo = coninfo;
	}

	public String getCondate() {
		return condate;
	}

	public void setCondate(String condate) {
		this.condate = condate;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public ContractBean(int conid, String uname, String depname,
			String conname, String condate, int conyear, String contype,
			String coninfo, int uid) {
		super();
		this.conid = conid;
		this.uname = uname;
		this.depname = depname;
		this.conname = conname;
		this.condate = condate;
		this.conyear = conyear;
		this.contype = contype;
		this.coninfo = coninfo;
		this.uid = uid;
	}

	public ContractBean() {
		super();
	}

}
