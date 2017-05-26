/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2homework;

/**
 *
 * @author Slavi Vatahov
 */
public class Problem16 {

    public static void main(String[] args) {
        short number = 155;
        byte a, b, b1, c;

        a = (byte) (number / 100);
        c = (byte) (number % 10);
        b1 = (byte) (number / 10);
        b = (byte) (b1 % 10);

        if (a == b && b == c) {
            System.out.println(number+ " The digits are equal.");
        } else if (a > b && b > c) {
            System.out.println(number+ " The digits are in descending order");
        } else if (a < b && b < c) {
            System.out.println(number+ " The digits are in ascending order ");
        } else {
            System.out.println(number + " The digits are unordered");
        }
    }
}
