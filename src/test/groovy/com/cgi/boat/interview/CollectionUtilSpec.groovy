package com.cgi.boat.interview

import spock.lang.Specification

class CollectionUtilSpec extends Specification {
    def "SortMapAndLimitTopResults"() {
        given:
        def unsortedMap = ['a': 1, 'b': 3, 'c': 2, 'd': 4]

        when:
        def sortedList = CollectionUtil.convertTopResultsToList(unsortedMap, 3)

        then:
        sortedList.size() == 3
        sortedList.get(0) == 'd: 4'
        sortedList.get(1) == 'b: 3'
        sortedList.get(2) == 'c: 2'
    }
}
