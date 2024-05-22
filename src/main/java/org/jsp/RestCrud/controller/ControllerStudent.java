package org.jsp.RestCrud.controller;

import org.jsp.RestCrud.dto.Student;
import org.jsp.RestCrud.helper.ResponceStructure;
import org.jsp.RestCrud.service.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ControllerStudent {

	@Autowired
	ServiceStudent service;

//	save one record
	@Operation(summary = "Save one record", description = "This end path is used to save one student's record")
	@PostMapping("/student")
	public ResponseEntity<ResponceStructure> saveDetails(@RequestBody Student student) {
		return new ResponseEntity<ResponceStructure>(service.saveStudent(student), HttpStatus.FOUND);
	}

//  save multiple record
	@Operation(summary = "Save all students", description = "This end path is used to save all student's record")
	@PostMapping("/students")
	public ResponseEntity<ResponceStructure> saveAll(@RequestBody Student student) {
		return new ResponseEntity<ResponceStructure>(service.saveAll(student), HttpStatus.FOUND);
	}

//	fetch record By Id
	@Operation(summary = "Fetch one record", description = "This end path is used to fetch one students record")
	@GetMapping("/student/{id}")
	public ResponseEntity<ResponceStructure> fetchStudentById(@PathVariable int id) {
		return new ResponseEntity<ResponceStructure>(service.fetchStudentById(id), HttpStatus.FOUND);
	}

//	fetch Student By Name
	@GetMapping("/student/name/{name}")
	public ResponseEntity<ResponceStructure> fetchByName(@PathVariable String name) {
		return new ResponseEntity<ResponceStructure>(service.fetchByName(name), HttpStatus.FOUND);
	}

//	fetch By Mobile
	@Operation(summary = "Fetch by mobile", description = "This end path is used to fetch by mobile")
	@GetMapping("/student/mobile/{mobile}")
	public ResponseEntity<ResponceStructure> fetchByMobile(@PathVariable long mobile) {
		return new ResponseEntity<ResponceStructure>(service.fetchByMobile(mobile), HttpStatus.FOUND);
	}

//fetch By Result
	@Operation(summary = "Fetch by Result", description = "This end path is used to fetch by Result")
	@GetMapping("/student/result/{result}")
	public ResponseEntity<ResponceStructure> fetchByResult(@PathVariable String result) {
		return new ResponseEntity<ResponceStructure>(service.fetchByResult(result), HttpStatus.FOUND);
	}

//	fetchByStuMathScience
	@Operation(summary = "Fetch student Record Subject and marks Greater Than")
	@GetMapping("/student/{subject}/greater/{marks}")
	public ResponseEntity<ResponceStructure> fetchByStuMathScience(@PathVariable String subject,
			@PathVariable int marks) {
		return new ResponseEntity<ResponceStructure>(service.fetchBySubjectMarksGreater(subject, marks),
				HttpStatus.FOUND);
	}

//	fetchByStuMathScience
	@Operation(summary = "Fetch student Record Subject and marks Greater Than")
	@GetMapping("/student/{subject}/between/{marks1}/{marks2}")
	public ResponseEntity<ResponceStructure> fetchStuMarksBetween(@PathVariable String subject, @PathVariable int marks1, @PathVariable int marks2) {
		return new ResponseEntity<ResponceStructure>(service.fetchStuMarksBetween(subject, marks1, marks2), HttpStatus.FOUND);
	}

//	fetch all record
	@Operation(summary = "Fetch all Students", description = "This end path is used to Fetch all Students")
	@GetMapping("/students/all")
	public ResponseEntity<ResponceStructure> fetchAll() {
		return new ResponseEntity<ResponceStructure>(service.fetchAll(), HttpStatus.FOUND);
	}

//
////	update
//	@PostMapping("/change")
//	public ResponceStructure update(Student student) {
//		return service.update(student);
//	}
//
////	updateByName
//	@PostMapping("/change")
//	public ResponceStructure updateByName(@PathVariable String name) {
//		return service.updateByName(name);
//	}

//	delete one record
	@Operation(summary = "Delete one record", description = "This end path is used to delete one student record")
	@GetMapping("/dstudent/{id}")
	public ResponceStructure deleteStudentById(@PathVariable int id) {
		return service.deleteStudentById(id);
	}
}
