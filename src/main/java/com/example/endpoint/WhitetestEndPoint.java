package com.example.endpoint;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.service.WhiteTestService;

import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Endpoint
public class WhitetestEndPoint {
	
	public final static String nameSpace="http://www.tekup.de/soap/models/whitetest";
	@Autowired
	private WhiteTestService service;
	@PayloadRoot(namespace = nameSpace , localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse checkWhiteTest (@RequestPayload StudentRequest studentRequest) throws DatatypeConfigurationException {
		
		return service.getStudentStatus(studentRequest);
	}
}