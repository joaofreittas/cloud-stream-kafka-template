package com.templates.cloudstream.core.usecase.impl;

import com.templates.cloudstream.core.gateway.PersonEventGateway;
import com.templates.cloudstream.core.gateway.PersonDataGateway;
import com.templates.cloudstream.core.model.Person;
import com.templates.cloudstream.core.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonUseCaseImpl implements PersonUseCase {

    private final PersonDataGateway personDataGateway;
    private final PersonEventGateway personEventGateway;

    @Override
    public void create(final Person person) {
        var personCreated = personDataGateway.saveNewPerson(person);
        personEventGateway.sendEventPersonWasCreated(personCreated);
    }

}
