package com.leo.exercise.sort;

public class SortLogic {
  public static void selectSort(int[] intArray) {
    if (intArray == null || intArray.length == 0) {
      return;
    }
    int minIndex;
    for (int i = 0; i < intArray.length; i++) {
      minIndex = i;
      for (int j = i + 1; j < intArray.length; j++) {
        if (intArray[j] < intArray[minIndex]) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        int temp = intArray[i];
        intArray[i] = intArray[minIndex];
        intArray[minIndex] = temp;
      }
    }
  }
}
