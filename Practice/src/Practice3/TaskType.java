package Practice3;

public enum TaskType {
    WORK("WORK"),
    PERSONAL("PERSONAL"),
    SHOPPING("SHOPPING"),
    CORPORATE("CORPORATE");
    private final String TaskType;

    TaskType(String taskType) {
        TaskType = taskType;
    }
}