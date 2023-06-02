package ch.hftm.author.control;

import ch.hftm.author.entry.Author;
import ch.hftm.blog.control.BlogRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository {

    private List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        var blogs = new BlogRepository();
        authors.add(new Author("Kilian", "Althaus", blogs.getBlogs()));
        authors.add(new Author("Das", "Fantom", blogs.getBlogs()));
    }

    public List <Author> getAuthors(){
        return authors;
    }

    public void addAuthor(Author author){
        authors.add(author);
    }
}
