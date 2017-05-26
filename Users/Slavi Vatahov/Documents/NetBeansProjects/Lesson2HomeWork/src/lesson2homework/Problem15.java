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
public class Problem15 {

    public static void main(String[] args) {
        byte number;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter number in the space [0...24]");
            number = input.nextByte();
        } while (number < 0 || number > 24);

        if (number >= 4 && number <= 9) {
            System.out.println("Good morning");
        }else if (number>9 && number<18){
            System.out.println("Good day");
        }else{
            System.out.println("Good evening");
        }

    }
}
