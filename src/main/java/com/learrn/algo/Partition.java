package com.learrn.algo;

import java.util.Arrays;

/**
 * Partition，分区
 * 把小于num的放在左边，大于num的放在右边
 */
public class Partition {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,9,1,2,7,9,5,4};
        int n = t1(arr, 8);
        System.out.println(n);
        Arrays.stream(arr).forEach(e -> System.out.print(e + ","));
    }

    public static int t1(int[] arr, int num) {
        int n = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= num) {
                temp = arr[n];
                arr[n] = arr[i];
                arr[i] = temp;
                n++;
            }
        }
        return n;
    }
}
