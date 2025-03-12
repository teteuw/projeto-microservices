package br.com.tteu.book_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tteu.book_service.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
