package com.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.ExamBean;
import com.bean.ListStudentExamBean;
import com.bean.QuestionBean;
import com.bean.StudentBean;
import com.bean.StudentExamBean;
import com.dao.StudentDao;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao dao;
	
	int loopsize = 0;
	
	@RequestMapping(value = "/signup" ,method = RequestMethod.GET)
	public String signup(StudentBean bean,Model model)
	{
		model.addAttribute("bean",bean);
		return "signup";
	}
	
	@RequestMapping(value = "/signupdata" ,method = RequestMethod.POST)
	public String signupdata(@ModelAttribute @Validated StudentBean bean,BindingResult result,Model model)
	{
		dao.insert(bean);
		return "login";
	}
	
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value = "/logindata" ,method = RequestMethod.POST)
	public String logindata(StudentBean bean,Model model,HttpServletRequest request)
	{
		List<StudentBean> list  = dao.logincheck(bean);
		Iterator<StudentBean> itr = list.iterator();
		while(itr.hasNext())
		{
			StudentBean s = itr.next();
			if(s.getEmail().equals(bean.getEmail()) && s.getPassword().equals(bean.getPassword()))
			{
				request.getSession().setAttribute("sid", s.getSid());
				model.addAttribute("bean",s);
				return "home";
			}
			else
			{
				
			}
			
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/examcodecheck" ,method = RequestMethod.POST)
	public String codeCheck(ExamBean bean,Model model,HttpServletRequest request)
	{
//		System.out.println("sid  : "+request.getSession().getAttribute("sid"));
		List<ExamBean> list  = dao.codecheck(bean);
		if(!list.isEmpty())
		{
		ListStudentExamBean lseb = new ListStudentExamBean();
		ArrayList<StudentExamBean> ls = new ArrayList<StudentExamBean>();
		StudentBean studentBean = new StudentBean();
		studentBean.setSid(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		for (QuestionBean qb : list.get(0).getQuestions()) {
			StudentExamBean studentExamBean = new StudentExamBean();
			studentExamBean.setEid(qb.getEid());
			studentExamBean.setQid(qb.getQid());
			studentExamBean.setSid(studentBean.getSid());
			ls.add(studentExamBean);
		}
		
				
				lseb.setListstudents(ls);
				model.addAttribute("exam",lseb);
				lseb.getListstudents()
				return "questiondetails2";
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/result" ,method = RequestMethod.POST)
	public String result(HttpServletRequest request,StudentExamBean bean)
	{
		
		int marks = 0;
		System.out.println("loopsize = "+loopsize);
		String option[] = new String[loopsize];
		for (int i = 0; i < option.length; i++) {
			int j = i+1;
			option[i]=(String) request.getParameter("option"+j);
			System.out.println("ans[] "+option[i]);
		}
		
		int qidloop[] = new int[loopsize];
		for (int i = 0; i < qidloop.length; i++) {
			int j = i+1;
			qidloop[i]=Integer.parseInt(request.getParameter("qid"+j));
			System.out.println("que[] "+qidloop[i]);
		}
		
		String answer[] = new String[loopsize];
		
		
		int eid = bean.getEid();
		List<QuestionBean> list  = dao.listQuestioncheck(eid);
			
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getAnswer().equals(option[i]))
			{
				answer[i]="true";
				marks++;
				
			}
			else
			{
				answer[i]="false";
			}
		}
		
		
		String status = "";
		if(marks>=(list.size()/2))
		{
			System.out.println("pass");
			status = "pass";
		}
		else
		{
			System.out.println("fail");
			status = "fail";
		}
		
		
		
		
		int sid = Integer.parseInt(request.getSession().getAttribute("sid").toString()); 
		
		for (int i = 0; i < option.length; i++) {
			
			
			bean.setAnswer(answer[i]);
			bean.setQid(qidloop[i]);
			bean.setSid(sid);
			bean.setStatus(status);
			System.out.println("bean.getAnswer() "+bean.getAnswer());
			System.out.println("bean.getEid() "+bean.getEid());
			System.out.println("bean.getQid() "+bean.getQid());
			System.out.println("bean.getSeid() "+bean.getSeid());
			System.out.println("bean.getSid() "+bean.getSid());
			System.out.println("bean.getStatus() "+bean.getStatus());
			
			dao.insertexam(bean);
			
			
//			System.out.println("marks"+marks+"question id="+qidloop[i]+"exam id="+eid+"studentid="+sid);
		
		}
		
		return "result";
	}
	

}
