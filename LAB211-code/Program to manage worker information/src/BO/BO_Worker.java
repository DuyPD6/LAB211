package BO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Model.History;
import Model.Worker;

public class BO_Worker {
    private List<Worker> listWorker = null;
    private List<History> listHistory = null;

    public BO_Worker() {
        listWorker = new ArrayList<Worker>();
        listHistory = new ArrayList<History>();
    }

    public void addWorker(String id, String name, int age, int salary, String workLocation) {
        Worker worker = new Worker(id, name, age, salary, workLocation);
        listWorker.add(worker);
    }

    public Worker getWorkerByCode(String id) {
        for (Worker worker : listWorker) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    public boolean checkIDExisted(String id) {
        for (Worker worker : listWorker) {
            if (worker.getId().trim().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public void addHistory(String status, String date, String id, String name, int age, int salary,
            String workLocation) {
        History history = new History(id, name, age, salary, workLocation, status, date);
        listHistory.add(history);
    }

    public List<History> getAllHistories() {
        return listHistory;
    }

    public String changeSalary(int salaryUpdate, String flag) {
        for (Worker worker : listWorker) {
            int salaryCurrent = worker.getSalary();
            if (flag.trim().equalsIgnoreCase("1")) {
                worker.setSalary(salaryUpdate + salaryCurrent);
                return "Add Successfully";
            }
            if (flag.trim().equalsIgnoreCase("0")) {
                if (salaryUpdate > salaryCurrent) {
                    return "Down salary cannot be higher than " + (salaryCurrent-1);
                } else {
                    worker.setSalary(salaryCurrent - salaryUpdate);
                    return "Add Successfully";
                }
            } else {
                return "Add error!";
            }
        }
        return null;
    }

}
