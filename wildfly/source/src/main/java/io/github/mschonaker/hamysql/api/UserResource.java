package io.github.mschonaker.hamysql.api;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import io.github.mschonaker.bundler.Bundler;
import io.github.mschonaker.bundler.Transaction;
import io.github.mschonaker.hamysql.dao.UsersDAO;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("user")
public class UserResource {

	@Resource(name = "jdbc/ha-mysql", lookup = "java:jboss/datasources/ha-mysql")
	DataSource ds;

	@Inject
	UsersDAO users;

	@GET
	@Path("{username}")
	public User find(@PathParam("username") String username) {
		if (username == null)
			throw new IllegalArgumentException("username");
		try (Transaction tx = Bundler.writeTransaction(ds)) {
			return users.find(username);
		}
	}

	@DELETE
	@Path("{username}")
	public void delete(@PathParam("username") String username) {
		if (username == null)
			throw new IllegalArgumentException("username");

		try (Transaction tx = Bundler.writeTransaction(ds)) {

			if (!users.exists(username))
				throw new UserDoesntExistException(username);

			users.delete(username);
			tx.success();
		}
	}

	@PUT
	public void update(User user) {

		if (user == null || user.getUsername() == null || user.getPassword() == null || user.getRealname() == null)
			throw new IllegalArgumentException("body");

		String username = user.getUsername();

		try (Transaction tx = Bundler.writeTransaction(ds)) {

			if (!users.exists(username))
				throw new UserDoesntExistException(username);

			users.update(user);
			tx.success();
		}
	}

	@POST
	public void insert(User user) {

		if (user == null || user.getUsername() == null || user.getPassword() == null || user.getRealname() == null)
			throw new IllegalArgumentException("body");

		String username = user.getUsername();

		try (Transaction tx = Bundler.writeTransaction(ds)) {

			if (users.exists(username))
				throw new UserAlreadyExistsException(username);

			users.insert(user);
			tx.success();
		}
	}
}
