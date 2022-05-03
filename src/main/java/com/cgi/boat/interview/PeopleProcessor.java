package com.cgi.boat.interview;

import java.util.Map;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

class PeopleProcessor {
	/**
	 * Returns a {@link Map} where keys are first names and values lists of all last
	 * names of people from the input list who have the first name equal to the key.
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "John" -> ["Doe", "Silver"] "Peter" -> ["Doe"] }
	 */
	static Map<String, List<String>> firstnamesByLastname(List<Person> people) {

		Map<String, List<String>> firstnamesByLast = new HashMap<String, List<String>>();
		for (Person p : people) {
			if (!firstnamesByLast.containsKey(p.getFirstName())) {
				firstnamesByLast.put(p.getFirstName(), new ArrayList<String>());
			}
			firstnamesByLast.get(p.getFirstName()).add(p.getLastName());
		}
		return firstnamesByLast;
	}

	/**
	 * Same as {@link PeopleProcessor#lastnamesByFirstname} except that the mapping
	 * returned is lastname -> firstnames
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "Doe" -> ["John", "Peter"] "Silver" -> ["John"]
	 *
	 */
	static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
		Map<String, List<String>> lastnamesByFirst = new HashMap<String, List<String>>();
		for (Person p : people) {
			if (!lastnamesByFirst.containsKey(p.getLastName())) {
				lastnamesByFirst.put(p.getLastName(), new ArrayList<String>());
			}
			lastnamesByFirst.get(p.getLastName()).add(p.getFirstName());
		}
		return lastnamesByFirst;
	}

	static void searchName(Map<String, List<String>> firstByLast) {
		System.out.println("Zadej  křestní jméno ze seznamu, a vyjedete ti počet ruzných příjmení:");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println(name + "\t->\t" + firstByLast.get(name).size() + "\t->\t" + firstByLast.get(name));
		sc.close();
	}

	static Map<String, List<String>> sortByValueSize(Map<String, List<String>> firstByLast) {
		List<HashMap.Entry<String, List<String>>> nameOccurency = new LinkedList<>(firstByLast.entrySet());

		nameOccurency.sort(Comparator.comparingInt((o) -> o.getValue().size()));
		Collections.reverse(nameOccurency);

		HashMap<String, List<String>> sortedMap = new LinkedHashMap<>();
		for (HashMap.Entry<String, List<String>> entry : nameOccurency) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	static void sortByValueSizeTop3(Map<String, List<String>> firstByLast) {
		List<HashMap.Entry<String, List<String>>> nameOccurency = new LinkedList<>(firstByLast.entrySet());

		nameOccurency.sort(Comparator.comparingInt((o) -> o.getValue().size()));
		Collections.reverse(nameOccurency);

		HashMap<String, List<String>> sortedMap = new LinkedHashMap<>();
		int i = 0;

		for (HashMap.Entry<String, List<String>> entry : nameOccurency) {
			sortedMap.put(entry.getKey(), entry.getValue());
			System.out.println(entry.getKey() + ": " + entry.getValue().size() + "\t->\t" + entry.getValue());
			i++;
			if (i > 2) {
				break;
			}
		}
	}
}
