package com.studentSystem.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentSystem.entity.StudentEntity;
import com.studentSystem.service.StudentService;

@Controller
public class StudentController {
	
	
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<StudentEntity> stu =service.getAllStudent();
		model.addAttribute("stu",stu);
		return "index";
	}
	
	@GetMapping("/addstudent")
	public String addStudent() {
		return "addstudent.html";
	}
	
	@PostMapping("/register")
	public String StudentRegister(@ModelAttribute StudentEntity s,HttpSession session) {
		System.out.println(s);
		service.AddStudent(s);
		session.setAttribute("msg", "Student Added Sucessfully...Added");
		return "redirect:/";
	}
	
	@GetMapping("/editdata/{id}")
	public String editdata(@PathVariable int id,Model m)
	{
		StudentEntity s= service.getStudentId(id);
		m.addAttribute("student",s);
		return"editdata";
	}
	
	@PostMapping("/update")
	public String updateStu(@ModelAttribute StudentEntity s,HttpSession session)
	{
		session.setAttribute("msg","Stuadent Data Updated Sucessfully..");
		service.AddStudent(s);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStu(@PathVariable int id,HttpSession session)
	{
		service.deleteStu(id);
		session.setAttribute("msg","Stuadent Data Delete Sucessfully..");
		return "redirect:/";
	}
	
}
