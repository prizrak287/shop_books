package books.service;

import books.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    Book findBook(Integer id);
    void saveBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
}
