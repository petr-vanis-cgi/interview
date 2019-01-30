package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
        Map<String, Long> firstNamesByOccurence = PeopleProcessor.firstnamesByOccurence(PeopleSetup.people);
        List<String> top3FirstNames = CollectionUtil.convertTopResultsToList(firstNamesByOccurence, 3);
        top3FirstNames.forEach(name -> System.out.println(name));
    }


}
