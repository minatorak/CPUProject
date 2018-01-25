package com.company;


public class Main {
    public static void main(String[] args){
        int max_executime = 10;
        int maxarrival = 10;
        int min_executime = 5;
        CreateProcess createProcesstoQ = new CreateProcess();
        createProcesstoQ.addAllProcess(5,max_executime,min_executime,maxarrival);

        System.out.println("--------------");

        QueueProcess q = QueueProcess.getInstance();
        q.QueueProcess2FCFS();
        q.showData();
        q.QueueProcess2SJN();
        q.showData();
        q.QueueProcess2PriorityMin();
        q.showData();
    }
}