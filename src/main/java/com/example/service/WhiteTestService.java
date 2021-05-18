package com.example.service;


import java.time.LocalDateTime;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;


import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Service
public class WhiteTestService {

	//service avec Address de type String
	/*public WhiteTestResponse getStudentStatus(StudentRequest studentRequest) throws DatatypeConfigurationException {
		Boolean testId=false;
		Boolean testCode=false;
		int id=0;
		int code=0;
		List<Student> students = new Student().getStudents() ;
		List<Exam> exams = new Exam().getExams() ;
		
		//tester si l'id de studient existe dans la liste ou non 
		for (int i=0;i<students.size();i++) {
			if(students.get(i).getId()==studentRequest.getStudentId()) {
				testId=true;
				id=i;
				break;
			}
		}
		//tester si le code de l'exam existe dans la liste ou non 
		for (int i=0;i<exams.size();i++) {
			if(exams.get(i).getCode().equalsIgnoreCase(studentRequest.getExamCode())) {
				testCode=true;
				code=i;
				break;
			}
		}

		WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
		List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
		if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 || !(testId)) {
			mismatchs.add("wrong student id");
		}
		if(studentRequest.getExamCode().isEmpty()) {
			mismatchs.add("exam code must be not empty");
		}
		if(!(testCode))
		{
			mismatchs.add("wrong exam code");
		}
		if(mismatchs.isEmpty()) {
			Student student = new Student();
			student.setId(studentRequest.getStudentId());
			student.setName(students.get(id).getName());
			student.setAddress((students.get(id).getAddress()));
			Exam exam = new Exam();
			exam.setCode(studentRequest.getExamCode());
			exam.setName(exams.get(code).getName());
			whiteTestResponse.setStudent(student);
			whiteTestResponse.setExam(exam);
			LocalDateTime localDate = LocalDateTime.now().plusDays(3);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
			whiteTestResponse.setDate(xmlGregorianCalendar);
			whiteTestResponse.setIsValid(true);
			
		}else {
			whiteTestResponse.setIsValid(false);
		}
		return whiteTestResponse;
	}*/

	
/*****************************************************************************************************************************/
	
	//service avec Address de type complexe
	public WhiteTestResponse getStudentStatus2(StudentRequest studentRequest) throws DatatypeConfigurationException {
		Boolean testId=false;
		Boolean testCode=false;
		int id=0;
		int code=0;
		List<Student> students = new Student().getStudents() ;
		List<Exam> exams = new Exam().getExams() ;

		//tester si l'id de studient existe dans la liste ou non 
		for (int i=0;i<students.size();i++) {
			if(students.get(i).getId()==studentRequest.getStudentId()) {
				testId=true;
				id=i;
				break;
			}
		}
		//tester si le code de l'exam existe dans la liste ou non 
		for (int i=0;i<exams.size();i++) {
			if(exams.get(i).getCode().equalsIgnoreCase(studentRequest.getExamCode())) {
				testCode=true;
				code=i;
				break;
			}
		}

		WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
		List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
		if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 || !(testId)) {
			mismatchs.add("wrong student id");
		}
		if(studentRequest.getExamCode().isEmpty()) {
			mismatchs.add("exam code must be not empty");
		}
		if(!(testCode))
		{
			mismatchs.add("wrong exam code");
		}
		if(mismatchs.isEmpty()) {
			Student student = new Student();
			student.setId(studentRequest.getStudentId());
			student.setName(students.get(id).getName());
			student.setAddress((students.get(id).getAddress()));
			Exam exam = new Exam();
			exam.setCode(studentRequest.getExamCode());
			exam.setName(exams.get(code).getName());
			whiteTestResponse.setStudent(student);
			whiteTestResponse.setExam(exam);
			LocalDateTime localDate = LocalDateTime.now().plusDays(3);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
			whiteTestResponse.setDate(xmlGregorianCalendar);
			whiteTestResponse.setIsValid(true);
			
		}else {
			whiteTestResponse.setIsValid(false);
		}
		return whiteTestResponse;
	}

	public List<Exam> getExams(){
		return new Exam().getExams();
	}
}
