package io.github.mschonaker.hamysql.api;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import io.github.mschonaker.bundler.Bundler;
import io.github.mschonaker.bundler.Transaction;
import io.github.mschonaker.hamysql.dao.UsersDAO;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("users")
public class UsersResource {

	@Resource(name = "jdbc/ha-mysql", lookup = "java:jboss/datasources/ha-mysql")
	private DataSource ds;

	@Inject
	private UsersDAO users;

	@GET
	public List<User> findAll(@QueryParam("offset") @DefaultValue("0") Long offset,
			@QueryParam("limit") @DefaultValue("10") Long limit) {
		try (Transaction tx = Bundler.writeTransaction(ds)) {
			return users.findAll(offset, limit);
		}
	}
}
