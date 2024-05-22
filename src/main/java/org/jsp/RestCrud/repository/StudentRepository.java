package org.jsp.RestCrud.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.RestCrud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//we extend JpaRepository coz it provides inbuilt method to save, fetch, delete, update

	// fetchStudentByName
	List<Student> findByName(String name);

	// fetchStudentByMobile
	List<Student> findByMobile(long mobile);

	// fetchStudentByResult
	List<Student> findByResult(String result);

	// fetchStudent who's maths marks greater than
	List<Student> findByMathGreaterThanEqual(int marks);

	// fetchStudent who's english marks greater than
	List<Student> findByEnglishGreaterThanEqual(int marks);

	// fetchStudent who's science marks greater than
	List<Student> findByScienceGreaterThanEqual(int marks);

	// find students with marks between Marks1 and Marks2 for math sub
	List<Student> findByMathBetween(int marks1, int marsk2);

	// find students with marks between Marks1 and Marks2 for science
	List<Student> findByScienceBetween(int marks1, int marsk2);

	// find students with marks between Marks1 and Marks2 for English
	List<Student> findByEnglishBetween(int marks1, int marsk2);
}
