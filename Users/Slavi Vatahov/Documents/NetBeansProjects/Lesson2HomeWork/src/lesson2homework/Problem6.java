/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2homework;

import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class Problem6 {

    public static void main(String[] args) {
        int a1, a2, a3;
        int temp;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a =");
        a1 = input.nextInt();

        do {
            System.out.print("Enter number different than number 'a1' a2 =");
            a2 = input.nextInt();
        } while (a1 == a2);
        do {
            System.out.print("Enter number different than number 'a1' and 'a2' a3 =");
            a3 = input.nextInt();
        } while ((a1 == a3) || (a2 == a3));
        temp = a1;
        a1 = a2;
        a2 = a3;
        a3 = temp;

        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a3 = " + a3);
    }
}
