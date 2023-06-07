package ch.hftm.blog.control;

import java.util.List;

import ch.hftm.blog.entity.Blog;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    @Inject
    AuthorRepository authorRepository;

    @Inject
//    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
//        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    @Transactional
    public void addBlog(Blog blog) {
//        logger.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }
}