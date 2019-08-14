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

import com.sun.istack.NotNull;

@Entity
@Table(name = "student")
public class StudentBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int sid;
	@NotNull
	private String Name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "sid")
	 List<StudentExamBean> studentExamBean;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<StudentExamBean> getStudentExamBean() {
		return studentExamBean;
	}

	public void setStudentExamBean(List<StudentExamBean> studentExamBean) {
		this.studentExamBean = studentExamBean;
	}

	 
	
	
	
	
}
