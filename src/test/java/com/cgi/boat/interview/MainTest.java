package com.cgi.boat.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MainTest {

    @Test
    void getCountByFirstname() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Teela", "Tan"));
        people.add(new Person("Teela", "Schneider"));
        people.add(new Person("Freda", "Schneider"));

        Map<String, Long> countByFirstname = Main.getCountByFirstname(people);
        Assertions.assertEquals(2, countByFirstname.get("Teela"));
        Assertions.assertEquals(1, countByFirstname.get("Freda"));
    }

    @Test
    void getTopFirstnames() {
        Map<String, Long> occurrenceMap = new HashMap<>();
        occurrenceMap.put("A", 1L);
        occurrenceMap.put("B", 2L);
        occurrenceMap.put("C", 3L);
        occurrenceMap.put("D", 4L);
        occurrenceMap.put("E", 5L);
        Map<String, Long> topFirstnames = Main.getTopFirstnames(occurrenceMap);
        Assertions.assertEquals(3, topFirstnames.size());
        Assertions.assertTrue(topFirstnames.containsKey("C"));
        Assertions.assertTrue(topFirstnames.containsKey("D"));
        Assertions.assertTrue(topFirstnames.containsKey("E"));
    }

}
