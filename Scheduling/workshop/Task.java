package workshop;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import scheduling.Scheduling;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


public class Task implements Comparable<Task>{
    private final static int MIN_PROCESSING_TIME = 50;
    private static int last_id =0;
    private int id;
    private int processingTime;
    private int startingTime;
    private int deadline;
    private double unitPenaltyCost;

    public Task() {
        last_id++;
        this.id = last_id;
        this.processingTime = MIN_PROCESSING_TIME;
        this.startingTime = 0;
        this.deadline = Integer.MAX_VALUE;
        this.unitPenaltyCost = 0;
    }

    public Task(int processingTime) {
        this();
        if (processingTime > MIN_PROCESSING_TIME) this.processingTime = processingTime;
    }




    public Task(int processingTime, int deadline, double unitPenaltyCost) {
        this(processingTime);
        this.deadline = deadline;
        this.unitPenaltyCost = unitPenaltyCost;
    }


    public Task(int processingTime, int deadline, double unitPenaltyCost, int id) {
        this(processingTime, deadline, unitPenaltyCost);
        this.id = id;
    }

    public Task(Task t){
        this(t.getProcessingTime(), t.getDeadline(), t.unitPenaltyCost, t.getId());
        }


    public int getId() {
        return id;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getStartingTime() {
        return startingTime;
    }

    public int getDeadline() {
        return deadline;
    }

    public double getUnitPenaltyCost() {
        return unitPenaltyCost;
    }

    public void setStartingTime(int startingTime) {
        this.startingTime = startingTime;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj!=null && obj instanceof Task){
            Task t = (Task) obj;
            return this.getId() == t.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getProcessingTime();
    }

    @Override
    public int compareTo(Task t) {
        if (t==null) return 1;
        if (equals(t)) return 0;

        int a = this.processingTime - t.getProcessingTime();
        if(a!=0) return a;
        return id - t.getId();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", processingTime=" + processingTime +
                ", startingTime=" + startingTime +
                ", deadline=" + deadline +
                ", unitPenaltyCost=" + unitPenaltyCost +
                '}';
    }

    public static void main(String[] args) {
        /*Task T1 = new Task();
        Task T2 = new Task(49);
        Task T3 = new Task(51);
        Task T4 = new Task(60,1000,50);
        System.out.println(T1.toString());
        System.out.println(T2.toString());
        System.out.println(T3.toString());
        System.out.println(T4.toString());
        T4.setStartingTime(20);
        System.out.println(T4.toString());*/

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(100));
        tasks.add(new Task(150));
        List<Task> copyTasks = Scheduling.copyTasks(tasks);
        copyTasks.add(new Task(400));
        System.out.println("Initial number of tasks: " + tasks.size());
        System.out.println("Final number of tasks: " + copyTasks.size());


        Task T1 = new Task(100);
        Task T2 = new Task(T1);
        Task T3 = T1;

        Task T4 = new Task(50);
        Task T5 = new Task(100);
        System.out.println(T1.equals(T2));
        System.out.println(T1.equals(T3));
        System.out.println(T2.equals(T3));

        System.out.println(T1.compareTo(T2));
        System.out.println(T1.compareTo(T4));
        System.out.println(T1.compareTo(T5));




    }

}
