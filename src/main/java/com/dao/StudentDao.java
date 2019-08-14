package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.StudentBean;
import com.bean.StudentExamBean;

public class StudentDao {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	JdbcTemplate stmt;
	
	static Session session = null;
	
	public void insert(StudentBean bean)
	{
		session = factory.openSession();
		session.save(bean);
		session.close();
	}

	public List<StudentBean> logincheck(StudentBean bean) {
		session = factory.openSession();
		List<StudentBean> list = session.createQuery("from StudentBean").list();
		session.close();
		return list;
	}

	public ExamBean codecheck(ExamBean bean) {
		
		session = factory.openSession();
		ExamBean examBean =(ExamBean) session.createQuery("from ExamBean where title='"+bean.getTitle()+"'");
		session.close();
		return examBean;
	}

	public List<QuestionBean> questionpaper(ExamBean e) {
		session = factory.openSession();
		List<QuestionBean> list = session.createQuery("from ExamBean where eid='"+e.getEid()+"'").list();
		return list;
	}

	public List<QuestionBean> listQuestioncheck(int id) {
		session = factory.openSession();
		List<QuestionBean> list = session.createQuery("from QuestionBean where eid='"+id+"'").list();
		return list;
	}

	public void insertexam(StudentExamBean bean) {
		session = factory.openSession();
		session.save(bean);
		session.close();
		System.out.println("success in insert");
	}

	
//	"insert into spring (firstname,lastname,username,password,gender,city) values (?,?,?,?,?,?)",
//	signupbean.getFirstname(), signupbean.getLastname(), signupbean.getUsername(), signupbean.getPassword(),
//	signupbean.getGender(), signupbean.getCity());
}
