package books.controllers;

import books.entities.Book;
import books.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class BooksController {

    private BookServiceImpl bookService;

    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/all")
    public String getBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        books.sort(Comparator.comparing(Book::getName));
        model.addAttribute("listBooks", books);
        return "books";
    }

    @GetMapping("/books/info")
    public String getBookInfo(@RequestParam("id") int id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("bookInfo", book);
        return "bookInfo";
    }

    @GetMapping("/books/search")
    public String getBooks(@RequestParam("book_name") String name, Model model) {
        List<Book> books = bookService.findBookByName(name);
        books.sort(Comparator.comparing(Book::getName));
        model.addAttribute("listBooks", books);
        return "books";
    }

    @PostMapping("/books/delete")
    public String deleteBook(@RequestParam("id") Integer id, Model model) {
        Book book = bookService.findBook(id);
        bookService.deleteBook(book);
        model.addAttribute("deleted", book.getName());
        model.addAttribute("entity", "Book");
        return "deleted";
    }
}
