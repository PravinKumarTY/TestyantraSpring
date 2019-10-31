package com.tyss.springcore.dto;

public class Author {
	private String name;
	private Writer write;
	public Author(String name, Writer write) {
		this.name = name;
		this.write = write;
	}
	public String getName() {
		return name;
	}
	public Writer getWrite() {
		return write;
	}
	
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Writer getWrite() {
		return write;
	}
	public void setWrite(Writer write) {
		this.write = write;
	}*/

}
