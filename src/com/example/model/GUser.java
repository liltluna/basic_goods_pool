package com.example.model;
import java.util.Date;

public class GUser{
	private String username;
	private String password;
	private int user_id;
	private Date date;

	public GUser(){
		username = "test";
		password = "123";
		user_id = 0;
		date = new Date();
	}

	public GUser(String username, String password, int id, Date date){
		this.username = username;
		this.password = password;
		user_id = id;
		this.date = date;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

} 