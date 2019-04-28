package books.service;

import books.repository.AuthorDAO;
import books.entities.Author;
import books.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Lazy
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
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
        List<Author> authorsWithName = authorDAO.findByName(name);
        for (Author author: authorsWithName) {
            author.getBooks().iterator();
        }
        return authorsWithName;
    }

    public Author findAuthor(Integer id) {
        Author author = authorDAO.findById(id);
        author.getBooks().iterator();
        return author;
    }

    public void deleteAuthor(Author author) {
        authorDAO.delete(author);
    }

    public void updateAuthor(Author author) {
        authorDAO.update(author);
    }

    public void saveAuthor(Author author) {
        authorDAO.save(author);
    }
}
