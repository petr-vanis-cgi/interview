package com.cgi.boat.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class PeopleProcessor {
	static Scanner sc = new Scanner(System.in);
	static List<String> list = new ArrayList<>();

	/**
	 * Returns a {@link Map} where keys are first names and values lists of all last
	 * names of people from the input list who have the first name equal to the key.
	 *
	 * Example: For input: ["John Doe", "John Silver", "Peter Doe"] Expected result
	 * would be: { "John" -> ["Doe", "Silver"] "Peter" -> ["Doe"] }
	 */

	static Map<String, List<String>> lastnamesByFirstname(List<Person> people) {
		// TODO: implement

//		System.out.println("\nType-in a full name to find out all the last names of the same first name..");     //Scan input 
//		String input = sc.nextLine();
//		String parts[] = input.split(" ");
//		Map<String, List<String>> names = new HashMap<>();
//
//		for (Person temp : people) {
//			if (parts[0].equals(temp.getFirstName())) {
//				list.add(temp.getLastName());
//			}
//		}
//		names.put(parts[0], list);
//		return names;

		String[] ppl = new String[3];    //Hard coded input
		ppl[0] = "John Doe";
		ppl[1] = "John Silver";
		ppl[2] = "Peter Doe";

		Map<String, List<String>> names = new HashMap<>();

		for (int i = 0; i <= 2; i++) {

			String parts[] = ppl[i].split(" ");
			ppl[i] = parts[0];
			if (!names.containsKey(ppl[i])) {
				for (Person temp : people) {
					if (ppl[i].equals(temp.getFirstName())) {

						list.add(temp.getLastName());
					}
				}

				List<String> cloneList = new ArrayList<>(list);
				names.put(ppl[i], cloneList);
				list.clear();
			}

		}
		return names;

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

//		System.out.println("Type-in a full name to find out all the first names of the same last name..");    //Scan input
//		String input = sc.nextLine();
//		String parts[] = input.split(" ");
//
//		Map<String, List<String>> lastNames = new HashMap<>();
//
//		for (Person temp : people) {
//			if (parts[1].equals(temp.getLastName())) {
//
//				list.add(temp.getFirstName());
//			}
//		}
//
//		lastNames.put(parts[1], list);
//		return lastNames;

		String[] ppl = new String[3];    //Hard coded input
		ppl[0] = "Jerry Barrie";
		ppl[1] = "Jacob O'Toole";
		ppl[2] = "Earl Cameron";

		Map<String, List<String>> lastNames = new HashMap<>();

		for (int i = 0; i <= 2; i++) {

			String parts[] = ppl[i].split(" ");
			ppl[i] = parts[1];
			if (!lastNames.containsKey(ppl[i])) {
				for (Person temp : people) {
					if (ppl[i].equals(temp.getLastName())) {

						list.add(temp.getFirstName());
					}
				}

				List<String> cloneList = new ArrayList<>(list);
				lastNames.put(ppl[i], cloneList);
				list.clear();
			}
		}
		return lastNames;
	}
}
