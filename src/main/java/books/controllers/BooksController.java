package books.controllers;

import books.entities.Book;
import books.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BooksController {

    private BookServiceImpl bookService;

    @Autowired
    public BooksController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("listBooks", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBookInfo(@PathVariable int id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("bookInfo", book);
        return "bookInfo";
    }
}
