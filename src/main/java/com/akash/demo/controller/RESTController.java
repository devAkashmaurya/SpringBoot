package com.akash.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.demo.model.Alien;
import com.akash.demo.repos.AlienRepo;

@RestController
public class RESTController {
  
@Autowired	
AlienRepo alienRepos;

@GetMapping("/aliens")
public Iterable<Alien> getAlien(){
	return alienRepos.findAll();
}

@GetMapping("/aliens/{aid}")
public Optional<Alien> getAlienById(@PathVariable("aid") int aid) {
	return alienRepos.findById(aid);
	
}

@PostMapping(path="/aliens", consumes = {"application/json"})
public Alien addAlien(Alien alien) {
	
	alienRepos.save(alien);
	return alien;
}

@PutMapping(path="/aliens", consumes = {"application/json"})
public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
	
	alienRepos.save(alien);
	return alien;
}

@DeleteMapping("/aliens/{aid}")
public String deleteAlien(@PathVariable("aid") int aid) {
	@SuppressWarnings("deprecation")
	Alien a = alienRepos.getOne(aid);
		alienRepos.delete(a);
		return "Deleted";
}
}
