package books.controllers;

import books.entities.Author;
import books.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorsController {

    private final AuthorServiceImpl authorService;

    @Autowired
    public AuthorsController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            authors.add(authorService.findAuthor(i + 1));
        }
        model.addAttribute("listAuthors", authors);
        return "index";
    }

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        List<Author> authors = authorService.findAllAuthors();
        model.addAttribute("listAuthors", authors);
        return "authors";
    }

    @GetMapping("/authors/{id}")
    public String getAuthor(@PathVariable int id, Model model) {
        Author author = authorService.findAuthor(id);
        model.addAttribute("authorInfo", author);
        return "authorInfo";
    }
}
