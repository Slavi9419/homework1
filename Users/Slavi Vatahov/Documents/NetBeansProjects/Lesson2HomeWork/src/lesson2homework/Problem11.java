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
public class Problem11 {

    public static void main(String[] args) {
        short number;
        byte a1, a2, a22, a3;
        Scanner input = new Scanner(System.in);
        try{
        do {
            System.out.println("Enter number in space [100...999]");
            number = input.nextShort();
        } while (number < 100 || number > 999);

        a1 = (byte) (number / 100);
        a22 = (byte) (number / 10);
        a2 = (byte) (a22 % 10);
        a3 = (byte) (number % 10);

        if (number % a1 == 0 && number % a2 == 0 && number % a3 == 0) {
            System.out.println("The number is divided by each digit");
        } else {
            System.out.println("The number is not divided by each digit");
        }
        }catch(ArithmeticException e){
            System.out.println("Can't divisible by zero");
        }
    }
}
