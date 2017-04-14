import java.util.Scanner;

/**
 * Created by admin on 14.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to add task. Press 2 to delete task. Press 3 to view tasks.");
            String cmd = s.nextLine();
            switch (cmd) {
                case "1":
                    System.out.println("Enter new task");
                    String action = s.nextLine();
                    list.add(action);
                    break;
                case "2":
                    System.out.println("Enter task id to delete");
                    int number = Integer.parseInt(s.nextLine());
                    list.delete(number);
                    break;
                case "3":
                    for(int i=0;i<=list.view().size();i++)
                        System.out.println(list.view());
                    break;
            }
        }
    }
}
