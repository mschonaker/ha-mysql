package io.github.mschonaker.hamysql;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.github.mschonaker.hamysql.api.UserAlreadyExistsException;
import io.github.mschonaker.hamysql.api.UserDoesntExistException;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {

		if (exception instanceof UserAlreadyExistsException)
			return Response.status(501).entity(exception.getMessage()).build();

		if (exception instanceof UserDoesntExistException)
			return Response.status(502).entity(exception.getMessage()).build();

		if (exception instanceof IllegalArgumentException)
			return Response.status(400).entity(exception.getMessage()).build();

		throw new IllegalStateException();
	}
}
