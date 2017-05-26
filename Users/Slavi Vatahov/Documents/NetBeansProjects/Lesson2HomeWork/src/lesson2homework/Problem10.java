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
public class Problem10 {

    public static void main(String[] args) {
        byte pail1 = 2;
        byte pail2 = 3;
        short tanker;
        short multiplier;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter capacity of the tank in the space [10...9999]");
            tanker = input.nextShort();
        } while (tanker < 10 || tanker > 9999);

        multiplier = (short) (tanker / 5);
        System.out.println(multiplier + " по 2 литра");
        System.out.println(multiplier + " по 3 литра");
        byte difference = (byte) (tanker - ((multiplier * 2) + (multiplier * 3)));
        System.out.println("допълнително кофа от " + difference + " литра");

    }
}
