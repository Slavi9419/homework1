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
public class Problem7 {

    public static void main(String[] args) {
        byte time;
        double money;
        boolean ishealthy;

        Scanner input = new Scanner(System.in);

        System.out.println("input time ");
        time = input.nextByte();
        do {
            System.out.println("input money ");
            money = input.nextDouble();
        } while (money < 0);
            System.out.println("input ishealthy (true or false) ");
            ishealthy = input.nextBoolean();
       

        if (!ishealthy) {
            System.out.println("I am sick and will not go out.");
            if (money >= 5) {
                System.out.println("I'll buy drugs.");
            } else {
                System.out.println("I will drink tea.");
            }
        } else {
            if (money > 10) {
                System.out.println("I will go to the movies with friends");
            } else {
                System.out.println("I will go to coffee");
            }
        }
    }
}
