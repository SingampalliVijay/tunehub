package com.example.demo.services;

import com.example.demo.entities.Users;
public interface UsersService {

	public String addUser(Users user);
	public boolean emailExists(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String emial);
	public Users getUser(String emial);
	public void updateUser(Users user);
}
