package books.repository;

import books.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer> {
    @Query("select a from Author a where a.name = :name")
    List<Author> findByName(@Param("name") String name);

    @Query(value = "select * from authors limit :count", nativeQuery = true)
    List<Author> findFirst(@Param("count")Integer limit);
}
