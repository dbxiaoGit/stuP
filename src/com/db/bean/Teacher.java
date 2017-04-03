package com.db.bean;

public class Teacher {
	private String tno,tname,tdes;

	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTdes() {
		return tdes;
	}

	public void setTdes(String tdes) {
		this.tdes = tdes;
	}

	public Teacher(String tno, String tname, String tdes) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tdes = tdes;
	}
}
