package br.com.teteu.api.gateway.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.teteu.api.gateway.model.Person;
import br.com.teteu.api.gateway.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;

   
    
    @RequestMapping(value = "/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPersonById(
        @PathVariable(value = "id")String id) throws Exception{
            return service.findPersonById(id);
        }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
            return service.findAll();
        }
    @RequestMapping(method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
        public Person createPerson(@RequestBody Person person){
            return service.create(person);
        }
    @RequestMapping(method = RequestMethod.PUT,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
        public Person updatePerson(@RequestBody Person person){
            return service.updatePerson(person);
        }
    @RequestMapping(method = RequestMethod.DELETE)
        public void delete(@PathVariable(value = "id")String id){
             service.deletePerson(id);
        }
}
