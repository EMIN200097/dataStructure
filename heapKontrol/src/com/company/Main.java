package com.company;

// Mehmet Emin ŞAHİN    ||   Numara : 02190201039   ||    3.sınıf örgün

import java.util.Scanner;

public class Main {


    public static boolean heapKontol(int[] array, int i) {
        if (2 * i + 2 > array.length) {
            return true;
        }

        boolean left = (array[i] <= array[2 * i + 1]) && heapKontol(array, 2 * i + 1);
        boolean right = (2 * i + 2 == array.length)
                || (array[i] <= array[2 * i + 2] && heapKontol(array, 2 * i + 2));
        return left && right;
    }

    public static void create(int[] dizi) {
        for (int i = (dizi.length - 1) / 2; i >= 0; i--) {
            minHeapCevir(dizi, dizi.length, i);
        }
    }

    public static void minHeapCevir(int[] dizi, int n, int i) {
        int Node = i;
        int leftChild = (2 * i) + 1;
        int rightChild = (2 * i) + 2;
        if (leftChild < dizi.length && dizi[Node] > dizi[leftChild]) {
            Node = leftChild;
        }
        if (leftChild < dizi.length && dizi[Node] > dizi[leftChild]) {
            Node = leftChild;
        }
        if (Node != i) {
            int temp = dizi[Node];
            dizi[Node] = dizi[i];
            dizi[i] = temp;
            minHeapCevir(dizi, n, Node);
        }
    }

    public static void print(int[] dizi) {
        System.out.print("min heap hali : [ ");
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner deger = new Scanner(System.in);
        System.out.print(" Sayi degerlerini aralarina virgul koyarak giriniz : ");
        String degerler = deger.next();

        String[] yeniSira = degerler.split(",");

        int[] array = new int[yeniSira.length];

        for (int i = 0; i < yeniSira.length; i++) {
            array[i] = Integer.parseInt(yeniSira[i]);
        }
        int index = 0;

        if (heapKontol(array, index)) {
            System.out.println("evet min heaptir");
        } else {
            System.out.println("min heap degildir");
            create(array);
            print(array);
        }

    }
    }

