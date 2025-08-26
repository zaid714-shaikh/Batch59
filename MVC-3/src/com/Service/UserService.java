package com.Service;

import java.util.List;

import com.DTO.UserDTO;
import com.Entity.User;

public interface UserService {

	void Register(User user);

	UserDTO login(String un, String ps);

	List<User> loginAdmin(String un, String ps);

	List<User> deleteUserById(int uid);

	 

}
