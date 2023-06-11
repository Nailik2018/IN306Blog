package ch.hftm.blog.boundary;

import ch.hftm.blog.control.BlogRepository;
import ch.hftm.blog.entity.Blog;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/blog")
public class BlogRessource {

    @Inject
    BlogRepository blogRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> getBlogs(){
        return blogRepository.listAll();
    }
}