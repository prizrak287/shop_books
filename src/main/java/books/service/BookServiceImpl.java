package books.service;

import books.entities.Book;
import books.repository.BooksDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Lazy
public class BookServiceImpl implements BookService{

    private BooksDAO booksDAO;

    @Autowired
    public BookServiceImpl(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }

    public List<Book> findAllBooks() {
        return booksDAO.findAll();
    }

    public Book findBook(Integer id) {
        return booksDAO.findById(id);
    }

    public void saveBook(Book book) {
        booksDAO.save(book);
    }

    public void updateBook(Book book) {
        booksDAO.update(book);
    }

    public void deleteBook(Book book) {
        booksDAO.delete(book);
    }
}
