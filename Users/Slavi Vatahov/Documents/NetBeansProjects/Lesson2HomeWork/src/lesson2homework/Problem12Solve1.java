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
public class Problem12Solve1 {

    public static String calculateNextDate(int day, int month, int year) {

        if (day < 28) {
            return ("Next date is " + (day + 1) + "/" + month + "/" + year);

        } else if ((day >= 28 && day < 31) && (month != 2 && month != 4 && month != 6 && month != 11)) {
            return ("Next date is " + (day + 1) + "/" + month + "/" + year);

        } else if ((day >= 28 && day < 30) && (month != 2 || month == 4 || month == 6 || month == 11)) {
            return ("Next date is " + (day + 1) + "/" + month + "/" + year);

        } else if ((day == 30) && (month != 2 || month == 4 || month == 6 || month == 11)) {
            day = 1;
            month++;
            return ("Next date is " + (day) + "/" + month + "/" + year);

        } else if (day == 28 && month == 2 && (year % 4 == 0 || year % 400 == 0)) {
            return ("Next date is " + (day + 1) + "/" + month + "/" + year);

        } else if (day == 29 && month == 2 && (year % 4 == 0 || year % 400 == 0)) {
            day = 1;
            month++;
            return ("Next date is " + (day) + "/" + month + "/" + year);

        } else if (day == 28 && month == 2 && (year % 4 != 0 || year % 400 != 0)) {
            day = 1;
            month++;
            return ("Next date is " + (day) + "/" + month + "/" + year);

        } else if (day == 31) {
            day = 1;
            if (month < 12) {
                month++;
            } else if (month == 12) {
                month = 1;
                year++;
            }
            return ("Next date is " + (day) + "/" + month + "/" + year);
        }
        return ("-1");

    }

    public static void main(String[] args) {
        byte day, month;
        short  year;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enther year ");
            year = input.nextShort();
        } while (year < 0);
        do {
            System.out.print("Enther month ");
            month = input.nextByte();
        } while (month <= 0 || month > 12);

        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {

            do {
                System.out.print("Enther day of the month ");
                day = input.nextByte();
            } while (day < 1 || day > 31);
        } else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
            do {
                System.out.print("Enther day of the month ");
                day = input.nextByte();
            } while (day < 1 || day > 30);
        } else if (month == 2 && (year % 4 == 0 || year % 400 == 0)) {
            do {
                System.out.print("Enther day of the month ");
                day = input.nextByte();
            } while (day < 1 || day > 29);
        } else {
            do {
                System.out.print("Enther day of the month ");
                day = input.nextByte();
            } while (day < 1 || day > 28);
        }

        System.out.println(calculateNextDate(day, month, year));
    }
}
