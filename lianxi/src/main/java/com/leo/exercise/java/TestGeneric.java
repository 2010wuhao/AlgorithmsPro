package com.leo.exercise.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestGeneric {

    class Human{
    }
    class Father extends Human{
    }
    class Son extends Father{
    }
    class LeiFeng extends Father {
    }

    public static void main(String[] args) {
        List<? extends Object> list1 = new ArrayList<>();
        //编译不过：因为extends Object，Object的子类太多了，编译器在编译的时候无法确定list1里面到底存的是什么类型，上界<? extends T>不能往里存，只能往外取。
//        list1.add("a");
        List<Object> list2 = new ArrayList<>();
        list2.add("b");
        System.out.println("" + list1.get(0) + list2.get(0));

        //https://blog.csdn.net/jdsjlzx/article/details/70479227
//        List<? extends Father> list = new LinkedList<>();
//        list.add(new Son());
    }
}
