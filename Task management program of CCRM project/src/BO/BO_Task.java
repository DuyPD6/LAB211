package BO;

import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class BO_Task {
    private List<Task> listTasks = null;

    public BO_Task() {
        listTasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        listTasks.add(task);
    }

    public boolean deleteTask(int taskID) {
        for (Task task : listTasks) {
            if (taskID == task.getTaskID()) {
                listTasks.remove(task);
                return true;
            }
        }
        return false;
    }

    public boolean checkTaskExist(String name, String taskType, String date, Double from, Double to, String assignee,
            String review) {
        for (Task task : listTasks) {
            if (task.getDate().trim().equalsIgnoreCase(date.trim())
                    && task.getAssignee().trim().equalsIgnoreCase(assignee.trim())) {
                if ((from < task.getPlantFrom() && to > task.getPlantTo())
                        || (task.getPlantFrom() < from && from < task.getPlantTo())
                        || (task.getPlantFrom() < to && to < task.getPlantTo())
                        || task.getPlantFrom() == from || to == task.getPlantTo()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public List<Task> getDataTasks() {
        return listTasks;
    }
}
