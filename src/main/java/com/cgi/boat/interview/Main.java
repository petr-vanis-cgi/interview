package com.cgi.boat.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        List<Integer> numsOfOccurrences = new LinkedList<>();

        String firstName = "a";
        String firstName1 = "b";
        String firstName2 = "c";

        for (Map.Entry<String, List<String>> entry : lastByFirst.entrySet()){
            List<String> value = entry.getValue();
            numsOfOccurrences.add(value.size());
        }

        numsOfOccurrences.sort(null);

        List<Integer> lastThree = numsOfOccurrences.subList(Math.max(numsOfOccurrences.size() - 3, 0), numsOfOccurrences.size());

        for (Map.Entry<String, List<String>> entry : lastByFirst.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();

            if (value.size() == lastThree.get(0) && ((!firstName.equals(firstName1)) && (!firstName.equals(firstName2))))
                firstName2 = key;

            if (value.size() == lastThree.get(1) && ((!firstName1.equals(firstName)) && (!firstName.equals(firstName2))))
                firstName1 = key;

            if (value.size() == lastThree.get(2) && ((!firstName2.equals(firstName)) && (!firstName.equals(firstName1))))
                firstName = key;
        }

        System.out.println(firstName + ": " + lastThree.get(2));
        System.out.println(firstName1 + ": " + lastThree.get(1));
        System.out.println(firstName2 + ": " + lastThree.get(0));
    }
}

