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
        Map<String, Long> countByFirstname = getCountByFirstname(PeopleSetup.people);
        Map<String, Long> top3MostCommonFirstNameWithOccurrences = getTopFirstnames(countByFirstname);
    }

    static Map<String, Long> getCountByFirstname(List<Person> people) {
        return people.stream()
                     .collect(Collectors.groupingBy(
                             Person::getFirstName,
                             Collectors.counting()
                     ));
    }

    static Map<String, Long> getTopFirstnames(Map<String, Long> countByFirstname) {
        return countByFirstname.entrySet()
                               .stream()
                               .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                               .limit(3)
                               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
