package com.cgi.boat.interview

import spock.lang.Specification

class PeopleProcessorSpec extends Specification {
    def "LastnamesByFirstname"() {
        given:
        def people = [new Person("Karel", "Novotny"),
                      new Person("Karel", "Novak"),
                      new Person("Libor", "Novotny"),
                      new Person("Petr", "Jares")]

        when:
        def map = PeopleProcessor.lastnamesByFirstname(people)

        then:
        map.size() == 3
        map.get("Karel").size() == 2
        map.get("Karel").containsAll(["Novak", "Novotny"])
        map.get("Libor").size() == 1
        map.get("Libor").contains("Novotny")
        map.get("Petr").size() == 1
        map.get("Petr").contains("Jares")
    }

    def "FirstnamesByLastname"() {
        given:
        def people = [new Person("Karel", "Novotny"),
                      new Person("Jan", "Novotny"),
                      new Person("Libor", "Novak"),
                      new Person("Petr", "Jares")]

        when:
        def map = PeopleProcessor.firstnamesByLastname(people)

        then:
        map.size() == 3
        map.get("Novotny").size() == 2
        map.get("Novotny").containsAll(["Karel", "Jan"])
        map.get("Novak").size() == 1
        map.get("Novak").contains("Libor")
        map.get("Jares").size() == 1
        map.get("Jares").contains("Petr")
    }

    def 'firstnamesByOccurence'() {
        given:
        //Karel 3x, Libor 2x, Petr 1x
        def people = [new Person("Karel", "Novotny"),
                      new Person("Karel", "Novak"),
                      new Person("Karel", "Hrubes"),
                      new Person("Libor", "Novotny"),
                      new Person("Libor", "Dvorak"),
                      new Person("Petr", "Jares")]

        when:
        def map = PeopleProcessor.firstnamesByOccurence(people)

        then:
        map.size() == 3
        map.get("Karel") == 3L
        map.get("Libor") == 2L
        map.get("Petr") == 1L
    }


}
