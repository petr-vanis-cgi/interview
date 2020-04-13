package com.cgi.boat.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final int PRINTED_NAMES_COUNT = 3;

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstNamesByLastName(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastNamesByFirstName(PeopleSetup.people);

        lastByFirst.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size())
                ).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(PRINTED_NAMES_COUNT)
                .forEach(System.out::println);
    }
}
