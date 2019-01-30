package com.cgi.boat.interview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionUtil {
    public static List<String> convertTopResultsToList(Map<String, Long> namesAndCounts, int limit) {
        return namesAndCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.toList());
    }
}
