package Practice3;

public class Main{
    public static void main(String[] args) {
        TaskManager<Task> taskManager = new TaskManager();

        taskManager.addTask(new Task(1, "Do the laundry", TaskType.PERSONAL));
        taskManager.addTask(new Task(2, "Call your boss", TaskType.CORPORATE));

        taskManager.listTasks();

        taskManager.markAsCompleted(2);

        taskManager.listTasks();

        taskManager.removeTask(1);

        taskManager.listTasks();

    }
}
