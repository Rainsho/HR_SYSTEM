package com.hr_system.bean;

public class TrainingApplyBean {
	private int traid, uid, trpid, appid;

	public int getTraid() {
		return traid;
	}

	public void setTraid(int traid) {
		this.traid = traid;
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

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public TrainingApplyBean(int traid, int uid, int trpid, int appid) {
		super();
		this.traid = traid;
		this.uid = uid;
		this.trpid = trpid;
		this.appid = appid;
	}

	public TrainingApplyBean() {
		super();
	}

}
