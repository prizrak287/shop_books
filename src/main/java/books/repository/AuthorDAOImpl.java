/*
package books.repository;

import books.entities.Author;
import books.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AuthorDAOImpl {
    private SessionFactory sessionFactory;

    @Autowired
    public AuthorDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Author> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Author.class).list();
    }

    public List<Author> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        cq.select(root).where(cb.equal(root.get("name"), name));
        Query<Author> query = session.createQuery(cq);
        return query.getResultList();
    }

    public Author findById(Integer id) {
        return sessionFactory.getCurrentSession().get(Author.class, id);
    }

    public void save(Author author) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.save(author);
        trans.commit();
        session.close();
    }


    public void update(Author author) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
        session.close();
    }

    public void delete(Author author) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.delete(author);
        trans.commit();
        session.close();
    }
}
*/
