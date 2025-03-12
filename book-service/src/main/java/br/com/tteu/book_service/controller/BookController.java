package br.com.tteu.book_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tteu.book_service.model.Book;
import br.com.tteu.book_service.repository.BookRepository;

@RestController
@RequestMapping("book-service")
public class BookController {
    
    @Autowired
    Environment environment;

    @Autowired
    BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(
        @PathVariable("id") Long id,
        @PathVariable("currency") String currency){

            var book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
            var port = environment.getProperty("local.server.port");
            book.setEnvironment(port);
            return book;
        }
    
}
