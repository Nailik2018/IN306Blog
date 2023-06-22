package ch.hftm.blog.boundary;

import ch.hftm.blog.control.AuthorRepository;
import ch.hftm.blog.entity.Author;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("author")
public class AuthorRessource {

    @Inject
    AuthorRepository authorRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authorRepository.listAll();
    }
}
