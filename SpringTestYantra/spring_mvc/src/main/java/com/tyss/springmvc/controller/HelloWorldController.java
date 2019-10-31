package com.tyss.springmvc.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.springmvc.dto.Employee;


@Controller//to make class as controller
@RequestMapping("/hello")//To give the path
public class HelloWorldController {
	
	@InitBinder//To use custom Editor
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor=new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class,editor);
	}
    
	@RequestMapping(path="/world",method=RequestMethod.GET)
	public String hello(ModelMap map) {
		map.addAttribute("msg","Hello Mahendra!!!!!");
		return "index";
	}
	
	//@RequestParam:To get the query sttring parameter
	@RequestMapping(path="/query",method=RequestMethod.GET)
	public String getInfo(@RequestParam("name")String name,ModelMap map) {
		map.addAttribute("name",name);
		return "info";
	}
	/**
	 * There are four ways to pass data to the Server from browser
	 * 
	 * Cookie
	 * Query Parameter
	 * Form
	 * PathParam
	 *
	 */
	
	@RequestMapping(path="/form-page",method=RequestMethod.GET)
	public String getForm() {
		return "form";
	}
	@RequestMapping(path="/form",method=RequestMethod.POST)
	public String formData(Employee emp,ModelMap map) {
		map.addAttribute("id",emp.getId());
		map.addAttribute("name",emp.getName());
		map.addAttribute("dob",emp.getDate());
		map.addAttribute("email",emp.getEmail());
		map.addAttribute("password",emp.getPassword());
		return "info";
	}
	
	@RequestMapping(path ="/add-cookie",method=RequestMethod.GET)
	public String addCookie(HttpServletResponse response,ModelMap map) {
		Cookie cookie=new Cookie("name","Suddep");
		response.addCookie(cookie);
		map.addAttribute("msg","Cookie added to the browser");
		return "cookie";
	}
	
	//@CookieValue:to get the value from cookie
	@RequestMapping(path="get-cookie",method=RequestMethod.GET)
	public String getCookie(@CookieValue(name ="name",required=false) String name,ModelMap map) {
		if(name==null) {
			map.addAttribute("msg","Cookie Not Found");
		}else {
			map.addAttribute("msg","Cookie value="+name);
		}
		return "cookie";
	}
	
	//@PathVariable:to get the path value
	//  http://localhost:8080/spring_mvc/hello/path/123/querty -->PathParam url.
	@RequestMapping(path="/path/{id}/{name}",method=RequestMethod.GET)
	public String getPathValues(@PathVariable("id") int id,@PathVariable("name") String name,ModelMap map) {
		map.addAttribute("id",id);
		map.addAttribute("name",name);
		return "info";
	}
	@RequestMapping(path="/set-attribute",method=RequestMethod.GET)
	public String setSession(HttpSession session,ModelMap map) {
		Employee emp=new Employee();
		emp.setId(1);
		emp.setName("Pravin Kumar");
		emp.setEmail("pravin@gmail.com");
		emp.setPassword("hjhjh");
		session.setAttribute("emp",emp);
		map.addAttribute("msg","Session attribute added.");
		return "index";
	}
	
	//@SessionAttribute:To get the session value.
	@RequestMapping(path="/get-attribute",method=RequestMethod.GET)
	public String getAttribute(@SessionAttribute(name="emp",required=false) Employee emp ,ModelMap map) {
		
		if(emp==null) {
			map.addAttribute("msg","No Attribute Present");
		}else {
			System.out.println(emp.getId());
			System.out.println(emp.getName());
			map.addAttribute("msg","Got the Attribute");
		}
		return "index";
	}
	
	//forward:To forward the request
	@RequestMapping(path="/forward",method=RequestMethod.GET)
	public String forward() {
		return "forward:add-cookie";
	}
	//redirect:To redirect the request.
	@RequestMapping(path="/redirect",method=RequestMethod.GET)
	public String redirect() {
		return "redirect:http://www.google.com";
	}
	
}
