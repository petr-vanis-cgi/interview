package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PeopleProcessor {

	/**
	 * Returns a {@link Map} where keys are first names and values lists of all last
	 * names of people from the input list who have the first name equal to the key.
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "John" -> ["Doe", "Silver"] "Peter" -> ["Doe"] }
	 */

	static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
		// TODO: implement

		Map<String, List<String>> lastNames = new HashMap<>();

		for (Person temp : people) {
			if (lastNames.get(temp.getFirstName()) == null) {
				lastNames.put(temp.getFirstName(), new ArrayList<>());
			}
			lastNames.get(temp.getFirstName()).add(temp.getLastName());
		}
		return lastNames;
	}

	/**
	 * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
	 * returned is lastname -> firstnames
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "Doe" -> ["John", "Peter"] "Silver" -> ["John"]
	 *
	 */
	static Map<String, List<String>> firstnamesByLastname(List<Person> people) {
		// TODO: implement

		Map<String, List<String>> firstNames = new HashMap<>();

		for (Person temp : people) {
			if (firstNames.get(temp.getLastName()) == null) {
				firstNames.put(temp.getLastName(), new ArrayList<>());
			}
			firstNames.get(temp.getLastName()).add(temp.getFirstName());
		}
		return firstNames;
	}
}
