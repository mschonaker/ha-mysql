package io.github.mschonaker.hamysql.dao;

import java.util.List;

import io.github.mschonaker.hamysql.api.User;

public interface UsersDAO {

	User find(String username);

	void insert(User user);
	
	void update(User user);

	void delete(String username);

	List<User> findAll(Long offset, Long limit);

}
