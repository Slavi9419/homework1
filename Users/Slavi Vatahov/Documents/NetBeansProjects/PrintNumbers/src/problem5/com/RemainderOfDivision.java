/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5.com;

import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class RemainderOfDivision {

    private static boolean remainderOfIntegerDivision(int a) {
        return a % 7 == 0;
    }

    public static void main(String[] args) {
        int a;
        Scanner input = new Scanner(System.in);

        System.out.print("Input a = ");
        a = input.nextInt();
        System.out.println(remainderOfIntegerDivision(a));
    }
}
