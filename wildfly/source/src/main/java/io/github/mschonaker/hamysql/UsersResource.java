package io.github.mschonaker.hamysql;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("users")
public class UsersResource {
	
	@Inject
	private Application application;
	
	@PUT
	public void put(User user) {
		
		
		
	}
	
	
	
	
	
	
	

}
