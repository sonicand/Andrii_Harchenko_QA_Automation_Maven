package org.hillel.calculator;

public class Main {
    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        boolean result = calculation.multiply(10,2)==20;
        System.out.println(result);
    }
}