package com.fsk.interviews;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview1 {

    public static void main(String[] args) {

        String msg = """
                turkiye java community ve community turkiye
                java ama ayni zamanda da
                community java turkiye
                """;

        duplicateWords(msg);

    }

    public static List<String> duplicateWords(String sentence) {

        List<String> stringList = new ArrayList<>();
        String[] arr = sentence.split(" ");
        Map<String, Integer> duplicateWords = new HashMap<>();

        for (String item : arr) {
            if (duplicateWords.containsKey(item)) {
                duplicateWords.put(item, duplicateWords.get(item) + 1);
            }else duplicateWords.put(item, 1);
        }

        for (Map.Entry<String, Integer> entry : duplicateWords.entrySet()) {
            if (entry.getValue() > 1) {
                stringList.add(entry.getKey());
            }
        }

        return stringList;
    }

    public static List<String> duplicateWords2(String sentence) {

        Map<String, Long> duplicateWords = Arrays
                .stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return duplicateWords
                .entrySet()
                .stream()
                .filter(item -> item.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

}
