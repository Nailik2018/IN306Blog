package ch.hftm.blog.control;

import ch.hftm.blog.entity.Author;
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
    AuthorService authorService;

    @Transactional
    public void init(@Observes StartupEvent event) {
        // Initialize Data (only if there is no Data around)
        createSomeBlogsAndAuthors();
    }

    public void createSomeBlogsAndAuthors(){
        Blog blog1 = new Blog();
        blog1.setContent("Peking China");
        blog1.setTitle("Peking Ente essen und danach auf die Mauer");
        Blog blog2 = new Blog();
        blog2.setTitle("Tenerifa Spanien");
        blog2.setContent("Lost places, Vulkan und Meer");
        Blog blog3 = new Blog();
        blog3.setTitle("Gleitschirmferien in Bosnien und Herzegowina");
        blog3.setContent("Gleitschirmfliegen in Bosnien und Herzegowina");
        Author kilian = new Author();
        kilian.setFirstname("Kilian");
        kilian.setLastname("Althaus");
        Author unknown = new Author();
        unknown.setFirstname("Unknown");
        unknown.setLastname("Unknown");
//        blog1.setAuthor(kilian);
//        blog2.setAuthor(kilian);
//        blog3.setAuthor(kilian);
        blogService.addBlog(blog1);
        blogService.addBlog(blog2);
        blogService.addBlog(blog3);

//        authorService.addAuthor(kilian);
//        authorService.addAuthor(unknown);
    }
}