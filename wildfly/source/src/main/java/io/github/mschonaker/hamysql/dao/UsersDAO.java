package io.github.mschonaker.hamysql.dao;

import java.util.List;

import io.github.mschonaker.hamysql.api.User;

public interface UsersDAO {

	User find(String username);

	void replace(User user);

	void delete(String username);

	List<User> findAll(Long offset, Long limit);

}
