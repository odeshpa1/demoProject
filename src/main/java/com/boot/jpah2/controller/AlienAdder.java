package com.boot.jpah2.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.PostRemove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boot.jpah2.Model.Alien;
import com.boot.jpah2.dao.AlienRepo;

@RestController

public class AlienAdder {
	
    @Autowired
	AlienRepo alienRepository;
	@RequestMapping("/")
	  public String getHome()
	  {
		  
		  return "home.jsp";
	  }
	  @RequestMapping("/addAlien")
	  public String addAlien(Alien alien)
	  {
		  alienRepository.save(alien);
		  return "home";
	  }

	  @PostMapping(path="/alien")
	  public Alien insertAlien(@RequestBody Alien alien)
	  {
		  alienRepository.save(alien);
		  return alien;
	  }
	  
	  
	  
	  @RequestMapping(path="/aliens",produces="application/json")
	  @ResponseBody
	  public List<Alien> getAlien()
	  {
		 return alienRepository.findAll();
		  
	  }
	  
	  @GetMapping("/alien/{Alienid}")
	  public Optional<Alien> getAlienById(@PathVariable("Alienid") int aid)
	  {
		 return alienRepository.findById(aid);
		  
	  }
	  
	  @RequestMapping("/deleteAlien")
	  public ModelAndView deleteAlien(@RequestParam(name="alienId") int alienId)
	  {
		  ModelAndView mv= new ModelAndView("deletenotification");
		  Alien alien=alienRepository.findById(alienId).orElse(new Alien());
		  alienRepository.deleteById(alienId);
		  mv.addObject("alien", alien);
		  return mv;
		  
	  }
	  
	  @DeleteMapping("/alien/{alienid}")
	  public void removeAlien(@PathVariable("alienid") int alienId)
	  {
		 
		 // Alien alien=alienRepository.findById(alienId).orElse(new Alien());
		  alienRepository.deleteById(alienId);		 
		  
	  }
	  //@RequestMapping("/searchAlien")
	 // public ModelAndView 
	  @PutMapping("/alien")
	  public void updateAlien(Alien alien)
	  {
		 
		 // Alien alien=alienRepository.findById(alienId).orElse(new Alien());
		 
		  alienRepository.save(alien);
		 
			 
		  
	  }
}
