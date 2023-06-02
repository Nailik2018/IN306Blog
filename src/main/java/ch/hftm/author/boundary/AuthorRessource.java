package ch.hftm.author.boundary;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/author")
public class AuthorRessource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hallo(){
        return "Author";
    }
}
