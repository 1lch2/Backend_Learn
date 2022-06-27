package org.bd.java_exercise.annotation;

public class Student implements Person{

    @Getter
    private final int age;

    @Getter
    private final String name;

    @Getter
    private final String address;

    @Override
    public void introduceSelf() {
        System.out.println("Hi, I'm " + name + ", and I'm " + age + " years old.");
    }

    public static class Builder {

        // Required
        private final String name;

        // Optional
        private int age;
        private String address = "";

        public Builder (String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address (String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    private Student (Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.address = builder.address;
    }
}
