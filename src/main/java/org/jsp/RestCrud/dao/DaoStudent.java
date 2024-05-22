package org.jsp.RestCrud.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.RestCrud.dto.Student;
import org.jsp.RestCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoStudent {
	@Autowired
	StudentRepository studentRepository;

//	save one records
	public void save(Student student) {
		studentRepository.save(student);
	}

//	fetch Students by Id
	public Optional<Student> fetchById(int id) {
		return studentRepository.findById(id);
	}

//	fetchStudentByName
	public List<Student> fetchByName(String name) {
		return studentRepository.findByName(name);
	}

//	delete Student by Id
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}

//	fetch all record
	public List<Student> fetchAll() {
		// List<Student>stu=new ArrayList<Student>();
		return studentRepository.findAll();
		// .forEach(stul->stu.add(stul));
	}

//	save all record
	public List<Student> saveAll(Student student) {
		return studentRepository.saveAll(null);
	}

//	fetchStudentByMobile
	public List<Student> fetchByMobile(long mobile) {
		return studentRepository.findByMobile(mobile);
	}

//	fetchStudentByResult
	public List<Student> fetchByResult(String result) {
		return studentRepository.findByResult(result);
	}

//math greater than marks
	public List<Student> fetchByMathGreater(int marks) {
		return studentRepository.findByMathGreaterThanEqual(marks);
	}

//science greater than marks
	public List<Student> fetchByEnglishGreater(int marks) {
		return studentRepository.findByEnglishGreaterThanEqual(marks);
	}

//english greater than marks
	public List<Student> fetchByScienceGreater(int marks) {
		return studentRepository.findByScienceGreaterThanEqual(marks);
	}

//	find students with marks between Marks1 and Marks2 for math sub
	public List<Student> fetchByMathbetween(int marks1, int marsk2) {
		return studentRepository.findByMathBetween(marks1, marsk2);
	}

//	find students with marks between Marks1 and Marks2 for science
	public List<Student> fetchBySciencebetween(int marks1, int marsk2) {
		return studentRepository.findByScienceBetween(marks1, marsk2);
	}

//	find students with marks between Marks1 and Marks2 for English
	public List<Student> fetchByEnglishbetween(int marks1, int marsk2) {
		return studentRepository.findByEnglishBetween(marks1, marsk2);
	}

}
