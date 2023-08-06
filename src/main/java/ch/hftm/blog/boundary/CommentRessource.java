package ch.hftm.blog.boundary;

import ch.hftm.blog.control.CommentService;
import ch.hftm.blog.entity.Blog;
import ch.hftm.blog.entity.Comment;
import ch.hftm.blog.errors.BlogException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("comment")
@Produces("application/json")
@Consumes("application/json")
public class CommentRessource {

    @Inject
    CommentService commentService;

    BlogException blogException;

    @GET
    public List<Comment> getEntries(@QueryParam("search") String search, @HeaderParam("password") String password) {
        System.out.println("Password: " + password);
        if (search == null || search.isBlank()) {
            return commentService.getComment();
        }else{
            if(!password.equals("password")){
//                throw new BlogException("Password ist nicht korrekt", 401);
                blogException = new BlogException("Password ist nicht korrekt", 401);
            }else{

            }
            return commentService.findComment(search);
        }
    }
}
