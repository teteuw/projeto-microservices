package br.com.teteu.api.gateway.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.teteu.api.gateway.exceptions.ResourceNotFoundException;
import br.com.teteu.api.gateway.model.Person;
import br.com.teteu.api.gateway.repository.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("finding persons");
    
        return repository.findAll();
    }
    public Person create (Person person){
        logger.info("creating one person");
        return repository.save(person);
    }
            
    public Person findPersonById(Long id){
        logger.info("finding a person");
       
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }
    public Person updatePerson(Person person){

        logger.info("updating one person");

        var entity = repository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records foud for this id"));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getAdress());

        return repository.save(person);
    }
    public void deletePerson(Long id){
        logger.info("deleting one person");

        repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.deleteById(id);;

    }

}
