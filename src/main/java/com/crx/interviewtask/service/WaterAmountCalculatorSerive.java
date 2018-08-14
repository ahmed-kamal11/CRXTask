package com.crx.interviewtask.service;

import org.springframework.stereotype.Service;

@Service
public class WaterAmountCalculatorSerive {
	
	public Integer calulateWaterUnits (String arr){
		
		return calulateWaterUnits(splitValuesIntoArray(arr));
	}
	
	public Integer calulateWaterUnits (int [] arr){
		if(arr==null||arr.length==0)
			return 0;
		
		int arrayLength = arr.length;
		int volume = 0;
		
		int[] highestSummitsFromLeft = new int [arrayLength];
		int[] highestSummitsFromRight = new int [arrayLength];
		
		highestSummitsFromRight[arrayLength-1]=arr[arrayLength-1];
		for(int i=arrayLength-2; i>=0; i--)
        {
			highestSummitsFromRight[i] = Math.max(highestSummitsFromRight[i+1],arr[i]);
        }
		
		highestSummitsFromLeft [0] = arr[0];
		for(int i=1; i<arrayLength; i++)
        {
			highestSummitsFromLeft[i] = Math.max(highestSummitsFromLeft[i-1],arr[i]);
        }
		
		for(int i=0; i<arrayLength; i++)
        {
            volume += Math.min(highestSummitsFromLeft[i],highestSummitsFromRight[i]) - arr[i];
        }
		
		return volume;
		
	}
	
	private int [] splitValuesIntoArray(String values){
		if(values==null||values.isEmpty()){
			return null;
		}
		String [] stringValues =values.split(",");
		int [] intValues = new int [stringValues.length];
		for (int i = 0 ; i < stringValues.length ; i++) {
			intValues[i]=Integer.parseInt(stringValues[i]);
		}
		return intValues;
	}

}
