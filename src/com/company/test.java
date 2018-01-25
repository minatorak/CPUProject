package com.company;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.Random;

public class test {
    public static void main(String[] args){
        Random random = new Random();
        DecimalFormat dformat = new DecimalFormat("##.##");
        int n = 60*60*1000;
        Random generator = new Random(n);
        while (true){
            LocalTime time = LocalTime.MIN.plusSeconds(generator.nextLong());
            System.out.println(time);
        }
    }
}
