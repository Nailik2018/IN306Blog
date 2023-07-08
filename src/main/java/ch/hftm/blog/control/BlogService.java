package ch.hftm.blog.control;

import java.util.List;

import ch.hftm.blog.control.dto.BlogDto;
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
        logger.info("Alle Blogs: " + blogs.size() + " blogs");
        return blogs;
    }

    public Blog getBlogById(Long id) {
        return (Blog) blogRepository.findById(id);
    }

    public List<Blog> findBlogs(String search) {
        var blogs = blogRepository.find("title like ?1 or content like ?1", "%" + search + "%").list();
        logger.info("Gefunden " + blogs.size() + " Anzahl Blogs");
        return blogs;
    }

    @Transactional
    public void addBlog(Blog blog) {
        logger.info("Blog hinzufügen: " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public long addBlogDto(BlogDto.NewBlogDto newBlogDto) {
        logger.info("Blog hinzufügen: " + newBlogDto.title());
        // Mapping von BlogDtos.NewBlogDto zu Blog
        var blog = newBlogDto.toBlog();
        blogRepository.persist(newBlogDto.toBlog());
        return blog.getId();
    }

    @Transactional
    public void updateBlog(Blog blog) {
        blogRepository.persist(blog);
        logger.info("Blog updaten: " + blog.getId());
    }

    @Transactional
    public void deleteBlog(Long id) {
        Blog blog = (Blog) blogRepository.findById(id);
        if (blog != null) {
            blogRepository.delete(blog);
            logger.info("Blog löschen: " + id);
        }
    }
}