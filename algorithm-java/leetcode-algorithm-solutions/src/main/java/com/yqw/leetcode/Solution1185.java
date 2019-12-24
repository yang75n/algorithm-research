package com.yqw.leetcode;

public class Solution1185 {
    //星期几
    public String dayOfTheWeek(int day, int month, int year) {
        String days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int start = 4;//1971年1月1第一天星期五,所以从星期四开始
        int sum = 0;
        for (int i = 1971; i < year; ++i) {
            sum += daysOfyear(i);
        }
        for (int i = 1; i < month; ++i) {
            if (i == 2 && isLeapYear(year)) {
                sum += 29;
            } else {
                sum += months[i - 1];
            }
        }
        sum += day;
        sum = sum % 7;
        int now = (start + sum) % 7;
        return days[now];

    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }

    //一年有多少天，闰年366，平年365
    private int daysOfyear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }


    public static void main(String[] args) {
        System.out.println(new Solution1185().dayOfTheWeek(1, 1, 1971));
    }
}
