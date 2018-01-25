package com.company;


public class Main {
    public static void main(String[] args){
        createProcess createProcesstoQ = new createProcess();
        createProcesstoQ.addAllProcess(20);
        System.out.println("--------------");
        QueueProcess q = QueueProcess.getInstance();
        q.QueueProcess2FCFS();
        q.showData();
        q.QueueProcess2SJN();
        q.showData();
        q.QueueProcess2PriorityMax();
        q.showData();
    }
}