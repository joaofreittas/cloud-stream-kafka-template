package com.templates.cloudstream.dataprovider.database.gateway;

import com.templates.cloudstream.core.gateway.PersonDataGateway;
import com.templates.cloudstream.core.model.Person;
import com.templates.cloudstream.dataprovider.database.repository.PersonMemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonDataGatewayImpl implements PersonDataGateway {

    private final PersonMemoryRepository repository;

    @Override
    public Person saveNewPerson(final Person person) {
        return repository.save(person);
    }

}
