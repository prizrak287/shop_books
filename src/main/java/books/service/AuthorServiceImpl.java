package books.service;

import books.entities.Author;
import books.repository.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Lazy
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(@Autowired final AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public List<Author> findAllAuthors() {
        List<Author> authors = authorDAO.findAll();
        for (Author author: authors) {
            author.getBooks().iterator();
        }
        return authors;
    }
    public List<Author> findAuthorByName(String name) {
        List<Author> authors = authorDAO.findByName(name);
        for(Author author: authors) {
            author.getBooks().iterator();
        }
        return authors;
    }

    public Author findAuthor(Integer id) {
        Optional<Author> authorOpt = authorDAO.findById(id);
        Author author = authorOpt.orElse(new Author());
        author.getBooks().iterator();
        return author;
    }

    public void deleteAuthor(Author author) {
        authorDAO.delete(author);
    }

    public void saveAuthor(Author author) {
        authorDAO.save(author);
    }
}
