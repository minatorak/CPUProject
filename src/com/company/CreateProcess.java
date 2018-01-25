package com.company;

public class CreateProcess {
    public static void addAllProcess(int n,int max_executime,int min_executime, int maxarrival) {
        QueueProcess queueProcess = QueueProcess.getInstance();

        for (int index = 0;index<n;index++){
            Process process = new Process(min_executime,max_executime,index,maxarrival);
            QueueProcess.addProcess(process);
        }
        queueProcess.showData();
    }
}
