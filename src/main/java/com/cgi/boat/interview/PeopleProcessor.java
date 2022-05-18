package com.cgi.boat.interview;

import java.util.*;

class PeopleProcessor {

    private PeopleProcessor() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns a {@link Map} where keys are first names and values lists of all last names
     * of people from the input list who have the first name
     * equal to the key.
     * <p>
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     * "John" -> ["Doe", "Silver"]
     * "Peter" -> ["Doe"]
     * }
     */
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
        Map<String, List<String>> ret = new HashMap<>();
        people.forEach(person -> {
            List<String> lastNames = ret.get(person.getFirstName());
            if (lastNames == null) {
                ret.put(person.getFirstName(), new ArrayList<>(Arrays.asList(person.getLastName())));
            } else {
                lastNames.add(person.getLastName());
            }
        });

        return ret;
    }


    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
     * returned is lastname -> firstnames
     * <p>
     * Example:
     * For input: ["John Doe", "John Silver", "Peter Doe"]
     * Expected result would be:
     * {
     * "Doe" -> ["John", "Peter"]
     * "Silver" -> ["John"]
     */
    static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
        Map<String, List<String>> ret = new HashMap<>();
        people.forEach(person -> {
            List<String> firstNames = ret.get(person.getLastName());
            if (firstNames == null) {
                ret.put(person.getLastName(), new ArrayList<>(Arrays.asList(person.getFirstName())));
            } else {
                firstNames.add(person.getFirstName());
            }
        });

        return ret;
    }

}
