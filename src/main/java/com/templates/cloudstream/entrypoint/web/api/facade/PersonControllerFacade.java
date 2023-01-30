package com.templates.cloudstream.entrypoint.web.api.facade;

import com.templates.cloudstream.core.model.Person;
import com.templates.cloudstream.core.usecase.PersonUseCase;
import com.templates.cloudstream.entrypoint.web.api.payloads.PersonPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonControllerFacade {

    private final PersonUseCase personUseCase;

    public void createPerson(PersonPayload payload) {
        personUseCase.create(Person.builder()
                .name(payload.getName())
                .documentNumber(payload.getDocumentNumber())
            .build());
    }

}
