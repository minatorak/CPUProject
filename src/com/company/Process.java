package com.company;

import java.text.DecimalFormat;
import java.util.Random;

public class Process {
    public  int _processName;
    public  double _arrival;
    public  double _executeTime;
    public  int _priority;

    private Random random = new Random();
    private DecimalFormat dformat = new DecimalFormat("##.##");

    public Process(int max_executime,int index,int maxarrival){
        _processName = random.nextInt(2000-1000)+1000;
        _executeTime = (double)random.nextInt(max_executime-1) + (random.nextInt(60)*0.01);
        if (index==0) _arrival = 0.00;
        else _arrival = (double)random.nextInt(maxarrival-1)+(random.nextInt(60)*0.01);
        _priority = random.nextInt(100);
    }
    public Process(Process poc){
        this._processName = poc._processName;
        this._arrival = poc._arrival;
        this._executeTime = poc._executeTime;
        this._priority = poc._priority;
    }

    public void showProcess(){
        System.out.print(_processName +"\t\t"+_arrival+"\t\t"+_executeTime+"\t\t"+_priority+"\n");
    }

}
