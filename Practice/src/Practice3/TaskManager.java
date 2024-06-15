package Practice3;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class TaskManager<T extends Task> {
    private List<T> tasks = new ArrayList<>();
    Supplier<LocalDateTime> dateSupplier = () -> LocalDateTime.now();

    public void listTasks(){
        System.out.println(dateSupplier.get());
        for(Task t: tasks){
            System.out.printf("Id: %d, Description: %s, Type: %s, Completed: %b%n", t.id, t.description, t.type, t.completed);
        }
        System.out.println();
    }
    public void addTask(T task){
        tasks.add(task);
    }
    public void removeTask(int id){
        for(Task t: tasks){
            if(t.id == id){
                tasks.remove(t);
            }
        }
    }
    public void markAsCompleted(int id){
        for(Task t: tasks){
            if(t.id == id){
                t.setCompleted(true);
                return;
            }
        }
        System.out.println("No tasks with such id found");
    }
}
