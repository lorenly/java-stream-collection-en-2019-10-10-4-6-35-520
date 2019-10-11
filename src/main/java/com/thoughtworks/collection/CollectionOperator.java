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
        throw new NotImplementedException();
       /* return IntStream.of(array)
                .boxed()
                .find)

                .collect(Collectors.toList());*/
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        throw new NotImplementedException();
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        throw new NotImplementedException();
    }
}
