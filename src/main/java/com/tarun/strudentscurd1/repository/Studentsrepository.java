package com.tarun.strudentscurd1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tarun.strudentscurd1.dto.StudentsDto;


public interface Studentsrepository  extends JpaRepository<StudentsDto, Integer>{
	
	List<StudentsDto> findByMobile(long mob);
	List<StudentsDto> findByResult(String result);
	@Query("select x from StudentsDto x where name=?1 and percentage>=?2")
	List<StudentsDto> findByNameandPercentageGreater(String name, double percentage);
}
