/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author Slavi Vatahov
 */
public class BinarySubtraction {

    public static void main(String[] args) {
        int a = 3;
        int b = 7;
        String binaryA = Integer.toBinaryString(a);
        String binaryB = Integer.toBinaryString(b);
        int c = a ^ b;
        System.out.println(c);
    }
}
