package org.dj;

import java.util.Date;

public class Process implements Comparable<Process> {

    private int PID;

    private String name;

    private Date createdAt;

    private Date updatedAt;

    private int quantum;

    private int priority;

    public Process(String name, int quantum, int priority, int PID) {
        this.PID = PID;
        this.name = name;
        createdAt = new Date();
        updatedAt = new Date();
        this.quantum = quantum;
        this.priority = priority;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
        updatedAt = new Date();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }

    public int getPID() {
        return PID;
    }

    @Override
    public int compareTo(Process o) {

        if(getPriority() == o.getPriority()){

            return getUpdatedAt().compareTo(o.getUpdatedAt());

        }else{

            return getPriority() - o.getPriority();

        }

    }

}
