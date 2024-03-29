package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	
	private int eid;
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid")
	List<StudentExamBean> studentExamBean;//

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<StudentExamBean> getStudentExamBean() {
		return studentExamBean;
	}

	public void setStudentExamBean(List<StudentExamBean> studentExamBean) {
		this.studentExamBean = studentExamBean;
	}

}
