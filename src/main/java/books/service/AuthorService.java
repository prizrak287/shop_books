package books.service;

import books.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    List<Author> findAuthorByName(String name);
    Author findAuthor(Integer id);
    void saveAuthor(Author author);
    void deleteAuthor(Author author);
}
