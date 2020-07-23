package com.company.design.strategy;

/**
 * @author 拌面
 * @date 2020/7/6
 * @description
 */

public class Sort<T> {

    /**
     * 传入需要比较的数组和比较器
     *
     * @param arr
     * @param comparator
     * @return
     */
    public T[] sortArray(T[] arr, MyComparator<T> comparator) {
        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minPos = i;

                for(int j=i+1; j<arr.length; j++) {
                    minPos = comparator.compare(arr[j],arr[minPos])==-1 ? j : minPos;
                }
                swap(arr, i, minPos);

            }
        }
        return null;
    }
    void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
