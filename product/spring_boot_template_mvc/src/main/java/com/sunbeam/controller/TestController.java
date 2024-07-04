package com.sunbeam.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunbeam.services.ProductService;


@Controller
public class TestController {
	@Autowired
	private ProductService pdServ;
	public TestController()
	{
		System.out.println("inside ctr "+getClass());
	}
	
	@GetMapping("/")
	public String renderHomePage(Model map) {
		System.out.println("in product hm page");
		map.addAttribute("posts",pdServ.getAllPd() );
		return "/index";
	}
	
	
	
}
