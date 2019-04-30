package books.service;

import books.entities.Book;
import books.repository.BooksDAO;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Lazy
public class BookServiceImpl implements BookService{

    private BooksDAO booksDAO;

    public BookServiceImpl(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    public List<Book> findAllBooks() {
        return booksDAO.findAll();
    }

    public List<Book> findBookByName(String name) {
       return booksDAO.findByName(name);
    }

    public Book findBook(Integer id) {
        Optional<Book> bookOpt = booksDAO.findById(id);
        return bookOpt.orElse(new Book());
    }

    public void saveBook(Book book) {
        booksDAO.save(book);
    }

    public void deleteBook(Book book) {
        booksDAO.delete(book);
    }
}
