package com.ugurcanlacin.simple.dao;

import com.ugurcanlacin.simple.model.User;

public interface UserDao {
	void persistUserdd(User user);
	User findUserById(int id);
	void updateUser(User user);
	void deleteUser(User user);
}
