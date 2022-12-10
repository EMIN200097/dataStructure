package com.company;

// Mehmet Emin ŞAHİN    ||   Numara : 02190201039   ||    3.sınıf örgün

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); // Verinin klavyeden girilmesi için tanımladık
        
        int i = 0;

        //Girilen metinde boşluk var ise boşluğuda bir karakter olarak algılar.Bu nedenle çıktı farklılık gösterebilir
        System.out.println("Metin giriniz : ");
        String n = scanner.nextLine();
        int [] x = new int[255];   // girilen metindeki karakterlerin tekrar sayılarının tuttuk.
        int [] h = new int[255];
        char [] sirala = new char[255]; 
        String [] huffman = new String[255];

        for(i = 0; i<n.length(); i++)
            x[n.charAt(i)]++;
        i = 0;

        while(maxDeger(x) != 0){
            int temp = maxDeger(x);
            sirala[i] = (char) temp;
            h[i] = x[temp];
            x[temp] = 0;
            i++;
        }

        i = 0;
           
        // Metindeki karakter tekrarlarının sıralamasını gösterdik
        while (sirala[i] != 0) {
            System.out.print(sirala[i] + " : " + h[i] + " , ");
            i++;
        }
        System.out.print("\b\b.");

        int j = 0;

        for(j = 0; j < i; j++){
            huffman[j] = "";
            for(int k = 0; k<j; k++)
                huffman[j] = huffman[j] + '1';
            huffman[j] = huffman[j] + "0";
        }
        huffman[j-1] = huffman[j-1].substring(0,huffman[j-1].length()-1);

        System.out.println("\n");
        j = 0;

        for(String a:huffman)
            if(a!=null) {
                System.out.println(sirala[j] + " = " + a);
                j++;
            }
        System.out.print("\nCikti:\n");

        for(j = 0; j < n.length(); j++){
            int temp = charDeger(sirala, n.charAt(j));
            System.out.print(huffman[temp]);
        }
    }
    public static int maxDeger(int [] array){
        int sonuc = 0, deger = 0;

        for(int i = 0; i < array.length; i++)
            if(array[i] > sonuc) {
                sonuc = array[i];
                deger = i;
            }
        return deger;
    }
    public static int charDeger(char [] arr, char arama){
        int i = 0;
        for(i = 0; i < arr.length; i++){
            if(arr[i] == arama){
                break;
            }
        }
        return i;
    }
    }

