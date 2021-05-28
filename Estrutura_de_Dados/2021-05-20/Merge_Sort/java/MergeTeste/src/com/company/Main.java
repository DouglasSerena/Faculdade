package com.company;

import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
    private static Scanner sc;

    public static void main(String args[]) {
        sc = new Scanner(System.in);
        System.out.println("Em apenas um digito ");
        int n = sc.nextInt();

        System.out.println("Digite a quantidade de digitos que escolheu anteriormente");
        int array[] = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        System.out.println("A matriz que não é classificada é:");
        System.out.println(Arrays.toString(array));

        mergesort(array);

        System.out.println("Matriz classificada é :");
        System.out.println(Arrays.toString(array));
    }

    static void mergesort(int arr[]) {
        int n = arr.length;
        if (n < 2)
            return;
        int mid = n / 2;
        int left[] = new int[mid];
        int right[] = new int[n - mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = mid; i < n; i++)
            right[i - mid] = arr[i];

        mergesort(left);
        mergesort(right);
        
        merge(arr, left, right);
    }

    public static void merge(int array[], int esquerda[], int direita[]) {
        int L = esquerda.length;
        int R = direita.length;
        int i = 0, j = 0, k = 0;

        while (i < L && j < R) {
            if (esquerda[i] <= direita[j]) {
                array[k] = esquerda[i];
                i++;
            } else {
                array[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < L) {
            array[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < R) {
            array[k] = direita[j];
            j++;
            k++;
        }
    }
}