import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 14.04.2017.
 */
public class TodoList {
    private int id = 0;
    private final ArrayList<Task> todoList = new ArrayList();

    public int add(String taskName) {
        todoList.add(new Task(id, taskName));
        id++;
        return (id - 1);
    }

    public void delete(int id) {
        todoList.remove(id);

    }

    public List<Task> view() {
        return todoList;
    }

    @Override
    public String toString() {
        return "empty";
    }
}
