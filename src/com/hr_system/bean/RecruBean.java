package com.hr_system.bean;

public class RecruBean {
	private int recid, depid, rankid, recquant;
	private String recname, recstartdate, recstopdate, recinfo;

	public int getRecid() {
		return recid;
	}

	public void setRecid(int recid) {
		this.recid = recid;
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

	public int getRecquant() {
		return recquant;
	}

	public void setRecquant(int recquant) {
		this.recquant = recquant;
	}

	public String getRecname() {
		return recname;
	}

	public void setRecname(String recname) {
		this.recname = recname;
	}

	public String getRecstartdate() {
		return recstartdate;
	}

	public void setRecstartdate(String recstartdate) {
		this.recstartdate = recstartdate;
	}

	public String getRecstopdate() {
		return recstopdate;
	}

	public void setRecstopdate(String recstopdate) {
		this.recstopdate = recstopdate;
	}

	public String getRecinfo() {
		return recinfo;
	}

	public void setRecinfo(String recinfo) {
		this.recinfo = recinfo;
	}

	public RecruBean(int recid, int depid, int rankid, String recname,
			int recquant, String recstartdate, String recstopdate,
			String recinfo) {
		super();
		this.recid = recid;
		this.depid = depid;
		this.rankid = rankid;
		this.recname = recname;
		this.recquant = recquant;
		this.recstartdate = recstartdate;
		this.recstopdate = recstopdate;
		this.recinfo = recinfo;
	}

	public RecruBean() {
		super();
	}

}
