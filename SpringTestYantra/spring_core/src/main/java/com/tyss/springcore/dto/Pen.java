package com.tyss.springcore.dto;

public class Pen implements Writer{

	@Override
	public void write() {
		System.out.println("Writting using Pen");
	}

}
