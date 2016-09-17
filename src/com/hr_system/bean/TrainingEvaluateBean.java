package com.hr_system.bean;

public class TrainingEvaluateBean {// Óëfeedback¹«ÓÃ
	private int treid, uid, trpid;
	private String tretext;

	public int getTreid() {
		return treid;
	}

	public void setTreid(int treid) {
		this.treid = treid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getTrpid() {
		return trpid;
	}

	public void setTrpid(int trpid) {
		this.trpid = trpid;
	}

	public String getTretext() {
		return tretext;
	}

	public void setTretext(String tretext) {
		this.tretext = tretext;
	}

	public TrainingEvaluateBean(int treid, int uid, int trpid, String tretext) {
		super();
		this.treid = treid;
		this.uid = uid;
		this.trpid = trpid;
		this.tretext = tretext;
	}

	public TrainingEvaluateBean() {
		super();
	}

}
