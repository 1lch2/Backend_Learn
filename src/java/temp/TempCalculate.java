package org.bd.java_exercise.temp;

public class TempCalculate {

    public static void main(String[] args) {
        for (int i = 1; i < 4; i++) {
            System.out.println("<<< 10^" + i + " <<<<");
            convert(i);
        }
    }

    public static void convert(int digit) {
        int base10 = (int) Math.pow(10, digit);
        float b = 15f;
        for (int i = 0; i <= 15; i++) {
            System.out.print((float) Math.round((i / b) * base10) / base10);
            if (i < 15) {
                System.out.print(", ");
            } else {
                System.out.println(" ");
            }
        }
    }
}
