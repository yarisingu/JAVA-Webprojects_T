package com.tarun.strudentscurd1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tarun.strudentscurd1.dao.Studentdao;
import com.tarun.strudentscurd1.dto.StudentsDto;
import com.tarun.strudentscurd1.helper.ResponseStructure;

@Service
public class Studentservice {
	
	@Autowired
	Studentdao dao;
	
	public ResponseStructure<StudentsDto> save(StudentsDto studentsdto) {
		
		double percentage = (studentsdto.getMaths_marks()+studentsdto.getEnglish_marks()+studentsdto.getScience_marks())/3.0;
		studentsdto.setPercentage(percentage);
		if(percentage>85)
		{
			studentsdto.setResult("Distinction");
		}
		else {
			if(percentage>60)
			{
				studentsdto.setResult("FirstClass");
			}
			else {
				studentsdto.setResult("Fail");
			}
		}
		ResponseStructure<StudentsDto> structure = new ResponseStructure<StudentsDto>();
		structure.setMessage("Data saved Sucessfulluy");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.save(studentsdto));
		return structure;
	} 
	
	
	public ResponseStructure<List<StudentsDto>> saveAll(List<StudentsDto> studentsdtos)
	{
		for(StudentsDto studentsdto : studentsdtos) {
			double percentage = (studentsdto.getMaths_marks()+studentsdto.getEnglish_marks()+studentsdto.getScience_marks())/3.0;
			studentsdto.setPercentage(percentage);
			if(percentage>85)
			{
				studentsdto.setResult("Distinction");
			}
			else {
				if(percentage>60)
				{
					studentsdto.setResult("FirstClass");
				}
				else {
					studentsdto.setResult("Fail Try again");
				}
			}
		}
		ResponseStructure<List<StudentsDto>> structure = new ResponseStructure<>();
		structure.setMessage("Data saved Sucessfulluy");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.saveAll(studentsdtos));
		return structure;
			
	}


	public ResponseStructure<StudentsDto> fetchById(int id) {
		ResponseStructure<StudentsDto> structure = new ResponseStructure<StudentsDto>();
		StudentsDto dto = dao.fetchById(id);
		if(dto==null)
		{
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(dto);
		}
		else {
			structure.setMessage("Data  Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(dto);
		}
		return structure;
	}


	public ResponseStructure<List<StudentsDto>> fetchByMobile(long mob) {
		ResponseStructure<List<StudentsDto>> structure = new ResponseStructure<>();
		List<StudentsDto> list = dao.fetchByMobile(mob);
		if(list.isEmpty())
		{
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else {
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}


	public ResponseStructure<List<StudentsDto>> fetchByResult(String result) {
		ResponseStructure<List<StudentsDto>> structure = new ResponseStructure<>();
		List<StudentsDto> list = dao.fetchByResult(result);
		if(list.isEmpty())
		{
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else {
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}


	public ResponseStructure<List<StudentsDto>> fetch(String name, double percentage) {
		ResponseStructure<List<StudentsDto>> structure = new ResponseStructure<>();
		List<StudentsDto> list = dao.fetch(name, percentage);
		if(list.isEmpty())
		{
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else {
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}


	public ResponseStructure<List<StudentsDto>> fetchAl() {
		ResponseStructure<List<StudentsDto>> structure = new ResponseStructure<>();
		List<StudentsDto> list = dao.fetchAll();
		if(list.isEmpty())
		{
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
		}
		else {
			structure.setMessage("Data Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
		}
		return structure;
	}


	public ResponseStructure<StudentsDto> delete(int id) {
		ResponseStructure<StudentsDto> structure = new ResponseStructure<StudentsDto>();
		dao.deleteById(id);
		structure.setMessage("Data delete sucessfully");
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setData(null);
		return structure;
	}	
}
