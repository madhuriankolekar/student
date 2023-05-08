package com.student.main.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;


import com.student.main.model.Model;
import com.student.main.repository.Studentrepo;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Studentrepo repository;
	public Model add(Model model)
	{return repository.save(model);
	}
	
    public List<Model> get()
    {
	return repository.findAll();
     }
    public Model getid(Long id)
    {
	return  repository.getById(id);
    }
    @Transactional
   public Object delete(Long Id) {
    repository.deleteById(Id);
    return Id;}
    
    
public String updatestudent(Model data,Long id) {
	List<Model> findByUserid = this.repository.getid(id);
	for (Model data1 : findByUserid) {
		data1.setAddress(data.getAddress());
		data1.setLname(data.getLname());
		data1.setRollno(data.getRollno());
		data1.setSname(data.getSname());
		this.repository.save(data1);
	}
	return "successfully updated";
	
}
}
		
