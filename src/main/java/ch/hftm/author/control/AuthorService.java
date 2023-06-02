package ch.hftm.author.control;

import ch.hftm.author.control.AuthorRepository;
import ch.hftm.author.entry.Author;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Dependent
public class AuthorService {

    @Inject
    AuthorRepository authorRepository;

    @Inject
    Logger logger;

    public List<Author> getAuthors(){
        var authors = authorRepository.getAuthors();
        logger.info("Returning " + authors.size() + " Authors");
        return authors;
    }

    @Transactional
    public void addAuthor(Author author){
        logger.info("Adding author " + author.getFirstname() + " " + author.getLastname());
        authorRepository.addAuthor(author);
    }

    public void listAll(){
        var authors = authorRepository.listAll();
    }
}
