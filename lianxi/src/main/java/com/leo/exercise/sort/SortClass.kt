package com.example.algorithm

class SortClass {
    fun selectSort(array: IntArray): Unit {
        var minIndex = 0
        for (i in array.indices) {
            minIndex = i
            for (j in minIndex + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }

            if (minIndex != i) {
                var temp = array[i]
                array[i] = array[minIndex]
                array[minIndex] = temp
            }
        }
    }
}