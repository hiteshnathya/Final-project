package com.example.electricitybillpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.electricitybillpayment.dto.BillDto;
import com.example.electricitybillpayment.service.BillService;

@RestController
@RequestMapping("/billing")
public class BillController {
	@Autowired
	private BillService billService;
	
	@PostMapping
	public ResponseEntity<String> addBill( @RequestBody BillDto billDto){
		
		billService.saveBill(billDto);

		return new ResponseEntity<>("Welcome to Bill Screen",HttpStatus.CREATED);
	}
}
