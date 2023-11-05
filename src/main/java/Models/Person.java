package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToOne(mappedBy ="passport")
    private Person person;

    public Person() {
    }

    public Person(long id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
