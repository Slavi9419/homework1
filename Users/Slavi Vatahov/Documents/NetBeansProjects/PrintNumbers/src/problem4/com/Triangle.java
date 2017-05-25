/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4.com;

import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class Triangle {

    private static boolean isTriangle(int a, int b, int c) {
        return (c < a + b && a < c + b && b < a + c);
    }

    public static void main(String[] args) {

        int a, b, c;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a = ");
        a = input.nextInt();
        System.out.print("Input b = ");
        b = input.nextInt();
        System.out.print("Input c = ");
        c = input.nextInt();

        System.out.println(isTriangle(a, b, c));
    }
}
