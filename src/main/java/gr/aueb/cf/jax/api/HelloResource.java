package gr.aueb.cf.jax.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.awt.*;


@Path("/hello")
public class HelloResource {

    @GET
    @Path("/cf")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from CF7!!!";
    }

    @GET
    @Path("/dimitris")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloDimitris() {return "Γεια σου Δημήτρη";}

}
