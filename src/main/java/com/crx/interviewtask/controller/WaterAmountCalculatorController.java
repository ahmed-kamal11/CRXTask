package com.crx.interviewtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crx.interviewtask.dto.ArrayDto;
import com.crx.interviewtask.service.WaterAmountCalculatorSerive;

@RestController
@RequestMapping("/api")
public class WaterAmountCalculatorController {
	
	@Autowired 
	WaterAmountCalculatorSerive waterAmountCalculatorSerive;
	
	@RequestMapping(value = "/getWaterAmount/{arr}", method = RequestMethod.GET)
	public ResponseEntity<Integer> calulateWaterUnits(@PathVariable("arr") String arr){
		
		return new ResponseEntity<>(waterAmountCalculatorSerive.calulateWaterUnits(arr), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/calulateWaterUnits", method = RequestMethod.POST)
	public ResponseEntity<Integer> calulateWaterUnits(@RequestBody ArrayDto dto){
		
		return new ResponseEntity<>(waterAmountCalculatorSerive.calulateWaterUnits(dto.getArr()), HttpStatus.OK);
		
	}
	

}
