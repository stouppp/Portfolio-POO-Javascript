package scheduling;

import workshop.Task;
import workshop.Workshop;

import java.util.List;

public class SchedulingIncreasingTime implements Scheduling{

    @Override
    public Workshop schedule(int nb_machines, List<Task> tasks) {
        Workshop W = new Workshop(nb_machines);
        List<Task> copiedTasks = Scheduling.copyTasks(tasks);

        copiedTasks.sort(Task::compareTo);
        W.scheduleTasks(copiedTasks);
        return W;
    }
}
