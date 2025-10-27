package Basics;

public class FinalVar {

    public static void main(String[] args) {

       // final int age = 21; gives error cannot assign a value to final variable age when its already declared
        final int age;

        age = 28;

        System.out.println("Current age: "+age);
    }


}
