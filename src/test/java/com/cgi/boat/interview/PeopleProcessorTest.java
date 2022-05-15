package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class PeopleProcessorTest {

    List<Person> personList;

    @BeforeEach
    public void init() {
        this.personList = new ArrayList<>();
        personList.add(new Person("John", "Doe"));
        personList.add(new Person("John", "Silver"));
        personList.add(new Person("Peter", "Doe"));
    }

    @Test
    void lastnamesByFirstname() {
        /*
         * For input: ["John Doe", "John Silver", "Peter Doe"]
         * "John" -> ["Doe", "Silver"]
         * "Peter" -> ["Doe"]
         */

        Map<String, java.util.List<String>> result = PeopleProcessor.lastnamesByFirstname(personList);
        Assertions.assertTrue(result.containsKey("John"));
        Assertions.assertTrue(result.containsKey("Peter"));

        Assertions.assertEquals(2, result.get("John").size());
        Assertions.assertTrue(result.get("John").containsAll(new ArrayList<>(Arrays.asList("Doe", "Silver"))));

        Assertions.assertEquals(1, result.get("Peter").size());
        Assertions.assertTrue(result.get("Peter").containsAll(new ArrayList<>(Collections.singletonList("Doe"))));
    }

    @Test
    void firstnamesByLastname() {
        /*
         * For input: ["John Doe", "John Silver", "Peter Doe"]
         *      * "Doe" -> ["John", "Peter"]
         *      * "Silver" -> ["John"]
         */
        Map<String, java.util.List<String>> result = PeopleProcessor.firstnamesByLastname(personList);
        Assertions.assertTrue(result.containsKey("Doe"));
        Assertions.assertTrue(result.containsKey("Silver"));

        Assertions.assertEquals(2, result.get("Doe").size());
        Assertions.assertTrue(result.get("Doe").containsAll(new ArrayList<>(Arrays.asList("John", "Peter"))));

        Assertions.assertEquals(1, result.get("Silver").size());
        Assertions.assertTrue(result.get("Silver").containsAll(new ArrayList<>(Collections.singletonList("John"))));
    }

}
