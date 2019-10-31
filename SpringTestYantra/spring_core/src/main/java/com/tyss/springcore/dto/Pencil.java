package com.tyss.springcore.dto;

public class Pencil implements Writer{

	@Override
	public void write() {
		System.out.println("Writting using Pencil");
	}
}
