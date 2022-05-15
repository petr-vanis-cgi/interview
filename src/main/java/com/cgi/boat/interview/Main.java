package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3

        Map<String,Long> firstNamesWithCount = PeopleSetup.people.stream()
                .collect(Collectors.groupingBy(x -> x.getFirstName(),Collectors.counting()));

        Map<String,Long> top3FirstNamesWithCount = firstNamesWithCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(x -> x.getKey(), x->x.getValue()));
        top3FirstNamesWithCount.entrySet().stream()
                .forEach(System.out::println);
    }







}
