package Service;

import Models.Person;
import Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }
    public Person getPerson(Long id){
        Optional<Person> person = this.personRepository.findById(id);
        if (person.isPresent()){
            return person.get();
        }else {
            return null;
        }
    }
    public void addPerson(Person person){
        personRepository.save(person);
    }

    public void updatePerson(Long id, Person updatedPerson){
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            Person person = existingPerson.get();
            person.setName(updatedPerson.getName());
            personRepository.save(person);
        }
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
