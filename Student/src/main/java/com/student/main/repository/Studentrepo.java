package com.student.main.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.main.model.Model;

@Repository
public interface Studentrepo extends  JpaRepository<Model,Long>{
	@Query(value = "select * from model where id =:id", nativeQuery = true)
    List<Model> getid(Long id);
	

}
