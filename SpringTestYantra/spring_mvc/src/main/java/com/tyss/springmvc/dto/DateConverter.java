package com.tyss.springmvc.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	public static void main(String[] args) throws ParseException {
		String date="15/08/1947";
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	    Date d=format.parse(date);
	}
	
}
