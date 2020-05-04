package local.tin.tests.services.facades;

import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
@Path("/helloWorld")
public class HelloWorld {

    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class);

    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getHelloByGET(@QueryParam("message") String message) {
        long t0 = System.currentTimeMillis();
        Response response = Response.status(500).entity("Error").build();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hello being, it's ").append(new Date()).append(" and I've received your message: '").append(message).append("' by GET");
            response = Response.status(200).entity(stringBuilder.toString()).build();
        } finally {
            LOGGER.debug("Configuration served in: " + (System.currentTimeMillis() - t0));
        }
        return response;
    }

    @POST
    @Path("/post")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response getHelloByPOST(String message) {
        long t0 = System.currentTimeMillis();
        Response response = Response.status(500).entity("Error").build();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Hello being, it's ").append(new Date()).append(" and I've received your message: '").append(message).append("' by POST");
            response = Response.status(200).entity(stringBuilder.toString()).build();
        } finally {
            LOGGER.debug("Configuration served in: " + (System.currentTimeMillis() - t0));
        }
        return response;
    }    
    
}
