package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.demo.service.AlphaNumericPhoneNumberService;

@Service
public class AlphaNumericPhoneNumberServiceImpl implements AlphaNumericPhoneNumberService {
	
	Map<String, String> phone = null;
	List<String> output = null;

	public List<String> getAlphaNumericPhoneNumbers(String phoneNumber) {
		phone = new HashMap<String, String>() {{
			put("0", "0");
			put("1", "1");
		    put("2", "2abc");
		    put("3", "3def");
		    put("4", "4ghi");
		    put("5", "5jkl");
		    put("6", "6mno");
		    put("7", "7pqrs");
		    put("8", "8tuv");
		    put("9", "9wxyz");
		  }};
		 output = new ArrayList<>();
		 
		if (StringUtils.isNotBlank(phoneNumber) && phoneNumber.matches("^([0-9]{7})$|(^[0-9]{10})$")) {
			 alphaNumericPhoneNumbers("", phoneNumber);
			 return output;
		} else {
			throw new ArithmeticException("Failed due to Invalid Phone Number or Invalid length. It should be 7 or 10 digits length"); 
		}
	}
	
	public void alphaNumericPhoneNumbers(String combination, String phoneNumber) {
	    if (phoneNumber.length() == 0) {
	      output.add(combination);
	    } else {
	      String digit = phoneNumber.substring(0, 1);
	      String letters = phone.get(digit);
	      for (int i = 0; i < letters.length(); i++) {
	        String letter = phone.get(digit).substring(i, i + 1);
	        alphaNumericPhoneNumbers(combination + letter, phoneNumber.substring(1));
	      }
	    }
	}
}
