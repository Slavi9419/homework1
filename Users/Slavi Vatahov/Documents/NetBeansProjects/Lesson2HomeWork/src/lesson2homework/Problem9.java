/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2homework;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class Problem9 {

    public static void main(String[] args) {
        byte number1, number2;
        short multiplication;
        Scanner input = new Scanner(System.in);
        try {

            do {
                System.out.println("Enter number1 in the space [10...99] = ");
                number1 = input.nextByte();
            } while (number1 < 10 || number1 > 99);
            do {
                System.out.println("Enter number2 in the space [10...99] = ");
                number2 = input.nextByte();
            } while (number2 < 10 || number2 > 99);

            multiplication = (short) (number1 * number2);
            if (multiplication % 10 == 0) {
                System.out.println(multiplication + " ,четна " + multiplication % 10);
            } else {
                System.out.println(multiplication + " ,нечетна " + multiplication % 10);
            }
        } catch (InputMismatchException e) {
            System.out.println("The value out of range");
        } finally {
            input.close();
        }
    }

}
