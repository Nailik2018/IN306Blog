package ch.hftm.blog.boundary;

import ch.hftm.blog.control.AuthorService;
import ch.hftm.blog.entity.Author;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRessource {

    @Inject
    AuthorService authorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @GET
    @Path("{id}")
    public Author getAuthorById(@PathParam("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @POST
    public void addAuthor(Author author) {
        this.authorService.addAuthor(author);
    }

    @PUT
    public void updateAuthor(Author author) {
        this.authorService.updateAuthor(author);
    }

    @DELETE
    public void deleteAuthor(Long id) {
        this.authorService.deleteAuthor(id);
    }
}
