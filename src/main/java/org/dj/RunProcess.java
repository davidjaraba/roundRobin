package org.dj;

public class RunProcess {

    int minPrio = 0;
    int maxPrio = 8;

    int minQuantum = 1;
    int maxQuantum = 100;

    RunProcess(){

        Process[] processes = new Process[50];

        for (int i = 0; i < processes.length; i++) {

            processes[i] = new Process(
                    "Process_" + i+".exe",
                    (int) (Math.random() * (maxQuantum - minQuantum + 1) + minQuantum),
                    (int) (Math.random() * (maxPrio - minPrio + 1) + minPrio), i
            );

            System.out.println(processes[i].getName() + " " + processes[i].getQuantum() + " " + processes[i].getPriority());


        }

        RoundRobin roundRobin = new RoundRobin(processes);

        roundRobin.run();



    }







}
