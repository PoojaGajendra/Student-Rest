package org.jsp.RestCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.RestCrud.dao.DaoStudent;
import org.jsp.RestCrud.dto.Student;
import org.jsp.RestCrud.exception.DataNotFoundException;
import org.jsp.RestCrud.helper.ResponceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ServiceStudent {

	@Autowired
	ResponceStructure structure;

	@Autowired
	DaoStudent dao;

//save one record
	public ResponceStructure saveStudent(Student student) {
		double percentage = (student.getEnglish() + student.getScience() + student.getMath()) / 3.0;
		student.setPercentage(percentage);
		if (student.getEnglish() < 35 || student.getScience() < 35 || student.getMath() < 35) {
			student.setResult("Fail");
		} else {
			if (percentage >= 85) {
				student.setResult("Distinction");
			} else if (percentage >= 60) {
				student.setResult("First Class");
			} else if (percentage >= 35) {
				student.setResult("Second Class");
			} else if (percentage >= 60) {
				student.setResult("Fail");
			}
		}
		dao.save(student);

		structure.setData(student);
		structure.setMessage("Record save success");
		structure.setStatus(HttpStatus.CREATED.value());

		return structure;
	}

//	fetch by id
	public ResponceStructure fetchStudentById(int id) {
		Optional<Student> op = dao.fetchById(id);
		if (op.isEmpty()) {
			throw new DataNotFoundException("Data not found for id:" + id);
		} else {
			structure.setData(op.get());
			structure.setMessage("Data Found ");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

	// fetchStudentByName
	public ResponceStructure fetchByName(String name) {
		List<Student> student = dao.fetchByName(name);
		if (student.isEmpty()) {
			throw new DataNotFoundException("Data not found for name:" + name);

		} else {
			structure.setData(student);
			structure.setMessage("Data Found ");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

//fetchByMobile
	public ResponceStructure fetchByMobile(long mobile) {
		List<Student> student = dao.fetchByMobile(mobile);
		if (student.isEmpty()) {
			throw new DataNotFoundException("Data not found for mobile:" + mobile);

		} else {
			structure.setData(student);
			structure.setMessage("Data Found ");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

//fetch By Result
	public ResponceStructure fetchByResult(String result) {
		List<Student> student = dao.fetchByResult(result);
		if (student.isEmpty()) {
			throw new DataNotFoundException("Data not found for result:" + result);

		} else {
			structure.setData(student);
			structure.setMessage("Data Found ");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

//fetch By Math
	public ResponceStructure fetchBySubjectMarksGreater(String subject, int marks) {
		List<Student> student = null;
		if (subject.equals("math")) {
			student = dao.fetchByMathGreater(marks);
		} else if (subject.equals("science")) {
			student = dao.fetchByScienceGreater(marks);
		} else if (subject.equals("english")) {
			student = dao.fetchByEnglishGreater(marks);
		} else {
			student = new ArrayList<Student>();
		}
		if (student.isEmpty()) {
			throw new DataNotFoundException("Data not found ");

		} else {
			structure.setData(student);
			structure.setMessage("Data Found ");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

//	fetch students with between marks1 and marks2 for subject(math,science,engish)
	public ResponceStructure fetchStuMarksBetween(String subject, int marks1, int marsk2) {
		List<Student> student = null;
		if (subject.equals("math")) {
			student = dao.fetchByMathbetween(marks1, marsk2);
		} else if (subject.equals("science")) {
			student = dao.fetchBySciencebetween(marks1, marsk2);
		} else if (subject.equals("english")) {
			student = dao.fetchByEnglishbetween(marks1, marsk2);
		} else {
			student = new ArrayList<Student>();
		}
		if (student.isEmpty()) {
			throw new DataNotFoundException("Data not found ");

		} else {
			structure.setData(student);
			structure.setMessage("Data Found ");
			structure.setStatus(HttpStatus.FOUND.value());
		}
		return structure;
	}

//	delete record by id
	public ResponceStructure deleteStudentById(int id) {
		dao.deleteStudentById(id);
		structure.setData(null);
		structure.setMessage("Data Deleted");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

//	fetch all record
	public ResponceStructure fetchAll() {
		List<Student> students = dao.fetchAll();
		structure.setData(students);
		structure.setMessage("Found Deleted");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

//	save all record
	public ResponceStructure saveAll(Student student) {
		dao.saveAll(student);
		structure.setData(null);
		structure.setMessage(" Data saved sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponceStructure update(Student student) {
		return null;
	}

	public ResponceStructure updateByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
