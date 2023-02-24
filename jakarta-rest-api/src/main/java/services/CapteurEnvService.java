package services ; 

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.CapteurEnvBusiness;
import entities.CapteurEnv;

@Path("capteurs")
public class CapteurEnvService {

	@Inject
	private CapteurEnvBusiness personneBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCapteursEnv() {
		return Response.ok(personneBusiness.getAllCapteursEnv()).build();
	}


	
}
