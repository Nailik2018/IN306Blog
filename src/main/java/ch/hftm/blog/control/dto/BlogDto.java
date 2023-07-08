package ch.hftm.blog.control.dto;

import ch.hftm.blog.entity.Blog;

public interface BlogDto {

    public record NewBlogDto(String title, String content) {
        public Blog toBlog() {
            return new Blog(title, content);
        }

        public static NewBlogDto fromBlog(Blog blog) {
            return new NewBlogDto(blog.getTitle(), blog.getContent());
        }
    }
}
