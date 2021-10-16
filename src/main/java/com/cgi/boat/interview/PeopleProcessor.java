package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Arrays;

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
        Map<String, List<String>> lastnamesByFirstnameMap = null;
        if(people != null && people.size() > 0)
        {
         lastnamesByFirstnameMap = new TreeMap<String, List<String>>();
         for(Person person:people)
            {
                if(person != null && person.getFirstName() != null)
                {
                    String firstName = person.getFirstName();
                    String lastName = person.getLastName();
                    List<String> namesList = lastnamesByFirstnameMap.get(firstName);
                if(namesList != null)
                {
                    namesList.add(lastName);
                }else
                {
                   namesList = new ArrayList<String>();
                   namesList.add(lastName);
                }
                    lastnamesByFirstnameMap.put(firstName, namesList);
                }
            }
        }
       
        return lastnamesByFirstnameMap;
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
       Map<String, List<String>> firstnamesByLastnameMap = null;
       if(people != null && people.size() > 0)
        {
            firstnamesByLastnameMap = new TreeMap<String, List<String>>();
            for(Person person:people)
            {
                if(person != null && person.getFirstName() != null)
                {
                    String firstName = person.getFirstName();
                    String lastName = person.getLastName();
                    List<String> namesList = firstnamesByLastnameMap.get(lastName);
                if(namesList != null)
                {
                    namesList.add(firstName);
                }else
                {
                   namesList = new ArrayList<String>();
                   namesList.add(firstName);
                }
                    firstnamesByLastnameMap.put(lastName, namesList);
                }
            }
        }
        return firstnamesByLastnameMap;
    }

}
