package registration1;

import javax.swing.*;
import java.util.ArrayList;

public class TaskDetails {
    // Task variables as ArrayLists
    private static ArrayList<String> taskNames = new ArrayList<>();
    private static ArrayList<String> developers = new ArrayList<>();
    private static ArrayList<String> taskStatuses = new ArrayList<>();
    private static ArrayList<String> taskDescriptions = new ArrayList<>();
    private static ArrayList<String> taskIDs = new ArrayList<>();
    private static ArrayList<Integer> taskDurations = new ArrayList<>();

    private static int totalHours = 0;  // Total hours for all tasks
    private static int numberOfTasks;

    static int getNumberOfTasks() {
   
        return numberOfTasks; // Return the total number of tasks
}

    // Add a Task method
    public void addTasks() {
        int numberOfTasks;
        try {
            numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks you want to add:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Number of tasks should be an integer!");
            return;
        }

        for (int i = 0; i < numberOfTasks; i++) {
            // Task Name
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            taskNames.add(taskName);

            // Developer Name
            String developerName = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
            developers.add(developerName);

            // Task Description
            String description;
            while (true) {
                description = JOptionPane.showInputDialog("Enter Task Description (Max 50 characters):");
                if (description.length() <= 50) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Description too long. Please try again.");
                }
            }
            taskDescriptions.add(description);

            // Task Status
            String[] statusOptions = {"To Do", "Doing", "Done"};
            String status = (String) JOptionPane.showInputDialog(
                    null, "Select Task Status:", "Task Status",
                    JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
            taskStatuses.add(status);

            // Task Duration
            int duration;
            try {
                duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
                taskDurations.add(duration);
                totalHours += duration;  // Accumulate total hours
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Task duration should be an integer!");
                taskDurations.add(0);
            }

            // Generate Task ID
            String taskID = createTaskID(taskName, i + 1, developerName);
            taskIDs.add(taskID);

            // Display Task Details
            JOptionPane.showMessageDialog(null, printTaskDetails(i));
        }

        // Display total hours after all tasks are entered
        JOptionPane.showMessageDialog(null, "Total Hours for All Tasks: " + totalHours + " hours");
    }

    // Method to generate a Task ID
    public String createTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
               developer.substring(developer.length() - 3).toUpperCase();
    }

    // Print task details for a specific task
    public String printTaskDetails(int index) {
        return "Task Name: " + taskNames.get(index) +
               "\nDeveloper: " + developers.get(index) +
               "\nTask Status: " + taskStatuses.get(index) +
               "\nTask Description: " + taskDescriptions.get(index) +
               "\nTask ID: " + taskIDs.get(index) +
               "\nTask Duration: " + taskDurations.get(index) + " hours";
    }

    // Welcome Menu with Options
    public int welcomeAndChooseOption(boolean login) {
        int chosenOption = 0;

        if (login) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

            do {
                try {
                    chosenOption = Integer.parseInt(JOptionPane.showInputDialog(
                            "PLEASE SELECT AN OPTION\n"
                            + "1) Add Tasks\n"
                            + "2) Show Report\n"
                            + "3) Quit"));

                    switch (chosenOption) {
                        case 1: // Add Tasks
                            addTasks();
                            break;
                        case 2: // Show Report
                              /*
                    Pass the five parallel arrays to the manipulateArrays method.
                    */
                    if (developers != null){
                        TaskManager.getArrays(developers, taskNames, taskIDs, taskStatuses, taskDurations);
                        TaskManager.manipulateArrays();
                    }
                    // The user can only view a report after they have populated the arrays
                    else{
                        JOptionPane.showMessageDialog(null,"Add tasks to view a report!!");
                    }
                            break;
                        case 3: // Quit
                            JOptionPane.showMessageDialog(null, "Goodbye!");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid option! Please choose between 1, 2, or 3.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 1 and 3.");
                }
            } while (chosenOption != 3);
        }

        return chosenOption;
    }

    // Method to show report of all tasks
    public void showReport() {
        StringBuilder report = new StringBuilder("TASK REPORT:\n\n");
        for (int i = 0; i < taskNames.size(); i++) {
            report.append(printTaskDetails(i)).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}
