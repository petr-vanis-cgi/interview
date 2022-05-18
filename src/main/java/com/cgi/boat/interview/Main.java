package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        listFirstNFavorits(lastByFirst, 3);
    }

    private static void listFirstNFavorits(Map<String, List<String>> list, int n) {
        list
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
                .limit(n)
                .forEach(Main::printFavorit);
    }

    private static void printFavorit(Map.Entry<String, List<String>> person) {
        System.out.println(person.getKey() + ": " + person.getValue().size());
    }

}
