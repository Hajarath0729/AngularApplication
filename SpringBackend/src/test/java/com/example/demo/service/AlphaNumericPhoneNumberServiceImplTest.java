package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.service.impl.AlphaNumericPhoneNumberServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AlphaNumericPhoneNumberServiceImplTest {
	
	@InjectMocks
	private AlphaNumericPhoneNumberServiceImpl alphaNumericPhoneNumberService;
	
	private List<String> response;
	
	
	@Test(expected = ArithmeticException.class)
	public void TestGetAlphaNumericPhoneNumbersInvalidPhoneNumber() {
		alphaNumericPhoneNumberService.getAlphaNumericPhoneNumbers("123");
	}
	
	@Test
	public void TestGetAlphaNumericPhoneNumbers() {
		response = new ArrayList<>();
		response.add("23456p8");
		response.add("23456pt");
		List<String> response = alphaNumericPhoneNumberService.getAlphaNumericPhoneNumbers("1234567");
		assertEquals(response, response);
	}
	
	

}
