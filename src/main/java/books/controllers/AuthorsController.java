package books.controllers;

import books.entities.Author;
import books.service.AuthorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class AuthorsController {

    private final AuthorServiceImpl authorService;

    public AuthorsController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
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

    @GetMapping("/authors")
    public String getAuthor(@RequestParam("id")Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        model.addAttribute("authorInfo", author);
        return "authorInfo";
    }

    @GetMapping("/authorSearch")
    public String getAuthors(@RequestParam("author_name") String name, Model model) {
        List<Author> authors = authorService.findAuthorsByName(name);
        authors.sort(Comparator.comparing(Author::getName));
        model.addAttribute("listAuthors", authors);
        return "authors";
    }

    @PostMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id")Integer id, Model model) {
        Author author = authorService.findAuthor(id);
        authorService.deleteAuthor(author);
        model.addAttribute("deleted", author.getName());
        model.addAttribute("entity", "Author");
        return "deleted";
    }

   /* @PostMapping(value = "/addauthor", consumes = "application/json;charset=utf-8")
    public @ResponseBody String addAuthor(@RequestBody Author author, Model model) {

        return "ok";
    }*/
}
