package registration1;

import javax.swing.*;
import java.util.ArrayList;

public class TaskManager {

    // Task variables
    static ArrayList<String> developerNames = new ArrayList<>();
    static ArrayList<String> taskNames = new ArrayList<>();
    static ArrayList<String> taskIDs = new ArrayList<>();
    static ArrayList<String> taskStatuses = new ArrayList<>();
    static ArrayList<Integer> taskDurations = new ArrayList<>();

    static String devNames; 
    static String search; 
    static String t_name; 
    static String choice = "";

    public static void getArrays(
            ArrayList<String> developers,
            ArrayList<String> tasks,
            ArrayList<String> ids,
            ArrayList<String> statuses,
            ArrayList<Integer> durations) {
        developerNames = new ArrayList<>(developers);
        taskNames = new ArrayList<>(tasks);
        taskIDs = new ArrayList<>(ids);
        taskStatuses = new ArrayList<>(statuses);
        taskDurations = new ArrayList<>(durations);
    }

    // Menu to manipulate task arrays
    public static void manipulateArrays() {
        do {
            choice = JOptionPane.showInputDialog("Enter\n"
                    + "a -> To view the list of all tasks with the status of Done\n"
                    + "b -> To view the name of the developer whose task takes the longest to complete\n"
                    + "c -> To search for a Task\n"
                    + "d -> To view the list of tasks assigned to a developer\n"
                    + "e -> To delete a task\n"
                    + "f -> To get a report of all the captured Tasks\n"
                    + "q -> To Quit");

            switch (choice.toLowerCase()) {
                case "a":
                    JOptionPane.showMessageDialog(null, doneTasks());
                    break;
                case "b":
                    JOptionPane.showMessageDialog(null, longestTask());
                    break;
                case "c":
                    search = JOptionPane.showInputDialog("Enter the name of the task to be searched:");
                    JOptionPane.showMessageDialog(null, searchTask(search));
                    break;
                case "d":
                    devNames = JOptionPane.showInputDialog("Enter the developer's full name:");
                    JOptionPane.showMessageDialog(null, developerTasks(devNames));
                    break;
                case "e":
                    t_name = JOptionPane.showInputDialog("Enter the name of the task to be deleted:");
                    JOptionPane.showMessageDialog(null, deleteTask(t_name));
                    break;
                case "f":
                    displayReport();
                    break;
                case "q":
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input. Try again.");
            }
        } while (!choice.equalsIgnoreCase("q"));
    }

    // View tasks with the status "Done"
    public static String doneTasks() {
        StringBuilder doneTaskList = new StringBuilder("Tasks with status 'Done':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if ("Done".equalsIgnoreCase(taskStatuses.get(i))) {
                doneTaskList.append("Task Name: ").append(taskNames.get(i))
                        .append(", Developer: ").append(developerNames.get(i))
                        .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        return doneTaskList.length() > 0 ? doneTaskList.toString() : "No tasks with status 'Done'.";
    }

    // Find the task with the longest duration
    public static String longestTask() {
        if (taskDurations.isEmpty()) return "No tasks available.";
        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return "Longest Task:\nDeveloper: " + developerNames.get(maxIndex) +
                "\nDuration: " + taskDurations.get(maxIndex) + " hours";
    }

    // Search for a specific task
    public static String searchTask(String search) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(search)) {
                return "Task Found:\nTask Name: " + taskNames.get(i) +
                        "\nDeveloper: " + developerNames.get(i);
                        
            }
        }
        return "Task not found.";
    }

    // View tasks assigned to a specific developer
    public static String developerTasks(String developer) {
        StringBuilder developerTaskList = new StringBuilder("Tasks assigned to " + developer + ":\n");
        for (int i = 0; i < developerNames.size(); i++) {
            if (developerNames.get(i).equalsIgnoreCase(developer)) {
                developerTaskList.append("Task Name: ").append(taskNames.get(i))
                        .append(", Status: ").append(taskStatuses.get(i)).append("\n");
            }
        }
        return developerTaskList.length() > 0 ? developerTaskList.toString() : "No tasks assigned to this developer.";
    }

    // Delete a specific task
    public static String deleteTask(String taskToDelete) {
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskToDelete)) {
                taskNames.remove(i);
                developerNames.remove(i);
                taskIDs.remove(i);
                taskStatuses.remove(i);
                taskDurations.remove(i);
                return "Task  "+ taskToDelete + " has been deleted successfully.";
            }
        }
        return "Task  "+ taskToDelete + " has been deleted successfully.";
    }

    // Display a report of all tasks
    public static void displayReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task Name: ").append(taskNames.get(i))
                    .append("\nDeveloper: ").append(developerNames.get(i))
                    .append("\nTask ID: ").append(taskIDs.get(i))
                    .append("\nStatus: ").append(taskStatuses.get(i))
                    .append("\nDuration: ").append(taskDurations.get(i)).append(" hours\n\n");
        }
        JOptionPane.showMessageDialog(null, report.length() > 0 ? report.toString() : "No tasks available.");
    }
}
