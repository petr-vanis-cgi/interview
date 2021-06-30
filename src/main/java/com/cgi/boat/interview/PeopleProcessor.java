package com.cgi.boat.interview;

import java.util.HashMap;
import java.util.LinkedList;
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
    static Map<String, List<String>> lastnamesByFirstname(List<Person> people){
        Map<String, List<String>> lastsByFirst = new HashMap<>();
        List<String> firstNames = new LinkedList<>();

        String firstName = "";
        String lastName = "";

        for (int i = 0; i < people.size(); i++){
            firstName = people.get(i).getFirstName();
            lastName = people.get(i).getLastName();

            if (!firstNames.contains(firstName)) { //first name for the first time
                firstNames.add(firstName);
                List<String> listForLastNames = new LinkedList<>();
                listForLastNames.add(lastName);
                lastsByFirst.put(firstName, listForLastNames);
            }
            else
                lastsByFirst.get(firstName).add(lastName);
        }
        return lastsByFirst;
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
        Map<String, List<String>> firstsByLast = new HashMap<>();
        List<String> lastNames = new LinkedList<>();

        String firstName = "";
        String lastName = "";

        for (int i = 0; i < people.size(); i++){
            firstName = people.get(i).getFirstName();
            lastName = people.get(i).getLastName();

            if (!lastNames.contains(lastName)) { //last name for the first time
                lastNames.add(lastName);
                List<String> listForFirstNames = new LinkedList<>();
                listForFirstNames.add(firstName);
                firstsByLast.put(lastName, listForFirstNames);
            }
            else
                firstsByLast.get(lastName).add(firstName);
        }
        return firstsByLast;
    }

}

