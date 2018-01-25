package com.company;

import java.util.ArrayList;

public class QueueProcess {
    private static QueueProcess ourInstance = new QueueProcess();
    private static ArrayList<Process> mainList;
    public static int maxProcess = 50;
    private static Process header;
    private StateOfQ state = StateOfQ.FCFS;

    public void setSt(StateOfQ st) {
        this.state = st;
    }


    public static QueueProcess getInstance() {
        return ourInstance;
    }

    private QueueProcess() {
        this.mainList = new ArrayList<Process>();
    }

    public static void addProcess(Process process,boolean isheader){
        if (isheader)
            header = process;
        else
            mainList.add(process);
    }

    public static ArrayList<Process> getFCFS(){
        if (mainList.isEmpty())
            return null;
        return mainList;
    }

    public static boolean qisEmpty(){
        return mainList.isEmpty();
    }

    public void showData(){
        if (mainList.isEmpty()){
            System.out.println("Empty Queue");
            return;
        }
        System.out.println("number||\t"+"arrival||\t"+"executeTime||\t"+"priority||\t"+getSize());
        System.out.println(header._processName + "\t\t"+header._arrival+"\t\t"+header._executeTime+"\t\t"+header._priority);
        for (Process pro:
             mainList) {
            pro.showProcess();
        }
    }

    public int getSize(){
        return mainList.size()+1;
    }

    public StateOfQ getstatus(){
        return state;
    }

    public void QueueProcess2FCFS(){
        this.state = StateOfQ.FCFS;

        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size()-1;j++){
             if (mainList.get(j - 1)._arrival > mainList.get(j)._arrival ){
                 Process temp = mainList.get(j-1);
                 mainList.set(j-1,mainList.get(j));
                 mainList.set(j,temp);
             }
            }
        }
    }

    public void QueueProcess2SJN(){
        this.state = StateOfQ.SJN;
        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size()-1;j++){
                if (mainList.get(j - 1)._executeTime > mainList.get(j)._executeTime ){
                    Process temp = mainList.get(j-1);
                    mainList.set(j-1,mainList.get(j));
                    mainList.set(j,temp);
                }
            }
        }
    }

    public void QueueProcess2PriorityMax(){
        this.state = StateOfQ.SJN;
        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size()-1;j++){
                if (mainList.get(j - 1)._priority < mainList.get(j)._priority ){
                    Process temp = mainList.get(j-1);
                    mainList.set(j-1,mainList.get(j));
                    mainList.set(j,temp);
                }
            }
        }
    }
}
