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
public class Problem4 {

    public static void main(String[] args) {
        int a, b;

        Scanner input = new Scanner(System.in);

        System.out.print("Input a =");
        a = input.nextInt();

        do {
            System.out.print("Enter number different than number 'a' b =");
            b = input.nextInt();
        } while (a == b);

        if (a < b) {
            System.out.println(a + "," + b);
        } else {
            System.out.println(b + "," + a);
        }
    }
}
