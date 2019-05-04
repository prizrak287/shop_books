package books.controllers;

import books.entities.Author;
import books.entities.Book;
import books.service.AuthorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AuthorsController {

    private final AuthorServiceImpl authorService;

    public AuthorsController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String getIndex(Model model) throws ParseException {
        List<Author> authors = authorService.findFirst(5);
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "index";
    }

    @GetMapping("/authors/all")
    public String getAuthors(Model model) {
        List<Author> authors = authorService.findAllAuthors();
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "authors";
    }

    @GetMapping("/authors/info")
    public String getAuthor(@RequestParam("id")Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        model.addAttribute("authorInfo", author);
        return "authorInfo";
    }

    @GetMapping("/authors/search")
    public String getAuthors(@RequestParam("author_name") String name, Model model) {
        List<Author> authors = authorService.findAuthorsByName(name);
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "authors";
    }

    @PostMapping("/authors/delete")
    public String deleteAuthor(@RequestParam("id")Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        authorService.deleteAuthor(author);
        model.addAttribute("deleted", author.getName());
        model.addAttribute("entity", "Author");
        return "deleted";
    }

    @PostMapping("/authors/add")
    public String addAuthor(
            @RequestParam("author_name") String authorName,
            @RequestParam("age") Integer age,
            @RequestParam("address") String address,
            @RequestParam("book_name") String bookName,
            @RequestParam("publishingHouse") String publishingHouse,
            @RequestParam("datePublishing") String datePublishing,
            Model model) throws ParseException {
        Author author = new Author();
        author.setName(authorName);
        author.setAge(age);
        author.setAddress(address);

        Book book = new Book();
        book.setName(bookName);
        book.setPublishingHouse(publishingHouse);

        DateFormat f = new SimpleDateFormat("dd.mm.yyyy", Locale.ENGLISH);
        Timestamp ts = new Timestamp(f.parse(datePublishing).getTime());
        book.setDatePublishing(ts);

        List<Book> books = new ArrayList<>();
        books.add(book);
        author.setBooks(books);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        book.setAuthors(authors);
        authorService.saveAuthor(author);
        model.addAttribute("authorName", authorName);
        return "add";
    }
}
