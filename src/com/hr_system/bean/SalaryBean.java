package com.hr_system.bean;

public class SalaryBean {

	private int salid, uid, appid, salbasic, salhouse, salold, salhealth,
			salemp, salrefund, salperformance;
	private String saldate;

	public int getSalid() {
		return salid;
	}

	public void setSalid(int salid) {
		this.salid = salid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAppid() {
		return appid;
	}

	public void setAppid(int appid) {
		this.appid = appid;
	}

	public int getSalbasic() {
		return salbasic;
	}

	public void setSalbasic(int salbasic) {
		this.salbasic = salbasic;
	}

	public int getSalhouse() {
		return salhouse;
	}

	public void setSalhouse(int salhouse) {
		this.salhouse = salhouse;
	}

	public int getSalold() {
		return salold;
	}

	public void setSalold(int salold) {
		this.salold = salold;
	}

	public int getSalhealth() {
		return salhealth;
	}

	public void setSalhealth(int salhealth) {
		this.salhealth = salhealth;
	}

	public int getSalemp() {
		return salemp;
	}

	public void setSalemp(int salemp) {
		this.salemp = salemp;
	}

	public int getSalrefund() {
		return salrefund;
	}

	public void setSalrefund(int salrefund) {
		this.salrefund = salrefund;
	}

	public int getSalperformance() {
		return salperformance;
	}

	public void setSalperformance(int salperformance) {
		this.salperformance = salperformance;
	}

	public String getSaldate() {
		return saldate;
	}

	public void setSaldate(String saldate) {
		this.saldate = saldate;
	}

	public SalaryBean(int salid, int uid, int appid, int salbasic,
			int salhouse, int salold, int salhealth, int salemp, int salrefund,
			int salperformance, String saldate) {
		super();
		this.salid = salid;
		this.uid = uid;
		this.appid = appid;
		this.salbasic = salbasic;
		this.salhouse = salhouse;
		this.salold = salold;
		this.salhealth = salhealth;
		this.salemp = salemp;
		this.salrefund = salrefund;
		this.salperformance = salperformance;
		this.saldate = saldate;
	}

	public SalaryBean() {
		super();
	}

}
