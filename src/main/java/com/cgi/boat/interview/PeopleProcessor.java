package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        return people.stream()
                     .collect(Collectors.toMap(Person::getFirstName,
                             p -> new ArrayList<>(Arrays.asList(p.getLastName())),
                             PeopleProcessor::mergeLists));
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
        return people.stream()
                     .collect(Collectors.toMap(Person::getLastName,
                             p -> new ArrayList<>(Arrays.asList(p.getFirstName())),
                             PeopleProcessor::mergeLists));
    }

    private static List<String> mergeLists(List<String> baseList, List<String> newList) {
        baseList.addAll(newList);
        return baseList;
    }

}
