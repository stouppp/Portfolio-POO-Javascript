package workshop;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;


public class Machine {
    private static int last_id =0;
    private int id;
    private int completionTime;
    private double penaltyCost;
    private List<Task> tasks;

    public Machine() {
        last_id++;
        id = last_id;
        completionTime = 0;
        penaltyCost = 0;
        tasks = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public double getPenaltyCost() {
        return penaltyCost;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public void setPenaltyCost(double penaltyCost) {
        this.penaltyCost = penaltyCost;
    }

    public boolean addTask(Task t){
        if (t!=null && this !=null){
            tasks.add(t);
            t.setStartingTime(completionTime);
            this.completionTime += t.getProcessingTime();
            this.penaltyCost += t.getUnitPenaltyCost()*Math.max(this.completionTime-t.getDeadline(),0);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "Machine{" +
                "id=" + id +
                ", completionTime=" + completionTime +
                ", penaltyCost=" + penaltyCost +
                ", tasks=[";
        for (Task elem : tasks){
            s+= "\n" + elem + ',';
        }
        s+="]}";
        return s;
    }

    public static void main(String[] args) {
        Machine M1 = new Machine();
        System.out.println(M1.toString());
        Task T1 = new Task(150,300,2.5);
        Task T2 = new Task(140,400,1.5);
        Task T3 = new Task(50,200,2.5);
        Task T4 = new Task(85,200,1.0);
        Task T5 = new Task(75,160,0.5);
        Task T6 = new Task(80,500,1.5);
        System.out.println(M1.addTask(T1));
        System.out.println(M1.addTask(T2));
        System.out.println(M1.addTask(T3));
        System.out.println(M1.addTask(T4));
        System.out.println(M1.addTask(T5));
        System.out.println(M1.addTask(T6));
        System.out.println(M1.toString());
    }
}
