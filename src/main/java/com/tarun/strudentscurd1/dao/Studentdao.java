package com.tarun.strudentscurd1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tarun.strudentscurd1.dto.StudentsDto;
import com.tarun.strudentscurd1.repository.Studentsrepository;

@Repository
public class Studentdao {
	
	@Autowired
	Studentsrepository repository;
	
	public StudentsDto save(StudentsDto student) {
		return repository.save(student);
	}
	public List<StudentsDto> saveAll(List<StudentsDto> studentsdtos){
		return repository.saveAll(studentsdtos);
	}
	public StudentsDto fetchById(int id){
		Optional<StudentsDto> op = repository.findById(id);
		if(op.isEmpty())
		{
			return null;
		}
		else {
			return op.get();
		}
	}
	public List<StudentsDto> fetchByMobile(long mob){
		return repository.findByMobile(mob);
	}
	
	public List<StudentsDto> fetchByResult(String result){
		return repository.findByResult(result);
	}
	public List<StudentsDto> fetch(String name , double percentage){
		return repository.findByNameandPercentageGreater(name,percentage);
	}
	public List<StudentsDto> fetchAll(){
		return repository.findAll();
	}
	public void deleteById(int id){
		 repository.deleteById(id);
	}
}
