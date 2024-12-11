import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class to represent a task
class Task {
    private int id;
    private String name;
    private String category;
    private String priority;
    private String deadline;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String name, String category, String priority, String deadline) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.isCompleted = false;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPriority() {
        return priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
                ", Name: " + name +
                ", Category: " + category +
                ", Priority: " + priority +
                ", Deadline: " + deadline +
                ", Completed: " + (isCompleted ? "Yes" : "No");
    }
}

// TaskManager class to manage tasks
class TaskManager {
    private List<Task> taskList = new ArrayList<>();
    private int taskIdCounter = 1;

    // Add a new task
    public void addTask(String name, String category, String priority, String deadline) {
        Task task = new Task(taskIdCounter++, name, category, priority, deadline);
        taskList.add(task);
        System.out.println("Task added successfully.");
    }

    // View all tasks
    public void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : taskList) {
            System.out.println(task);
        }
    }

    // Mark a task as completed
    public void markTaskAsCompleted(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                task.markAsCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    // Delete a task
    public void deleteTask(int taskId) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                taskList.remove(task);
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }
}

// Main class
public class SmartTaskManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("\n=== Smart Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Task
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter task priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();
                    System.out.print("Enter task deadline (YYYY-MM-DD): ");
                    String deadline = scanner.nextLine();
                    taskManager.addTask(name, category, priority, deadline);
                    break;

                case 2: // View Tasks
                    taskManager.viewTasks();
                    break;

                case 3: // Mark Task as Completed
                    System.out.print("Enter task ID to mark as completed: ");
                    int taskIdToComplete = scanner.nextInt();
                    taskManager.markTaskAsCompleted(taskIdToComplete);
                    break;

                case 4: // Delete Task
                    System.out.print("Enter task ID to delete: ");
                    int taskIdToDelete = scanner.nextInt();
                    taskManager.deleteTask(taskIdToDelete);
                    break;

                case 5: // Exit
                    System.out.println("Exiting... Thank you for using Smart Task Manager!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
