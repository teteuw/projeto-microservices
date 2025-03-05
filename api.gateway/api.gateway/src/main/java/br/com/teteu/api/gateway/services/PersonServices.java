package br.com.teteu.api.gateway.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.teteu.api.gateway.model.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("finding persons");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
            }
        return persons;
    }
    public Person create (Person person){
        logger.info("creating one person");
        return person;
    }
            
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Peron Name" + i);
        person.setLastName("Last Name" + i);
        person.setAdress("Uberlândia");
        person.setGender("Male");
        return person;
    }
            
    public Person findPersonById(String id){
        logger.info("finding a person");
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAdress("Uberlândia");
        person.setGender("Male");
        return person;
    }
    public Person updatePerson(Person person){
        logger.info("updating one person");
        return person;
    }
    public void deletePerson(String id){
        logger.info("deleting one person");
    }

}
