package books.service;

import books.entities.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    List<Author> findAuthorsByName(String name);
    List<Author> findFirst(Integer count);
    Author findAuthor(Integer id);
    void saveAuthor(Author author);
    void deleteAuthor(Author author);
}
