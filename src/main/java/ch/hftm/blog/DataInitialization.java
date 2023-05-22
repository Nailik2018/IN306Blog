package ch.hftm.blog;

import ch.hftm.blog.boundary.BlogService;
import ch.hftm.blog.entity.Blog;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {

    BlogService blogService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        // Initialize Data only if there is no Data around
        Blog blog1 = new Blog("Honeyhunting", "Bangladesch");
        Blog blog2 = new Blog("Gleitschirmferien in Bosnien", "Text");
//        if (Blog.count() < 1) {
            blogService.addBlog(blog1);
            blogService.addBlog(blog2);
            // ... here you can create and persist your entities
//        }
    }
}
