package books.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private List<Author> authors;

    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "date_of_publish")
    private Date datePublishing;

    public Book() {}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Author> getAuthor() {
        return this.authors;
    }

    public void setAuthor(List<Author> authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return this.publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getDatePublishing() {
        return this.datePublishing;
    }

    public void setDatePublishing(Date datePublishing) {
        this.datePublishing = datePublishing;
    }

    @Override
    public String toString() {
        return "\nid = " + this.id +
                "\nname = " + this.name +
                "\nauthor + " + authors.toString();
    }

}
