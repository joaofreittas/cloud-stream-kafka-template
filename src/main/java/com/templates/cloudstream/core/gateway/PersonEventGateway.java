package com.templates.cloudstream.core.gateway;

import com.templates.cloudstream.core.model.Person;

public interface PersonEventGateway {

    void sendEventPersonWasCreated(Person person);

}
