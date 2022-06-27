package org.bd.java_exercise.temp;

public class TestFloatNumber {

    public static void main(String[] args) {
//        float floatNum = 0.2745f;
//        convertFloat(floatNum);
//        System.out.println(round2(floatNum, 1));

        System.out.println(">>>>>");
        testParse("0f");
    }

    private static void convertFloat(float input) {
        float res = (float) Math.round(input * 10f) / 10f;
        System.out.println(res);

        float a = 2;
        float b = 15;
        float r = (float) Math.round((a / b) * 10f) / 10f;
        System.out.println(a/b);
        System.out.println(r);
    }

    public static float round2(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return ( (float) ( (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) ) ) / pow;
    }

    public static void testParse(String strFloat) {
        System.out.println(Float.parseFloat(strFloat));
    }
}
