package com.hr_system.bean;

public class TrainingPlanBean {
	private int trpid, depid, trpfee, trpmonth;
	private String trppeople, trpname, trpinfo, trpadmin, trpplace, trpdate,
			depname;

	public int getTrpid() {
		return trpid;
	}

	public void setTrpid(int trpid) {
		this.trpid = trpid;
	}

	public int getDepid() {
		return depid;
	}

	public void setDepid(int depid) {
		this.depid = depid;
	}

	public int getTrpfee() {
		return trpfee;
	}

	public void setTrpfee(int trpfee) {
		this.trpfee = trpfee;
	}

	public int getTrpmonth() {
		return trpmonth;
	}

	public void setTrpmonth(int trpmonth) {
		this.trpmonth = trpmonth;
	}

	public String getTrppeople() {
		return trppeople;
	}

	public void setTrppeople(String trppeople) {
		this.trppeople = trppeople;
	}

	public String getTrpname() {
		return trpname;
	}

	public void setTrpname(String trpname) {
		this.trpname = trpname;
	}

	public String getTrpinfo() {
		return trpinfo;
	}

	public void setTrpinfo(String trpinfo) {
		this.trpinfo = trpinfo;
	}

	public String getTrpadmin() {
		return trpadmin;
	}

	public void setTrpadmin(String trpadmin) {
		this.trpadmin = trpadmin;
	}

	public String getTrpplace() {
		return trpplace;
	}

	public void setTrpplace(String trpplace) {
		this.trpplace = trpplace;
	}

	public String getTrpdate() {
		return trpdate;
	}

	public void setTrpdate(String trpdate) {
		this.trpdate = trpdate;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public TrainingPlanBean(int trpid, int depid, String trppeople,
			String trpname, String trpinfo, String trpadmin, String trpplace,
			int trpfee, String trpdate, int trpmonth, String depname) {
		super();
		this.trpid = trpid;
		this.depid = depid;
		this.trppeople = trppeople;
		this.trpname = trpname;
		this.trpinfo = trpinfo;
		this.trpadmin = trpadmin;
		this.trpplace = trpplace;
		this.trpfee = trpfee;
		this.trpdate = trpdate;
		this.trpmonth = trpmonth;
		this.depname = depname;
	}

	public TrainingPlanBean() {
		super();
	}

}
