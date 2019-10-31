package com.tyss.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.springmvc.dto.Employee;
import com.tyss.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	// @RequestMapping(path="/login",method=RequestMethod.GET)
	@GetMapping("/login")
	public String loginPage(HttpServletRequest request) {
		//if(request.getSession(false)==null) {
			return "login";
		/*}
		return "home";*/
	}

	@GetMapping("/resgister")
	public String registerPage(HttpServletRequest request) {
		return "register";
	}

	@PostMapping("/login")
	public String login(String email, String password, ModelMap map, HttpServletRequest requset) {
		Employee employee = service.auth(email, password);
		if (employee == null) {
			map.addAttribute("msg", "Invalid Credential");
			return "login";
		}
		requset.getSession().setAttribute("emp", employee);
		return "home";
	}

	@PostMapping("/resgister")
	public String register(Employee employee, ModelMap map) {
		if (service.registerEmployee(employee)) {
			map.addAttribute("msg", "Registered Employee Successfully");
		} else {
			map.addAttribute("msg", "Invalid Data");
		}
		return "login";
	}

	@GetMapping("/home")
	public String homePage(HttpServletRequest request) {
		if (request.getSession(false) == null) {
			return "login";
		}
		return "home";
	}

	@GetMapping("/update")
	public String updatePage(HttpServletRequest request) {
		if (request.getSession(false) == null) {
			return "login";
		}
		return "update";
	}

	@PostMapping("/update")
	public String update(Employee employee, @SessionAttribute("emp") Employee emp, ModelMap map, HttpSession session) {
		employee.setEmail(emp.getEmail());
		if (service.updateEmployee(employee)) {
			map.addAttribute("msg", "Profile updated");
			session.setAttribute("emp", employee);
		} else {
			map.addAttribute("msg", "Invalid Data");
		}
		return "home";
	}

	@GetMapping("/show-all")
	public String showAll(ModelMap map) {
		List<Employee> employees = service.getAllEmployee();
		map.addAttribute("list", employees);
		return "show-all";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id, ModelMap map, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			service.deleteEmployee(id);
			map.addAttribute("msg", "Profile Deleted");
			session.invalidate();
		}
		return "redirect:./login";
	}

	@GetMapping("/logout")
	public String logout(ModelMap map, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		map.addAttribute("msg", "Logout Successfully");
		return "login";
	}
}
