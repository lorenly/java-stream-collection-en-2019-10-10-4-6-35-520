package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left < right)
            return IntStream.rangeClosed(left, right)
            .boxed()
            .collect(Collectors.toList());

        return IntStream.rangeClosed(right, left)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left < right)
            return IntStream.rangeClosed(left, right)
                    .boxed()
                    .filter(num -> num % 2 == 0)
                    .collect(Collectors.toList());

        return IntStream.rangeClosed(right, left)
                .boxed()
                .filter(num -> num % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array)
                .filter(num -> num % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

    }

    public int popLastElment(int[] array) {
        return IntStream.of(array)
                .reduce((num1, num2) -> num2)
                .getAsInt();//.collect(Collectors.toList());
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray)
                .filter(num -> IntStream.of(secondArray)
                        .anyMatch(num2 -> num == num2))
                .boxed()
                .collect(Collectors.toList());

    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<>();
        List<Integer> fArray = Arrays.stream(firstArray).collect(Collectors.toList());

        List<Integer> uncommonElements = Arrays.stream(secondArray)
                .filter(num -> !fArray.contains(num))
                .collect(Collectors.toList());

        result.addAll(fArray);
        result.addAll(uncommonElements);
        return result;
    }
}
