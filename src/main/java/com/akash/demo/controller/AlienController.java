package com.akash.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.akash.demo.model.Alien;
import com.akash.demo.repos.AlienRepo;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		alienRepo.save(alien);
		return "home.jsp";
		
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = alienRepo.findById(aid).orElse(new Alien());
		
//		System.out.println(alienRepo.findByAname("java"));
//		System.out.println(alienRepo.findByAidGreaterThan(3));
//		System.out.println(alienRepo.findByAname("java"));
		
		mv.addObject(alien);
		return mv;
		
	}
	

}
