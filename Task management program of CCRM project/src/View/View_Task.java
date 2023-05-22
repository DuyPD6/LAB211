package View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import BO.BO_Task;
import Model.Task;
import Validation.Validate;

public class View_Task {
    private Validate validate;
    private BO_Task taskBO;

    public View_Task() {
        validate = new Validate();
        taskBO = new BO_Task();
    }

    public void addTask() {
        int id = 1;
        boolean checkExist = false;
        List<Task> listTasks = taskBO.getDataTasks();

        System.out.println("----------------------------Add Task----------------------------");
        String requirementName = validate.getString("Requirement Name: ", "Your requirement name is not valid!",
                "[0-9a-zA-Z ]+");
        String taskType = validate.getTaskType("Task Type: ", "Please input from 1-4!");
        Date dateInput = validate.getDate("Date", "Date must be following format: dd-MM-yyyy ", "dd-MM-yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        String date = sdf.format(dateInput);
        double plantFrom = validate.getDouble("From: ", "Please input from 8.0 to 17.5!", 8, 17.5);
        double plantTo = validate.getDouble("To: ", "Plan to must be from " + plantFrom + " to 17.5 !", plantFrom,
                17.5);
        String assignee = validate.getString("Assignee: ", "Invalid assignee!", "[0-9a-zA-Z ]+");
        String reviewer = validate.getString("Reviewer: ", "Invalid Reviewer", "[0-9a-zA-Z ]+");

        if (!listTasks.isEmpty()) {
            id = listTasks.get(listTasks.size() - 1).getTaskID() + 1;
        }
        checkExist = taskBO.checkTaskExist(requirementName, taskType, date, plantFrom, plantTo, assignee, reviewer);

        if (checkExist) {
            System.err.println("You cannot add duplicate task!");
        } else {
            Task task = new Task(id, taskType, requirementName, date, plantFrom, plantTo, assignee, reviewer);
            taskBO.addTask(task);
            System.out.println("Add successfully");
        }
    }

    public void deleteTask() {
        List<Task> listTasks = taskBO.getDataTasks();
        if (listTasks.isEmpty()) {
            System.err.println("List task is empty!");
        } else {
            System.out.println("----------------------------Delete Task----------------------------");
            int taskID = validate.getInt("ID of task to delete: ", "Task ID is out of range!", 1, Integer.MAX_VALUE);
            if (taskBO.deleteTask(taskID)) {
                System.out.println("Delete Successfully! ");
            } else {
                System.err.println("ID is not existed! ");
            }
        }
    }

    public void getDataTask() {
        List<Task> listTasks = taskBO.getDataTasks();
        if (listTasks.isEmpty()) {
            System.err.println("List of taks is empty!");
        } else {
            System.out.println("----------------------------Task----------------------------");
            System.out.format("%-7s%-20s%-12s%-20s%-20s%-20s%-15s\n", "ID", "Name", "Task type", "Date", "Time",
                    "Assignee", "Reviewer");
            for (Task task : listTasks) {
                System.out.format("%-7s%-20s%-12s%-20s%-20s%-20s%-15s\n", task.getTaskID(), task.getRequirementName(),
                        task.getTaskTypeID(), task.getDate(), task.getPlantTo() - task.getPlantFrom(),
                        task.getAssignee(), task.getReviewer());
            }
        }
    }
}
