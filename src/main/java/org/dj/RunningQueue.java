package org.dj;

import java.util.Arrays;

public class RunningQueue extends Queue {

    Process[] processes = new Process[50];

    int quantum = 1;

    int head = 0;

    int tail = 0;

    int remProcesses = 0;


    public RunningQueue(Process[] processes){

            this.processes = processes;

    }

    public void orderProcessByPriorityAndDate(){

        Arrays.sort(processes);

    }

    public int checkCurrentRemProcesses(){

        int currentPriority = processes[head].getPriority();

        tail = processes.length - 1;

        for (int i = head; i < processes.length; i++) {


            if (processes[i].getPriority() == currentPriority){

                remProcesses++;

            }else{

                tail = i - 1;

                i = processes.length + 1;

            }

        }

        return remProcesses;

    }

    public void run(){

        orderProcessByPriorityAndDate();

        checkCurrentRemProcesses();

        int i = 0;

        boolean isFinished = false;

        while (!isFinished){

            if (i > tail && remProcesses > 0){

                i = head;

            }else if (processes[i] != null && remProcesses > 0){

                if (processes[i].getQuantum() > 0){

                    System.out.println("Ejecutando proceso: " + processes[i].getName() + " con quantum: " + processes[i].getQuantum()+ " con prioridad: " + processes[i].getPriority()+ " y PID: " + processes[i].getPID());

                    processes[i].setQuantum(processes[i].getQuantum() - quantum);

                    if (processes[i].getQuantum() <= 0){

//                        super.remove();

                        processes[i] = null;

                        remProcesses--;

                    }

                }

                i++;

            }else{

                head = tail + 1;

                if(head+1 > processes.length){
                    isFinished = true;
                }else{
                    checkCurrentRemProcesses();

                    i = head;
                }

            }

        }

    }

    public Process[] getProcesses() {
        return processes;
    }



}
