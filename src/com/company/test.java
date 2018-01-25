package com.company;

import java.util.Random;

public class test {
    public static void main(String[] args){
        Random random = new Random();
        while (true) {
            double d = random.nextInt(60)*0.01;
            System.out.println(d);
            System.out.println(10+d);
        }
    }
}
