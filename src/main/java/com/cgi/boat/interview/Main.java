package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class Main {

	public static void main(String[] args) {
		Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
		Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);

////	   System.out.println("OriginalForTest");
////    	for(int i = 0; i < PeopleSetup.people.size(); i++) {
////            System.out.println(PeopleSetup.people.get(i).getFirstName()+ " " + PeopleSetup.people.get(i).getLastName());
////				}
		System.out.println("NamesGroups");
		firstByLast.forEach((k, v) -> System.out.println(k + "\t->\t" + v));
		lastByFirst.forEach((k, v) -> System.out.println(k + "\t->\t" + v));

////		System.out.println("Searchname");
////		PeopleProcessor.searchName(firstByLast);
		// TODO: Print out 3 most common first names along with number of occurrences
		// for example:
		// Homer: 32
		// Bart: 21
		// William: 3
//		System.out.println("Largest occurrency of Name");
//		PeopleProcessor.sortByValueSize(firstByLast)
//				.forEach((k, v) -> System.out.println(k + ": " + v.size() + "\t->\t" + v));
PeopleProcessor.sortByValueSizeTop3(firstByLast);
	}
}
