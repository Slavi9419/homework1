/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3.com;

import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class SquareArea {

    public static void main(String[] args) {
        int a, b;
        double s;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a = ");
        a = input.nextInt();
        System.out.print("Input b = ");
        b = input.nextInt();

        s = a * b;

        System.out.println("Square area is " + s + " m\u00B2");
    }
}
