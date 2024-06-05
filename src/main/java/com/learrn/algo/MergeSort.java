package com.learrn.algo;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9,2, 3,23, 6, 1, 2, 8, 5, 3};
        mergeSort1(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
        System.out.println();
        arr = new int[]{9,2, 3, 6, 1, 23,2, 8, 5, 3};
        mergeSort2(arr);
        Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
    }

    // 递归方式
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = middle + 1;
        while (p1 <= middle && p2 <= right) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
        i = 0;
        while (i < temp.length) {
            arr[left + i] = temp[i];
            i++;
        }
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    // 非递归方式
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        int size = 1;
        while (size < length) {
            int left = 0;
            while (left < length) {
                int middle = left + size - 1;
                if (middle >= length) {
                    break;
                }
                int right = Math.min(middle + size, length - 1);
                merge(arr, left, middle, right);
                left = right + 1;
            }
            size = size << 1;
        }
    }
}
