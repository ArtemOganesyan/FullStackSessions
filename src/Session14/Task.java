package Session14;

public class Task {
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task name: " + name + " priority: " + priority;
    }
}
