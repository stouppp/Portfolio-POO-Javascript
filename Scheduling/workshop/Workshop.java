package workshop;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Workshop {
    private int nb_machines;
    private int totalCompletionTime;
    private double totalPenaltyCost;
    private List<Machine> machines;

    public Workshop(int nb_machines) {
        if (nb_machines>1) this.nb_machines=nb_machines;
        else this.nb_machines=1;

        machines = new ArrayList<>();
        for (int i=0;i<this.nb_machines;i++){
            Machine M = new Machine();
            if (M!=null) machines.add(M);
        }
        totalCompletionTime=0;
        totalPenaltyCost=0;
    }

    public int getNb_machines() {
        return nb_machines;
    }

    public int getTotalCompletionTime() {
        return totalCompletionTime;
    }

    public double getTotalPenaltyCost() {
        return totalPenaltyCost;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void updateCriteria(){
        for (Machine m : machines){
            totalPenaltyCost+=m.getPenaltyCost();
            totalCompletionTime = Math.max(totalCompletionTime,m.getCompletionTime());
        }
    }

    private Machine getMachine(int posMachine){
        if (posMachine < nb_machines) return this.getMachines().get(posMachine);
        return null;
    }

    private boolean addTask(Task t, int posMachine){
        return this.getMachine(posMachine).addTask(t);
    }

    private int getIdMachineSmallestCompletionTime(){
        int smallestCompletionTime = this.getMachine(0).getCompletionTime();
        int pos=0;
        for (int i=1;i<nb_machines;i++){
            if (getMachine(i).getCompletionTime() < smallestCompletionTime) pos = i;
        }
        return pos;
    }

    public void scheduleTasks(List<Task> tasks){
        int pos;
        for(Task t : tasks){
            if (t!=null){
                pos = getIdMachineSmallestCompletionTime();
                addTask(t,pos);
            }

        }
        updateCriteria();
    }


    public void display(boolean verbose){
        System.out.println("" + getTotalCompletionTime());
        System.out.println(""+getTotalPenaltyCost());
        if (verbose) {
            System.out.println(toString());
        }
    }



    @Override
    public String toString() {
        String s = "Workshop{" +
                "nb_machines=" + nb_machines +
                ", totalCompletionTime=" + totalCompletionTime +
                ", totalPenaltyCost=" + totalPenaltyCost +
                ", machines=[\n";
        for (Machine elem : machines){
            s+= "\n" + elem + ",\n";
        }
        s+="]}";
        return s;
    }

    public static void main(String[] args) {
        Workshop W = new Workshop(2);
        Task T1 = new Task(150,300,2.5);
        Task T2 = new Task(140,400,1.5);
        Task T3 = new Task(50,200,2.5);
        Task T4 = new Task(85,200,1.0);
        Task T5 = new Task(75,160,0.5);
        Task T6 = new Task(80,500,1.5);
        List<Task> testTasks = new LinkedList<>() ;
        testTasks.add(T1);
        testTasks.add(T2);
        testTasks.add(T3);
        testTasks.add(T4);
        testTasks.add(T5);
        testTasks.add(T6);
        System.out.println(W.toString());
        W.scheduleTasks(testTasks);
        System.out.println(W.toString());


        W.display(false);
        W.display(true);


    }
}
