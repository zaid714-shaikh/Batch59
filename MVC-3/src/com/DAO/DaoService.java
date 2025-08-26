package com.DAO;

import java.util.List;

import com.DTO.UserDTO;
import com.Entity.User;

public interface DaoService {

	void regiserInDao(User user);

	UserDTO loginUser(String un);

	List<User> loginAdminInDao();

	List<User> deleteUserByIdInDao(int uid);


}
