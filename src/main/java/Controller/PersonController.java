package Controller;


import Models.Person;
import Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
    @GetMapping("/person/id")
    public Person getPersonById(@PathVariable long id){
        return personService.getPerson(id);
    }
    @PostMapping("/person")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @RequestMapping("/person/id")
    public void updatePerson(@PathVariable long id, @RequestBody Person person){
        personService.updatePerson(id,person);
    }

    @DeleteMapping("/person/id")
    public void deletePerson(@PathVariable long id){
        personService.deletePerson(id);
    }
}
