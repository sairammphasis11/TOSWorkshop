package com.company.assesments;

import java.util.Arrays;
import java.util.List;

public class Cl {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list.forEach(el -> System.out.println(el));
        list.forEach(System.out::println);
    }
}

