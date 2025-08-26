package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.DaoService;
import com.DTO.UserDTO;
import com.Entity.User;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private DaoService ds;

	@Override
	public void Register(User user) {
		System.out.println("I am in Service layer");
		System.out.println(user);
		ds.regiserInDao(user);

	}

	@Override
	public UserDTO login(String un, String ps) {

		System.out.println("I am in Service Layer :: " + un + " " + ps);

		UserDTO udto = ds.loginUser(un);

		return udto;

	}

	@Override
	public List<User> loginAdmin(String un, String ps) {

		System.out.println("I am in Service Layer :: " + un + " " + ps);

		if (un.equals("admin") && ps.equals("admin123")) {

			List<User> allUsers = ds.loginAdminInDao();

			return allUsers;
		}

		return null;
	}
	
	@Override
	public List<User> deleteUserById(int uid) {
		
		System.out.println(" I am in Service Layer " + uid);
		
		return ds.deleteUserByIdInDao(uid);
		
	}

}
