

import javax.xml.crypto.URIReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class SimpleTask {
    LocalDate date = LocalDate.now();
    String task;
    boolean valid = false;
    boolean complete = false;
    ArrayList<String>tasks = new ArrayList<>();
    ArrayList<LocalDate> dates = new ArrayList<>();
    ArrayList<String>completedTasks= new ArrayList<>();
    ArrayList<LocalDate> completeDates = new ArrayList<>();

    protected boolean valid(String s) {
        try {
            date = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (!date.isBefore(LocalDate.now())) {
                valid = true;
            } else {
                valid = false;
                System.out.println("Date must be today or a future date.");
            }
        } catch (DateTimeParseException e) {
            valid = false;
            System.out.println("Please enter the correct format (yyyy-MM-dd).");
        }
        return valid;
    }
    protected void sort() {

        ArrayList<Integer> indices = new ArrayList<>();

        for (int i = 0; i < dates.size(); i++) indices.add(i);
        indices.sort((i, j) -> {
            long diff1 = Math.abs(dates.get(i).toEpochDay() - LocalDate.now().toEpochDay());
            long diff2 = Math.abs(dates.get(j).toEpochDay() - LocalDate.now().toEpochDay());
            return Long.compare(diff1, diff2);
        });

        // Rearrange tasks and dates based on sorted indices
        ArrayList<String> sortedTasks = new ArrayList<>();
        ArrayList<LocalDate> sortedDates = new ArrayList<>();

        for (int index : indices) {
            sortedTasks.add(tasks.get(index));
            sortedDates.add(dates.get(index));
        }

        tasks = sortedTasks;
        dates = sortedDates;
    }
    @Override
    public String toString() {
        return  getClass().getName();
    }
    final public void add(String title, String description) {

        add(title, description, LocalDate.now().toString());
    }

    public void add(String title ,String description,String date )
    {
        if(valid(date)) {
            this.task = title +":\t"+description;
            sort();
            tasks.add(task);
            dates.add(this.date);
        }
    }


    public void update(int i,String newtitle, String newdescription) {
        update(i,newtitle, newdescription, LocalDate.now().toString());
    }
    public void update(int index, String newTitle, String newDescription, String newDate) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index!");
            return;
        }
            if (valid(newDate))
            {
                task = newTitle + ":\t" + newDescription;
                tasks.set(index, task);
                dates.set(index, date);
                sort(); // Re-sort tasks after update
                System.out.println("Task updated successfully.");

            }
    }
    public void delete(int index )
    {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task index!");
            return;
        }
        tasks.remove(index);
        dates.remove(index);
        System.out.println("you have deleted successfully");
    }

    public void setComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index);
            LocalDate d = dates.get(index);
            complete = true;
            completedTasks.add(task);
            completeDates.add(d);
            tasks.remove(index);
            dates.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }



    public void print()
    {
        if (tasks.isEmpty()&&dates.isEmpty()) {
            System.out.println("List is Empty.");
        }
        sort();
        for (int i = 0 ; i < tasks.size();i++)
        {
            System.out.println("Task ("+i+")\t"+"date: " + dates.get(i) + "\t" + tasks.get(i) +"\t"+ complete);
        }
    }

    void printCompletedTasks() {

            if (completedTasks.isEmpty()) {
                System.out.println("List is Empty.");
            }

                for (int i = 0 ; i < completedTasks.size();i++)
                {
                    System.out.println("Task ("+i+")\t"+"date: " + completeDates.get(i) + "\t" + completedTasks.get(i));
                }
        }
    }








