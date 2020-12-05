package com.leo.exercise.java;

public class TestSuper {

    public static void main(String[] args) {
        new Child();
    }
}

class Foo {
    public Foo(String word) {
        System.out.println(word);
    }
}

class Child extends Parent {
    static Foo FOO = new Foo("1");
    Foo foo = new Foo("2");

    static {
        System.out.println("3");
    }

    {
        System.out.println("4");
    }

    public Child() {
        System.out.println("5");
    }
}

class Parent {
    {
        System.out.println("6");
    }

    static {
        System.out.println("7");
    }

    Foo foo = new Foo("8");

    static Foo FOO = new Foo("9");

    public Parent() {
        System.out.println("10");
    }
}