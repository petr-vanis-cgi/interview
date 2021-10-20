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
        Map<String, List<String>> result = new HashMap<>();
        for (Person p : people) {
            if (!result.containsKey(p.getFirstName())) {
                result.put(p.getFirstName(), new ArrayList<String>());
            }
        }

        for (Person p : people) {
            result.get(p.getFirstName()).add(p.getLastName());
        }

        return result;

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

        Map<String, List<String>> result = new HashMap<>();
        for (Person p : people) {
            if (!result.containsKey(p.getLastName())) {
                result.put(p.getLastName(), new ArrayList<String>());
            }
        }

        for (Person p : people) {
            result.get(p.getLastName()).add(p.getLastName());
        }

        return result;

    }

}
