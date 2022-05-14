package com.cgi.boat.interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people){
        Map<String, List<String>> mapOfLastNamesByFirstName = new HashMap<>();
        for(Person person : people) {
            List<String> lastNamesWithRelatesFirstNames = people.stream()
                    .filter(x -> x.getFirstName().equalsIgnoreCase(person.getFirstName()))
                    .map(x -> x.getLastName())
                    .collect(Collectors.toList());
            mapOfLastNamesByFirstName.put(person.getFirstName(),lastNamesWithRelatesFirstNames);
        }
        return mapOfLastNamesByFirstName;
    }


    /**
     * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
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
    static Map<String, List<String>> firstnamesByLastname(List<Person> people){
        Map<String, List<String>> mapOfFirstNamesByLastName = new HashMap<>();
        for(Person person : people) {
            List<String> firstNamesWithRelatesLastNames = people.stream()
                    .filter(x -> x.getLastName().equalsIgnoreCase(person.getLastName()))
                    .map(x -> x.getFirstName())
                    .collect(Collectors.toList());
            mapOfFirstNamesByLastName.put(person.getLastName(),firstNamesWithRelatesLastNames);
        }
        return mapOfFirstNamesByLastName;
    }

}
