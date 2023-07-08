package ch.hftm.blog.boundary;

import ch.hftm.blog.control.BlogService;
import ch.hftm.blog.entity.Blog;
import ch.hftm.blog.errors.BlogException;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("blogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogRessource {

    @Inject
    BlogService blogService;

    BlogException blogException;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Blog> getBlogs(){
//        return blogService.getBlogs();
//    }

    @GET
    public List<Blog> getEntries(@QueryParam("search") String search, @HeaderParam("password") String password) {
        System.out.println("Password: " + password);
        if (search == null || search.isBlank()) {
            return blogService.getBlogs();
        }else{
            if(!password.equals("password")){
//                throw new BlogException("Password ist nicht korrekt", 401);
                blogException = new BlogException("Password ist nicht korrekt", 401);
            }
            return blogService.findBlogs(search);
        }
    }

    @GET
    @Path("{id}")
    public Blog getBlogById(@PathParam("id") Long id) {
        return blogService.getBlogById(id);
    }

//    @GET
//    @Path("{id}")
//    public Response getBlogById(@PathParam("id") Long id) {
//        var blog = this.blogService.getBlogById(id);
//        // Keine Anhung warum das nicht funktioniert
//        return Response.ok().entity(blog).header(name:"info", value:"Bitter version 2 Vewrenwnden").build();
//    }

    @POST
    public void addBlog(@Valid Blog blog) {
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