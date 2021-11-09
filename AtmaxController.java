package com.atmax.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atmax.model.AtmaxEmployee;
import com.atmax.service.AtmaxService;

@Controller
public class AtmaxController {

	@Autowired
	AtmaxService service;

	@GetMapping("/details")
	public String getDetails() {
		return "details";
	}

	@GetMapping("/home")
	public String getHome()
	{
		return "home";
	}
	
	@GetMapping("/dml")
	public String doDml() {
		return "operations";
	}

	@RequestMapping("/save")
	public String saveEmp(@ModelAttribute("emp") AtmaxEmployee emp) {

		service.insert(emp);
		ModelAndView m = new ModelAndView();
		m.addObject("msg", "Employee inserted Successfully!!!");
		return "insert";
	}

	@RequestMapping("/update")
	public String updateEmp(@ModelAttribute("emp") AtmaxEmployee emp) {
		service.update(emp);
		ModelAndView m = new ModelAndView();
		m.addObject("msg", "Employee Updated Successfully!!!");
		return "update";
	}

	@RequestMapping("/delete")
	public String deleteEmp(HttpServletRequest req) {

		String email = req.getParameter("email");
		service.delete(email);
		ModelAndView m = new ModelAndView();
		m.addObject("msg", "Employee Deleted Successfully!!!");

		return "delete";
	}

	@RequestMapping("/all")
	public ModelAndView getAllEmps() {
		List<AtmaxEmployee> data = service.selectAll();
		return new ModelAndView("allRecords", "data", data);
	}

	@RequestMapping("/one")
	public ModelAndView getSingleRecord(HttpServletRequest req) {
		String email = req.getParameter("email");
		List<AtmaxEmployee> data = service.select(email);
		return new ModelAndView("allRecords", "data", data);
	}
}