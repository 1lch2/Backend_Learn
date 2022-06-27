package org.bd.java_exercise.annotation;

public class GetterSample {

    public static void main(String[] args) {
        Student john = new Student.Builder("John")
                .age(21)
                .address("Burwood, NSW 2134")
                .build();

        john.introduceSelf();
    }
}
