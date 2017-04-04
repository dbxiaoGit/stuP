/**
 * @author dbxiao
 */
package com.db.bean;

public class Student {
	private String sno,sname,ssex,clno;

	public Student(String sno, String sname, String ssex, String clno) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.clno = clno;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSsex() {
		return ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public String getClno() {
		return clno;
	}

	public void setClno(String clno) {
		this.clno = clno;
	}
}
