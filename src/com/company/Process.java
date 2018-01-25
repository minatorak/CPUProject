package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class Process {
    private int _processName;
    public  String _arrival;
    public  String _executeTime;
    public  int _priority;

    private DecimalFormat decimalFormat = new DecimalFormat("00.00");


    // processing
    private String _cpu_time = "0.00";
    private String _wait_time = "0.00";
    private String _systime_time = "0.00";

    private Random random = new Random();


    public Process(int min_executime,int max_executime,int index,int maxarrival){

        _processName = random.nextInt(2000-1000)+1000;
        _executeTime = decimalFormat.format( BigDecimal.valueOf(random.nextInt(60)*0.01)
                .add(BigDecimal.valueOf(random.nextInt(max_executime-min_executime)+min_executime)));

        _arrival = decimalFormat.format(BigDecimal.valueOf(random.nextInt(60)*0.01)
                .add(BigDecimal.valueOf(random.nextInt(maxarrival))));

        _priority = random.nextInt(100);

    }

    public Process(){
        _processName = 0;
        _arrival = "0";
        _executeTime = "0";
        _priority = 0;

    }

    public void Processing(Process oldpoc){
        _cpu_time = decimalFormat.format(Double.parseDouble(oldpoc._cpu_time)+
                        Double.parseDouble(oldpoc._executeTime));
        _wait_time =  decimalFormat.format(Double.parseDouble(this._cpu_time) -
                        Double.parseDouble(this._arrival));
        _systime_time = decimalFormat.format(Double.parseDouble(this._executeTime) +
                        Double.parseDouble(this._wait_time));
    }
    public void showProcess(){
        System.out.println(_processName +"\t\t"
                +_arrival+"\t\t\t\t"
                +_executeTime+"\t\t\t\t"
                +_priority+"\t\t\t\t"
                +_cpu_time+"\t\t\t\t"
                +_wait_time+"\t\t\t\t"
                +_systime_time+"\t\t\t\t"
                );
    }
}