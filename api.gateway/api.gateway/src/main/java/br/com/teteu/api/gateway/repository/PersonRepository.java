package br.com.teteu.api.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teteu.api.gateway.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
