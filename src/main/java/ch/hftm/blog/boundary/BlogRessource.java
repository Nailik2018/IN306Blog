package ch.hftm.blog.boundary;

import ch.hftm.blog.control.BlogService;
import ch.hftm.blog.entity.Blog;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("blogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogRessource {

    @Inject
    BlogService blogService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Blog> getBlogs(){
        return blogService.getBlogs();
    }

    @GET
    @Path("{id}")
    public Blog getBlogById(@PathParam("id") Long id) {
        return blogService.getBlogById(id);
    }

    @POST
    public void addBlog(Blog blog) {
        this.blogService.addBlog(blog);
    }

    @PUT
    public void updateBlog(Blog blog) {
        this.blogService.updateBlog(blog);
    }

    @DELETE
    public void deleteBlog(Long id) {
        this.blogService.deleteBlog(id);
    }
}