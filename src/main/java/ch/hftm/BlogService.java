package ch.hftm;

import java.util.List;

import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    @Inject
    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.getBlogs();
        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    @Transactional
    public void addBlog(Blog blog) {
        logger.info("Adding blog " + blog.getTitle());
        blogRepository.addBlog(blog);
    }

    public void listAll(){
        var blogs = blogRepository.listAll();
    }
}