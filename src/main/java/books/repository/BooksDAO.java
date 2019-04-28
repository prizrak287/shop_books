package books.repository;

import books.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public BooksDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Book.class).list();
    }

    public Book findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(book);
        trans.commit();
        session.close();
    }

    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.update(book);
        trans.commit();
        session.close();
    }

    public void delete(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(book);
        trans.commit();
        session.close();
    }
}
