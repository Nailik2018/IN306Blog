package ch.hftm.blog.control;

import ch.hftm.blog.entity.Blog;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {

    @Inject
    BlogService blogService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        // Initialize Data (only if there is no Data around)
        Blog blog = new Blog();
        blog.setContent("Hallo");
        blog.setTitle("Titel");
        blogService.addBlog(blog);

    }
}