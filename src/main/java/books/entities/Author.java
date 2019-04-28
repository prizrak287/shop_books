package books.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fio")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public Author() {}

    public Author(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        book.setAuthor(this);
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
       this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
       return "\nid = " + this.id +
               "\nname = " + this.name +
               "\nage = " + this.age +
               "\naddress = " + this.address;
    }
}
