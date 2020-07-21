package com.example.springrabbitmqdemo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

	private String id;
	private String name;
	private String test;

	
	public Order() {
	}
	public Order(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
