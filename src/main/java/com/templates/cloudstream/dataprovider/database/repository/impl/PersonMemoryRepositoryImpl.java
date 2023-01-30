package com.templates.cloudstream.dataprovider.database.repository.impl;

import com.templates.cloudstream.core.model.Person;
import com.templates.cloudstream.dataprovider.database.repository.PersonMemoryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class PersonMemoryRepositoryImpl implements PersonMemoryRepository {

    private List<Person> databasePersons = new ArrayList<>();

    @Override
    public Person save(final Person person) {
        person.setId(UUID.randomUUID().toString());
        databasePersons.add(person);

        return person;
    }

    @Override
    public List<Person> findAll() {
        return databasePersons;
    }

}
