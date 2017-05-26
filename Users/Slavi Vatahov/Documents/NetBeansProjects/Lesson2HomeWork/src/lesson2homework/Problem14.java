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
public class Problem14 {

    public static void main(String[] args) {
        byte x1, y1, x2, y2;
        byte color1, color2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter chess board coordinates [8x8]");
        System.out.print("Position  x1 = ");
        x1 = input.nextByte();
        System.out.print("Position  y1 = ");
        y1 = input.nextByte();
        System.out.print("Position  x2 = ");
        x2 = input.nextByte();
        System.out.print("Position  y2 = ");
        y2 = input.nextByte();

        if ((x1 - y1) % 2 == 0) {
            color1 = 0;
        } else {
            color1 = 1;
        }
        if ((x2 - y2) % 2 == 0) {
            color2 = 0;
        } else {
            color2 = 1;
        }

        if (color1 == color2) {
            System.out.println("The positions are the same color");
        } else {
            System.out.println("Positions are of different color");
        }
    }
}
