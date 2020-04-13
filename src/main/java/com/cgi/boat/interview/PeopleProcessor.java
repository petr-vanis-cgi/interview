package com.cgi.boat.interview;

import java.util.*;

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
            if (resultMap.entrySet().stream().noneMatch(entry -> entry.getKey().equals(personInput.getFirstName()))) {
                resultMap.put(personInput.getFirstName(), new ArrayList<>(Collections.singletonList(personInput.getLastName())));
            } else {
                resultMap.get(personInput.getFirstName()).add(personInput.getLastName());
            }
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
            if (resultMap.entrySet().stream().noneMatch(entry -> entry.getKey().equals(personInput.getLastName()))) {
                resultMap.put(personInput.getLastName(), new ArrayList<>(Collections.singletonList(personInput.getFirstName())));
            } else {
                resultMap.get(personInput.getLastName()).add(personInput.getFirstName());
            }
        });

        return resultMap;
    }

}
