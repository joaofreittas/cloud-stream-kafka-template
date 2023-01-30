package com.templates.cloudstream.dataprovider.database.repository;

import com.templates.cloudstream.core.model.Person;

import java.util.List;

public interface PersonMemoryRepository {

    //TODO: change to entity model
    Person save(Person person);

    List<Person> findAll();

}
