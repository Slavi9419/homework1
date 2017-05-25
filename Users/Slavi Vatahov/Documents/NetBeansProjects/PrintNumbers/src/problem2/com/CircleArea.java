/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.com;

import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class CircleArea {

    public static void main(String[] args) {

        int r;
        double s;
        Scanner input = new Scanner(System.in);

        System.out.print("Input circle radius r = ");
        r = input.nextInt();

        s = Math.PI * r * r;
        System.out.println("Circle area is " + s + " m\u00B2");
    }
}
