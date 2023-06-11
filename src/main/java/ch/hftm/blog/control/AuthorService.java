package ch.hftm.blog.control;

import ch.hftm.blog.entity.Author;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;

import java.util.List;

@Dependent
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    Logger logger;

    public List<Author> getAuthors(){
        var authors = authorRepository.listAll();
        logger.info("Returning " + authors.size() + " Authors");
        return authors;
    }

    @Transactional
    public void addAuthor(Author author){
        logger.info("Adding author " + author.getFirstname() + " " + author.getLastname());
        authorRepository.persist(author);
    }
}
