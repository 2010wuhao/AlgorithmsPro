package com.example.algorithm

import com.leo.exercise.sort.SortLogic

fun main() {
    var main: Main = Main();
    main.testSelectSort()
}

public class Main {
    fun testSelectSort() {
        var intArray: IntArray = intArrayOf(10, 0, 1, 9, 8, 7, 5, 6, 3, 4, 2, 11)

        var sort: SortClass = SortClass()
        sort.selectSort(intArray)
        println(intArray.contentToString())

        intArray = intArrayOf(12, 0, 1, 9, 8, 7, 5, 6, 3, 4, 2, 11)
        SortLogic.selectSort(intArray)
        println(intArray.contentToString())
    }
}
