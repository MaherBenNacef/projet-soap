package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public List<Student> students ;

	public WhiteTestService(List<Student> students) {
		this.students = new ArrayList<>();
		for (int i=1; i<11;i++) {
			Student s = new Student();
			s.setId(i);
			s.setName("Student"+i);
			s.setAddress("address"+i);
			students.add(s);
		}
	}
	
	public Boolean exist(int id) {
		for (Student student : students) {
			if(student.getId()==id) {
				return false;
			}
		}
		return true;
	}


	public WhiteTestResponse getStudentStatus(StudentRequest studentRequest) throws DatatypeConfigurationException {
		String examName="";
		WhiteTestResponse whiteTestResponse = new ObjectFactory().createWhiteTestResponse();
		List<String> mismatchs =whiteTestResponse.getCriteriaMismatch();
		if(studentRequest.getStudentId()==0 || studentRequest.getStudentId()<0 ) {
			mismatchs.add("wrong student id");
		}
		if(studentRequest.getExamCode().isEmpty()) {
			mismatchs.add("exam code must be not enpty");
		}
		if(mismatchs.isEmpty()) {
			Student student = new Student();
			student.setId(studentRequest.getStudentId());
			student.setName("Student"+studentRequest.getStudentId());
			student.setAddress("Address"+studentRequest.getStudentId());
			Exam exam = new Exam();
			exam.setCode(studentRequest.getExamCode());
			if(studentRequest.getExamCode().equalsIgnoreCase("1z0-808"))
			{
				examName="Java OCA";
			}else if (studentRequest.getExamCode().equalsIgnoreCase("1Z0-819")) {
				examName="Java OCP";
			}else if (studentRequest.getExamCode().equalsIgnoreCase("1z0-897")) {
				examName="Java OCE";
			}else {
				examName=studentRequest.getExamCode();
			}
			exam.setName(examName);
			whiteTestResponse.setStudent(student);
			whiteTestResponse.setExam(exam);
			LocalDate localDate = LocalDate.now().plusDays(3);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
			whiteTestResponse.setDate(xmlGregorianCalendar);
			whiteTestResponse.setIsValid(true);
			
		}else {
			whiteTestResponse.setIsValid(false);
		}
		return whiteTestResponse;
	}

}
