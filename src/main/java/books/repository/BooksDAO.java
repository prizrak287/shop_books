package books.repository;

import books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDAO extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where b.name=:name")
    List<Book> findByName(@Param("name") String name);
}
