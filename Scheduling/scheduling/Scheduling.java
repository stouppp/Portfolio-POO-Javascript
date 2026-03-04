package scheduling;

import workshop.Workshop;
import workshop.Task;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public interface Scheduling {
    Workshop schedule(int nb_machines, List<Task> tasks);
    public static List<Task> copyTasks(List<Task> tasks){
        List<Task> copiedTasks = new LinkedList<>();
        for (Task t : tasks){
            Task copiedTask = new Task(t);
            copiedTasks.add(copiedTask);
        }
        return copiedTasks;
    }
}

