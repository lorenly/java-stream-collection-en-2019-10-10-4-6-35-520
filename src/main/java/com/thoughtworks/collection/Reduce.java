package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return this.arrayList.stream()
                .reduce(Math::max)
                .orElse(0);
    }

    public double getMinimum() {
        return this.arrayList.stream()
                .reduce(Math::min)
                .orElse(0);
    }

    public double getAverage() {
        return (double) this.arrayList.stream()
                .reduce((num1, num2) -> num1 + num2)
                .get() / this.arrayList.size();
    }

    public double getOrderedMedian() {
        return getMedian();
    }

    public int getFirstEven() {
        return this.arrayList.stream()
                .reduce(0,(num, curr) ->{
                    return num == 0 && curr % 2 == 0 ? curr : num;
                });
    }

    public int getIndexOfFirstEven() {
        return this.arrayList.stream()
                .reduce(0, (num, curr) ->{
                   return num == 0 && curr % 2 == 0 ? arrayList.indexOf(curr) : num;
                });
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);

    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        final int listSize = this.arrayList.size();
        return this.arrayList.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0, (num, curr) -> {
                    int median = (int)Math.round((double)arrayList.size() /2);
                    return listSize % 2 == 0 ? (double) ((int) singleLink.getNode(median + 1) + (int) singleLink.getNode(median)) / 2 :
                            Double.valueOf(singleLink.getNode(median).toString());
                            //Double.valueOf(singleLink.getNode(quotient).toString());
                });


    }

    private double getMedian(){
        final int listSize = this.arrayList.size();
        return this.arrayList.stream()
                .mapToDouble(Integer::doubleValue)
                .reduce(0, (num, curr) -> {
                    int median = (int) listSize / 2;
                    return listSize % 2 == 0 ? (double) (arrayList.get(median - 1) + arrayList.get(median)) / 2 :
                            (double) arrayList.get(median / 2 - 1);
                });
    }
    public int getLastOdd() {
        return this.arrayList.stream()
                .reduce(0, (num, curr) -> {
                    return curr % 2 != 0 ? curr : num;
                });
    }

    public int getIndexOfLastOdd() {
        return arrayList.indexOf(getLastOdd());
    }
}
