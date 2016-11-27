package io.github.mschonaker.hamysql;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;

import io.github.mschonaker.bundler.Bundler;
import io.github.mschonaker.bundler.Transaction;
import io.github.mschonaker.hamysql.dao.SetupDAO;
import io.github.mschonaker.hamysql.dao.UsersDAO;

@ApplicationPath("/api")

public class Application extends javax.ws.rs.core.Application {

	@Resource(name = "jdbc/ha-mysql", lookup = "java:jboss/datasources/ha-mysql")
	private DataSource ds;

	@Produces
	@ApplicationScoped
	public SetupDAO setupDAO() {
		try {
			return Bundler.inflate(SetupDAO.class);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	@Produces
	@ApplicationScoped
	public UsersDAO createUserDAO() {
		try {
			return Bundler.inflate(UsersDAO.class);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	@PostConstruct
	public void createDatabase() {
		SetupDAO setup = setupDAO();
		try (Transaction tx = Bundler.writeTransaction(ds)) {
			setup.createUsersTable();
			tx.success();
		}
	}
}
