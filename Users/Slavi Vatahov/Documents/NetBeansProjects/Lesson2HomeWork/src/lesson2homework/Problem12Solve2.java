/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Slavi Vatahov
 */
public class Problem12Solve2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter date in format  (yyyy-MM-dd) ");
        String date = input.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.add(Calendar.DATE, 1);
            date = sdf.format(c.getTime());

            System.out.println("Next date is " + date);
        } catch (ParseException ex) {
            System.out.println("Wrong date format");
        } finally {
            input.close();
        }
    }
}
