package org.dj;

public class Queue {

    int count = 0;

    Process[] processes = new Process[50];

    public Process remove(){

        for (Process pr:
             processes) {

            if (pr != null){

                Process process = pr;

                pr = null;

                return process;

            }

        }

        return null;

    }

    public void add(Process process){

        processes[count] = process;

        count++;

    }

    public Process[] runAll(){

        RunningQueue runningQueue = new RunningQueue(processes);

        runningQueue.run();

        return runningQueue.getProcesses();

    }




}
