package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3
        Map<String, Integer> sizemap = new TreeMap<String, Integer>();
        for(Person person:PeopleSetup.people)
       {
        //System.out.println(person.getLastName()+"->"+firstByLast.get(person.getLastName()));
        //System.out.println(person.getFirstName()+"->"+lastByFirst.get(person.getFirstName()));
        sizemap.put(person.getFirstName(),lastByFirst.get(person.getFirstName()).size());
       }    
       sizemap.entrySet()
           .stream()
           .sorted(Map.Entry.<String, Integer>comparingByValue()
           .reversed()).limit(3)
           .forEach(System.out::println);   
    }







}
