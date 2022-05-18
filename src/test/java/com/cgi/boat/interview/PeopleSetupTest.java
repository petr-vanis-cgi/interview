package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeopleSetupTest {

    @Test
    public void peopleTest() {
        assertEquals(587, PeopleSetup.people.size());
        assertTrue(PeopleSetup.people.stream().filter(person -> "Paul".equals(person.getFirstName())).anyMatch(person -> "Antony-Barber".equals(person.getLastName())));
        assertTrue(PeopleSetup.people.stream().filter(person -> "Richard".equals(person.getFirstName())).anyMatch(person -> "Beaumont".equals(person.getLastName())));
    }
}