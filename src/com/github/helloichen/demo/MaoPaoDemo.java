package com.github.helloichen.demo;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author iChen
 */
public class MaoPaoDemo {

    public static void main(String[] args) {
        MaoPaoDemo demo = new MaoPaoDemo();
        int[] arr = { 1, 3, 5, 7, 9, 8, 6, 4, 2, 0 };
        demo.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        // 需要比较 n-1 轮
        for (int i = 0; i < arr.length - 1; i++) {
            // 每轮会冒泡一个最大的在后面，少比较经过的轮数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 两两交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
