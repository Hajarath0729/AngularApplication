package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AlphaNumericPhoneNumberService;

@RestController
public class AlphaNumericPhoneNumberController {
	
	@Autowired
	private AlphaNumericPhoneNumberService alphaNumericPhoneNumberService;
	
	@CrossOrigin
	@GetMapping(value="/alpha-numeric-phonenumbers")
	public List<String> getAlphaNumericPhoneNumbers(@RequestParam String phoneNumber) {
		return alphaNumericPhoneNumberService.getAlphaNumericPhoneNumbers(phoneNumber);
	}

}
