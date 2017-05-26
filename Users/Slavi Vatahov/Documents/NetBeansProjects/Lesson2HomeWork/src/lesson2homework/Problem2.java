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
public class Problem2 {

    public static void main(String[] args) {
        int a, b;
        int sum, difference, multiplication, division, remainderOfDivision;

        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Input a =");
            a = input.nextInt();
        } while (a == 0);
        do {
            System.out.print("Enter number different than number 'a' b =");
            b = input.nextInt();
        } while (b == 0 || (a == b));

        sum = a + b;
        difference = a - b;
        multiplication = a * b;
        division = a / b;
        remainderOfDivision = a % b;

        System.out.println("sum = " + sum + "\n" + "difference = " + difference + "\n" + "multiplication = " + multiplication + "\n" + "division = " + division + "\n" + "remainderOfDivision = " + remainderOfDivision);
    }
}
