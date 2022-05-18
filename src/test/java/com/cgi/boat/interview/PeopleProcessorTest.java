package com.cgi.boat.interview;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PeopleProcessorTest {

    @Test
    void lastnamesByFirstnameTest() {
        Map<String, List<String>> testMap = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        assertNotNull(testMap);
        assertEquals(305, testMap.size());
        List<String> lastNames = testMap.get("Lee");
        assertNotNull(lastNames);
        assertEquals(2, lastNames.size());
        assertTrue(lastNames.contains("Boardman"));
        assertTrue(lastNames.contains("Evans"));
    }

    @Test
    void firstnamesByLastnameTest() {
        Map<String, List<String>> testMap = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        assertNotNull(testMap);
        assertEquals(540, testMap.size());
        List<String> lastNames = testMap.get("Cavill");
        assertNotNull(lastNames);
        assertEquals(1, lastNames.size());
        assertTrue(lastNames.contains("Henry"));
    }

}