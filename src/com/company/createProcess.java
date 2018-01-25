package com.company;

public class createProcess {
    int max_executime = 10;
    int maxarrival = 50;

    public void addAllProcess(int n) {
        QueueProcess queueProcess = QueueProcess.getInstance();

        for (int index = 0;index<n;index++){
            Process process = new Process(max_executime,index,maxarrival);
            QueueProcess.addProcess(process,index==0);
        }
        queueProcess.showData();
    }
}
