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
public class Problem13 {

    public static void main(String[] args) {
        byte temp;
        try (Scanner input = new Scanner(System.in)) {
            
                System.out.println("Enter temperature in the space [-100...100]");
                temp = input.nextByte();
           

            if (temp < -20) {
                System.out.println("Ice cold");
            } else if (temp <= 0 && temp >= -20) {
                System.out.println("Cold");
            } else if (temp <= 15 && temp >= 0) {
                System.out.println("Coldly");
            } else if (temp <= 25 && temp >= 15) {
                System.out.println("Warm");
            } else if (temp > 25) {
                System.out.println("Hot");
            }
        } catch (InputMismatchException e) {
            System.out.println("The temperature is out of range");
        }
    }
}
