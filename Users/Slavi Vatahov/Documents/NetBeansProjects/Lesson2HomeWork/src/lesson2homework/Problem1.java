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
public class Problem1 {

    private static boolean isBetweenAAndB(int c, int a, int b) {
        return ((c > a && c < b) || (c < a && c > b));
    }

    public static void main(String[] args) {
        int a, b, c;

        Scanner input = new Scanner(System.in);
        System.out.print("Input A =");
        a = input.nextInt();
        System.out.print("Input B =");
        b = input.nextInt();
        System.out.print("Input C =");
        c = input.nextInt();

        if (isBetweenAAndB(c, a, b)) {
            System.out.println("The number " + c + " is between A and B");
        } else {
            System.out.println("The number " + c + " is not between A and B");
        }
    }
}
