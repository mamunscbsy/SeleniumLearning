package com.aut.api;

import static org.junit.Assert.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestAPIAUT {

	@Test
	public void testMethod() {	
		
		System.out.print("Got Status in Response "+ callGetApiEndPoint());
		assertEquals(200, callGetApiEndPoint());
	
	
	}
	
	public int callGetApiEndPoint()
	{
		int istatusCode = RestAssured.given()
		.baseUri("https://reqres.in/")	
		.contentType(ContentType.JSON)
		.get("/api/users/3")
		.getStatusCode();
		return istatusCode;
	}

}
