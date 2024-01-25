package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User added Successfully";
	}

	@Override
	public boolean emailExists(String email) {
		if (repo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		String db_pass = user.getPassword();
		if (password.equals(db_pass)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String emial) {
		Users user = repo.findByEmail(emial);
		return user.getRole();
	}

	@Override
	public Users getUser(String emial) {
		return repo.findByEmail(emial);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}
}
