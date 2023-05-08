package com.student.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.main.model.Model;
import com.student.main.repository.Studentrepo;
import com.student.main.service.Service;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class Controller {
	@Autowired
	private Service service;
	@Autowired
	private Studentrepo repository;
	
	@PostMapping("/addstudent")
	public Model add(@RequestBody Model model)
	{ service.add(model);
	return model;
	}
	
	@GetMapping("/remove")
	public List<Model> remove( )
	{List<Model> model=service.get();
	return model;
	}
	
	@GetMapping("/remove/{id}")
	public List<Model> removeid(@PathVariable  Long id)
	{return repository.getid(id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public Object  delete(@PathVariable("id")  Long id)
	{return service.delete(id);}
	
	
	@PutMapping("/updatestudent/{id}")
	public String Updateitems(@RequestBody Model data,@PathVariable Long id)
	 {
	 return service.updatestudent(data,id);
	 }

}
