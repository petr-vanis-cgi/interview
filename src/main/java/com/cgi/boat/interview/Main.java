package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, List<String>> firstByLast = PeopleProcessor.firstnamesByLastname(PeopleSetup.people);
		System.out.println(firstByLast);

		Map<String, List<String>> lastByFirst = PeopleProcessor.lastnamesByFirstname(PeopleSetup.people);
		System.out.println(lastByFirst);

		// TODO: Print out 3 most common first names along with number of occurrences
		// for example:
		// Homer: 32
		// Bart: 21
		// William: 3

		List<String> result = compare(PeopleSetup.people);
		System.out.println("\nMost common names: ");
		for (String s : result) {
			System.out.println(s);
		}
	}

	static List<String> compare(List<Person> people) { // Method for 3 most common names
		Map<String, Integer> count = new HashMap<>();

		for (Person temp : people) {

			if (!count.containsKey(temp.getFirstName())) {
				count.put(temp.getFirstName(), 1);
			} else {
				int value = count.get(temp.getFirstName());
				value++;
				count.put(temp.getFirstName(), value);
			}
		}

		List<String> mostCommons = new ArrayList<>();

		for (int i = 0; i <= 2; i++) { // 3 times because we need 3 most common names //THIS AFFECTS THE NUMBER OF
										// COMMON NAMES (i <= 2)
			for (Map.Entry<String, Integer> e : count.entrySet()) {

				if (e.getValue() == Collections.max(count.values())) {

					mostCommons.add(e.getKey() + ": " + e.getValue());
					count.computeIfPresent(e.getKey(), (k, v) -> v - e.getValue()); // changing the max value to zero so
																					// it can't be found and added again
					break; // break the for loop to start again to find the second and 3rd most common name
				}
			}
		}
		return mostCommons;
	}
}
