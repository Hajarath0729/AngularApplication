package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.example.demo.service.AlphaNumericPhoneNumberService;

@RunWith(MockitoJUnitRunner.class)
public class AlphaNumericPhoneNumberControllerTest {
	
	@InjectMocks
	private AlphaNumericPhoneNumberController alphaNumericPhoneNumberController;
	
	@Mock
	private AlphaNumericPhoneNumberService alphaNumericPhoneNumberService;
	
	private List<String> response;
	
	@Test
	public void TestGetAlphaNumericPhoneNumbers() {
		response = new ArrayList<>();
		response.add("23456p8");
		response.add("23456pt");
		when(alphaNumericPhoneNumberService.getAlphaNumericPhoneNumbers(any())).thenReturn(response);
		List<String> phoneNumbers = alphaNumericPhoneNumberController.getAlphaNumericPhoneNumbers("2345678");
		assertEquals(response, phoneNumbers);
	}

}
