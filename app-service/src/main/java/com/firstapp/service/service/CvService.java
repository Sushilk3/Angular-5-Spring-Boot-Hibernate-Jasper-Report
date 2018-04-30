package com.firstapp.service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.firstapp.service.domain.CurrVitae;
import com.firstapp.service.domain.CurrVitaeRequest;
import com.firstapp.service.entity.Cv;
import com.firstapp.service.repository.CvRepository;


@Service
public class CvService {

	@Autowired
	CvRepository cvRepository;
	
//	GET LIST ALL
	public List<Cv>listAll(){
		return (List<Cv>)cvRepository.findAll();
	}
	
	public List<Cv>listAlls(){
		return (List<Cv>)cvRepository.findList();
	}
		
	
//	GET PARAM cvId
	public List<Cv>findByCvId (Integer cvId) {
		return cvRepository.findByCvId(cvId);
	}
	
//	GET PARAM age
	public List<Cv>findByAge (Integer age) {
		return cvRepository.findByAge(age);
	}
	
	
//	POST LIST
	public Cv sendCV(Cv cv) {
		return cvRepository.save(cv);		
	}
	
	public List<Cv> findAlls(){
	return cvRepository.findAlls();
	}
	
	
	public List<Cv> findByAges(Integer age){
		return cvRepository.findByAges(age);
	}
}
