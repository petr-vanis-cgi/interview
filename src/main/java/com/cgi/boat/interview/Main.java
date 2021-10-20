package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;

public class Main {

    public class ResultClass {

    }
    public static void main(String[] args) {
        Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
        Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

        // TODO: Print out 3 most common first names along with number of occurrences
        // for example:
        // Homer: 32
        // Bart: 21
        // William: 3

        Result res = new Result();

        for (String key : lastByFirst.keySet()) {
            res.newValue(new ResultItem(key, lastByFirst.get(key).size()));
        }
        System.out.println("3 most common first names along with number of occurrences: \n"+res.toString());

    }


}
