package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        int lowerLimit = Math.min(leftBorder, rightBorder);
        int upperLimit = Math.max(leftBorder, rightBorder);

        for(int i = lowerLimit; i <= upperLimit; i++){
            if(i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;

        int lowerLimit = Math.min(leftBorder, rightBorder);
        int upperLimit = Math.max(leftBorder, rightBorder);

        for(int i = lowerLimit; i <= upperLimit; i++){
            if(i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(num -> (num * 3) + 2)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> oddList = arrayList.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        arrayList.forEach((num) -> {
            resultList.add(oddList.contains(num) ? (num * 3) + 2 : num);
        });
        return resultList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        List<Integer> oddNumberList = arrayList.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        int sum = 0;
        for(int num: oddNumberList){
            sum += num * 3 + 5;
        }

        return sum;

    }

    public double getMedianOfEven(List<Integer> arrayList) {
        int sum = arrayList.stream().reduce((a, b) -> a + b).get();
        return sum / arrayList.size();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum() / arrayList.stream().filter(num -> num % 2 == 0).count();
//        int sum = evenList.stream().reduce((a, b) -> a + b).get();
//        return sum / evenList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                .filter(num -> num % 2 == 0)
                .anyMatch(num -> num == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return  arrayList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream()
                .filter(num -> num % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(evenList);
        resultList.addAll(oddList);
        return resultList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < arrayList.size()-1; i++){
            result.add((arrayList.get(i) + arrayList.get(i+1)) * 3);
        }
        return result;
    }
}
