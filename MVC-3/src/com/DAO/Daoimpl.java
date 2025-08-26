package com.DAO;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.DTO.UserDTO;
import com.Entity.User;

@Repository
public class Daoimpl implements DaoService {

	@Autowired
	private SessionFactory sf;

	@Override
	public void regiserInDao(User user) {

		System.out.println("I am in DAO layer");
		System.out.println(user);

		Session s = sf.openSession();
		s.save(user);
		s.beginTransaction().commit();
		System.out.println("User SAved");

	}

	@Override
	public UserDTO loginUser(String un) {

		System.out.println("I am in DAO layer :: " + un);

		UserDTO udto = new UserDTO();

		Session s = sf.openSession();
		Query query = s.createQuery("select uname,uaddress,age,upassword from User where uname= :name");
		query.setString("name", "expo");
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {

			String name = (String) objects[0];
			System.out.println(name);
			udto.setUname(name);

			String address = (String) objects[1];
			System.out.println(address);
			udto.setUaddress(address);

			Integer age = (Integer) objects[2];
			System.out.println(age);
			udto.setAge(age);

		}

		System.out.println(udto);

		return udto;
	}

	@Override
	public List<User> loginAdminInDao() {

		Session s = sf.openSession();
		Query query = s.createQuery("from User");
		List allUsers = query.getResultList();
		s.beginTransaction().commit();
		System.out.println(allUsers);
		return allUsers;
	}

	@Override
	public List<User> deleteUserByIdInDao(int uid) {

		Session session = sf.openSession();
		User user = session.get(User.class, uid);

		if (user != null) {
			session.delete(user);
			session.beginTransaction().commit();
			System.out.println("User Deleted");
		}

		Query query = session.createQuery("from User");
		List allUsers = query.getResultList();

		return allUsers;

	}

}
