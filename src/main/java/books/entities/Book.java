package books.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

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
    private Author author;

    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "date_of_publish")
    private Date datePublishing;

    public Book() {}

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
                "\nauthor + " + author.toString();
    }

}
