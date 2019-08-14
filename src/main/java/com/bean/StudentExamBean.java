package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studentexam")
public class StudentExamBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seid;
	
	private String answer;
	
	private String status;
	
	private int sid;
	
	private int qid;
	
	private int eid;
	
	
	public int getSeid() {
		return seid;
	}

	public void setSeid(int seid) {
		this.seid = seid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

		
	

}
