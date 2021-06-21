package com.example.tiandilixin.parrten.strategy.comparedemo;

/**
 * @author zhaoliang
 */
public class CompareUtil<T> {

    public void sort(T[] arr, Strategy<T> strategy) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                min = strategy.compare(arr[j], arr[min]) == -1 ? j : min;
            }
            swap(arr, i, min);
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
