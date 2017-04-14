import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 14.04.2017.
 */
public class TodoList {
    private int id = -1;
    private final ArrayList<Task> todoList = new ArrayList();

    public int add(String taskName) {
        id++;
        todoList.add(new Task(id, taskName));
        return id;
    }

    public boolean delete(int id) {
        for (Task taskObject : todoList) {
            if (taskObject.getId() == id) {
                todoList.remove(taskObject);
                return true;
            }
        }
        return false;
    }

    public List<Task> view() {
        return todoList;
    }
}
