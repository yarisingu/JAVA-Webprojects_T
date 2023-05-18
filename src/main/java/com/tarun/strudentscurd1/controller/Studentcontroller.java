package com.tarun.strudentscurd1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.strudentscurd1.dto.StudentsDto;
import com.tarun.strudentscurd1.helper.ResponseStructure;
import com.tarun.strudentscurd1.service.Studentservice;

@RestController
//@Controller
public class Studentcontroller {

	@Autowired
	Studentservice studentservice;
		@PostMapping("students")
//	@ResponseBody
	public ResponseStructure<StudentsDto> save(@RequestBody StudentsDto studentsdto)
	{
		return studentservice.save(studentsdto);
	}
	
	@PostMapping("students/multiple")
	public ResponseStructure<List<StudentsDto>>saveAll(@RequestBody List<StudentsDto> studentsdto)
	{
		return studentservice.saveAll(studentsdto);
	}
	
	@GetMapping("students")
	public ResponseStructure<StudentsDto> fetchById(@RequestParam int id)
	{
		return studentservice.fetchById(id);
	}
	
	@GetMapping("students/{id}")
	public ResponseStructure<StudentsDto> fetchById2(@PathVariable int id)
	{
		return studentservice.fetchById(id);
	}
	@GetMapping("students/mobile/{mob}")
	public ResponseStructure<List<StudentsDto>> fetchByMobile(@PathVariable long mob)
	{
		return studentservice.fetchByMobile(mob);
	}
	@GetMapping("students/result/{result}")
	public ResponseStructure<List<StudentsDto>> fetchByResult(@PathVariable String result)
	{
		return studentservice.fetchByResult(result);
	}
	@GetMapping("students/{name}/{percentage}")
	public ResponseStructure<List<StudentsDto>> fetch(@PathVariable String name , @PathVariable double percentage)
	{
		return studentservice.fetch(name,percentage);
	}
	@GetMapping("students/multiple")
	public ResponseStructure<List<StudentsDto>> fetchAl()
	{
		return studentservice.fetchAl();
	}
	
	@DeleteMapping("students/{id}")
	public ResponseStructure<StudentsDto> delete(@PathVariable int id)
	{
		return studentservice.delete(id);
	}
	
	
	
}
