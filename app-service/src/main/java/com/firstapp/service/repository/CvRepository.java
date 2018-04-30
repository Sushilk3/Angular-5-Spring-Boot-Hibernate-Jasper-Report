package com.firstapp.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.firstapp.service.entity.*;

public interface CvRepository extends CrudRepository<Cv, Long> {
	
//	LIST ALL
	List<Cv>findAll();
	
	@Query("SELECT c FROM Cv c ORDER BY c.urbanVillage")
	public List<Cv> findAlls();
	
	@Query("SELECT c FROM Cv c")
	public List<Cv>findAllsList();
	
	@Query("SELECT c FROM Cv c ORDER BY c.urbanVillage")
	List<Cv>findList();
	
//	PARAM cvID
	@Query("SELECT c FROM Cv c WHERE c.cvId = :cvId")
	List<Cv>findByCvId(@Param("cvId") Integer cvId);
	
//	PARAM cvAGE
	@Query("SELECT c FROM Cv c WHERE c.age = :age")
	List<Cv>findByAge(@Param("age") Integer age);
	
	@Query("SELECT c FROM Cv c WHERE c.age = :age")
	List<Cv> findByAges(@Param("age") Integer age);
	
}
