package ch.hftm.blog.boundary;

import ch.hftm.blog.control.AuthorService;
import ch.hftm.blog.entity.Author;
import ch.hftm.blog.errors.BlogException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Tag(name="Author REST API")

@Path("author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRessource {

    @Inject
    AuthorService authorService;

    BlogException blogException;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Author> getAuthors() {
//        return authorService.getAuthors();
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAuthors(@QueryParam("search") String search, @HeaderParam("password") String password) {
        System.out.println("Password: " + password);
        if(search == null || search.isBlank()) {
            return authorService.getAuthors();
        }else{
            if(!password.equals("password")){
                throw new BlogException("Password ist nicht korrekt", 401);
            }else{
                return authorService.findAuthors(search);
            }
        }
    }

    @GET
    @Path("{id}")
    public Author getAuthorById(@PathParam("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @POST
    public void addAuthor(@Valid Author author, @Context UriInfo uriInfo) {
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
