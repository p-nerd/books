package com.gmail.shihab4t.chapter04;

import java.util.Scanner;

public class C13MonthToDayConverterWithSwitchExpression {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month: ");
        int month = input.nextInt();

        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                System.out.print("Enter year");
                int year = input.nextInt();

                if (year % 4 == 0) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            default -> 0;
        };

        System.out.println("The month have " + days + " days");
    }
}
