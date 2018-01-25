package com.company;

import java.util.ArrayList;

public class QueueProcess {
    private static QueueProcess ourInstance = new QueueProcess();
    private static ArrayList<Process> mainList;


    public static QueueProcess getInstance() {
        return ourInstance;
    }

    private QueueProcess() {
        mainList = new ArrayList<Process>();
    }

    public static void addProcess(Process process){
        mainList.add(process);
    }

    public void showData(){
        if (mainList.isEmpty()){
            System.out.println("Empty Queue");
            return ;
        }
        System.out.println("number||\t"+"arrival||\t"+"executeTime||\t"+"priority||\t"+"CPU ||\t"+"wait\t"+"system\t"+mainList.size());

        int size = mainList.size();
        for (Process poc:mainList){
            poc.showProcess();
        }
    }

    public void runProc(){
        int size = mainList.size();
        for (int index = 0;index < size;index++){

            if (index == 0){
                Process process = new Process();
                mainList.get(index).Processing(process);
            }else {
                mainList.get(index).Processing(mainList.get(index-1));
            }

        }
    }

    public void QueueProcess2FCFS(){

        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size();j++){
             if (Double.parseDouble(mainList.get(j - 1)._arrival) > Double.parseDouble(mainList.get(j)._arrival) ){

                 Process temp = mainList.get(j-1);
                 mainList.set(j-1,mainList.get(j));
                 mainList.set(j,temp);

             }
            }
        }
        runProc();
    }

    public void QueueProcess2SJN(){
        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size();j++){
                if (Double.parseDouble(mainList.get(j - 1)._executeTime) > Double.parseDouble(mainList.get(j)._executeTime) ){
                    Process temp = mainList.get(j-1);
                    mainList.set(j-1,mainList.get(j));
                    mainList.set(j,temp);
                }
            }
        }
        runProc();
    }

    public void QueueProcess2PriorityMax(){

        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size();j++){
                if (mainList.get(j - 1)._priority < mainList.get(j)._priority ){
                    Process temp = mainList.get(j-1);
                    mainList.set(j-1,mainList.get(j));
                    mainList.set(j,temp);
                }
            }
        }
        runProc();
    }
    public void QueueProcess2PriorityMin(){
        for (int i=0;i<mainList.size();i++){
            for (int j =1;j<mainList.size();j++){
                if (mainList.get(j - 1)._priority > mainList.get(j)._priority ){
                    Process temp = mainList.get(j-1);
                    mainList.set(j-1,mainList.get(j));
                    mainList.set(j,temp);
                }
            }
        }
        runProc();
    }
}
