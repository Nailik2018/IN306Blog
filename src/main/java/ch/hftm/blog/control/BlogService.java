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
    Logger logger;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        logger.info("Alle Blogs " + blogs.size() + " blogs");
        return blogs;
    }

    public Blog getBlogById(Long id) {
        return (Blog) blogRepository.findById(id);
    }

    @Transactional
    public void addBlog(Blog blog) {
        logger.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public void updateBlog(Blog blog) {
        blogRepository.persist(blog);
        logger.info("Update Blog: " + blog.getId());
    }

    @Transactional
    public void deleteBlog(Long id) {
        Blog blog = (Blog) blogRepository.findById(id);
        if (blog != null) {
            blogRepository.delete(blog);
            logger.info("Lösche Blog: " + id);
        }
    }
}