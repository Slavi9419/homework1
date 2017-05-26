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
public class Problem8 {

    public static void main(String[] args) {
        short number;
        byte a1, a2, b1, b2, b11, b22;
        byte newNumber1, newNumber2;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter a number in the space [1000 ... 9999]");
            number = input.nextShort();
        } while ((number < 1000) || (number > 9999));

        a1 = (byte) (number / 1000);
        a2 = (byte) (number % 10);
        b11 = (byte) (number / 100);
        b1 = (byte) (b11 % 10);
        b22 = (byte) (number % 100);
        b2 = (byte) (b22 / 10);

        newNumber1 = (byte) ((a1 * 10) + a2);
        newNumber2 = (byte) ((b1 * 10) + b2);

        if (newNumber1 > newNumber2) {
            System.out.println(newNumber1 + ">" + newNumber2);
        } else if (newNumber1 < newNumber2) {
            System.out.println(newNumber1 + "<" + newNumber2);
        } else if (newNumber1 == newNumber2) {
            System.out.println(newNumber1 + "==" + newNumber2);
        }
    }
}
