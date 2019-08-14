package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class ExamBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  eid;
	private String title;
	private String date;
	private int totalmarks;
    private String duration;
    private String examcode;
    
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eid")
    List<QuestionBean>  questions;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "eid")
    List<StudentExamBean>  studentExamBean;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalmarks() {
		return totalmarks;
	}

	public void setTotalmarks(int totalmarks) {
		this.totalmarks = totalmarks;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getExamcode() {
		return examcode;
	}

	public void setExamcode(String examcode) {
		this.examcode = examcode;
	}

	public List<QuestionBean> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}

	public List<StudentExamBean> getStudentExamBean() {
		return studentExamBean;
	}

	public void setStudentExamBean(List<StudentExamBean> studentExamBean) {
		this.studentExamBean = studentExamBean;
	}

 
    
       
    
    
}

