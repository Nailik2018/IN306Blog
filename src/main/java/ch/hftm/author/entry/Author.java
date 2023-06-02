package ch.hftm.author.entry;

import ch.hftm.blog.entity.Blog;

import java.util.List;

public class Author {
    private String firstname;
    private String lastname;
    private List<Blog> blogs;

    public Author(){
    }

    public Author(String firstname, String lastname, List<Blog> blogs) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.blogs = blogs;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
