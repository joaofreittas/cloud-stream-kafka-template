package com.templates.cloudstream.entrypoint.web.api;

import com.templates.cloudstream.entrypoint.web.api.facade.PersonControllerFacade;
import com.templates.cloudstream.entrypoint.web.api.payloads.PersonPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonControllerFacade facade;

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody PersonPayload payload) {
        facade.createPerson(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
