package br.com.tteu.book_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.HashMap;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.tteu.book_service.model.Book;
import br.com.tteu.book_service.repository.BookRepository;
import br.com.tteu.book_service.response.Cambio;

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

            HashMap<String, String> params = new HashMap<>();
            params.put("amount", book.getPrice().toString());
            params.put("from", "USD");
            params.put("to", currency);

            var response = new RestTemplate()
            .getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}"
                , Cambio.class, 
                    params);

            var cambio = response.getBody();
            
            book.setEnvironment(port);
            book.setPrice(cambio.getConversionValue());

            return book;
        }
    
}
