package ch.hftm.blog.boundary;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/blog")
public class BlogRessource {

//    @Inject
//    BlogRepository blogRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
        public String hallo(){
        return "Willkommen auf meinen Blog!!";
    }
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public List<Blog> getAllBlogList(){
//        return blogRepository.findAll().list();
//    }
}