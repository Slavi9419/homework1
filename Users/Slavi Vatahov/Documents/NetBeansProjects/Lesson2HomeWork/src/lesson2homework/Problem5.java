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
public class Problem5 {

    public static void main(String[] args) {
        int a, b, c;

        Scanner input = new Scanner(System.in);

        System.out.print("Input a =");
        a = input.nextInt();

        do {
            System.out.print("Enter number different than number 'a' b =");
            b = input.nextInt();
        } while (a == b);
        do {
            System.out.print("Enter number different than number 'a' and 'b' c =");
            c = input.nextInt();
        } while ((a == c) || (b == c));

        if (a > b && a > c) {
            System.out.print(a + ",");
            if (b > c) {
                System.out.print(b + "," + c);
            } else {
                System.out.print(c + "," + b);
            }
        } else if (b > a && b > c) {
            System.out.print(b + ",");
            if (a > c) {
                System.out.print(a + "," + c);
            } else {
                System.out.print(c + "," + a);
            }
        } else if (c > a && c > b) {
            System.out.print(c + ",");
            if (a > b) {
                System.out.print(a + "," + b);
            } else {
                System.out.print(b + "," + a);
            }
        }
    }
}
