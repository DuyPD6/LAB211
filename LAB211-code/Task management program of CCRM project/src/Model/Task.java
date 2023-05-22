package Model;

import java.util.Objects;

public class Task {
    private int taskID;
    private String taskTypeID;
    private String requirementName;
    private String date;
    private double plantFrom;
    private double plantTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int taskID, String taskTypeID, String requirementName, String date, double plantFrom, double plantTo,
            String assignee, String reviewer) {
        this.taskID = taskID;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.plantFrom = plantFrom;
        this.plantTo = plantTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getTaskID() {
        return this.taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskTypeID() {
        return this.taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return this.requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlantFrom() {
        return this.plantFrom;
    }

    public void setPlantFrom(double plantFrom) {
        this.plantFrom = plantFrom;
    }

    public double getPlantTo() {
        return this.plantTo;
    }

    public void setPlantTo(double plantTo) {
        this.plantTo = plantTo;
    }

    public String getAssignee() {
        return this.assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return this.reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "{" +
                " taskID='" + getTaskID() + "'" +
                ", taskTypeID='" + getTaskTypeID() + "'" +
                ", requirementName='" + getRequirementName() + "'" +
                ", date='" + getDate() + "'" +
                ", plantFrom='" + getPlantFrom() + "'" +
                ", plantTo='" + getPlantTo() + "'" +
                ", assignee='" + getAssignee() + "'" +
                ", reviewer='" + getReviewer() + "'" +
                "}";
    }
}
