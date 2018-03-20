package eu.tjago.db;

import eu.tjago.api.Person;

public class PeopleStore {
    public Person fetchPerson(String name) {
        return new Person(name, name + "@example.com");
    }
}
