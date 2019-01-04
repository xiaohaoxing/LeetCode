package test;

import java.time.LocalDate;
import java.time.Period;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate from = LocalDate.parse("2014-06-09");
        LocalDate to = LocalDate.parse("2024-12-30");
        Period days = Period.between(from, to);
        System.out.println(days.getDays());
    }
}
