package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PeopleProcessor {
    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names
     * of people from the input list who have the first name
     * equal to the key.
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "John" -> ["Doe", "Silver"]
     *  "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String>> lastNamesByFirstName(List<Person> people){
        Map<String, List<String>> resultMap = new HashMap<>();
        people.forEach(personInput -> {
            resultMap.put(personInput.getFirstName(), new ArrayList<>());
            people.forEach(personCurrent -> {
                if (personCurrent.getFirstName().equals(personInput.getFirstName())) {
                    resultMap.get(personCurrent.getFirstName()).add(personCurrent.getLastName());
                }
            });
        });

        return resultMap;
    }


    /**
     * Same as {@link PeopleProcessor#lastNamesByFirstName} except that the mapping
     * returned is lastname -> firstnames
     *
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     *  "Doe" -> ["John", "Peter"]
     *  "Silver" -> ["John"]
     *
     */
    static Map<String, List<String>> firstNamesByLastName(List<Person> people){
        Map<String, List<String>> resultMap = new HashMap<>();
        people.forEach(personInput -> {
            resultMap.put(personInput.getLastName(), new ArrayList<>());
            people.forEach(personCurrent -> {
                if (personCurrent.getLastName().equals(personInput.getLastName())) {
                    resultMap.get(personCurrent.getLastName()).add(personCurrent.getFirstName());
                }
            });
        });

        return resultMap;
    }

}
