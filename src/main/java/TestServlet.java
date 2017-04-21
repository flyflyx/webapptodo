import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yaskovich Dmitry on 14/04/2017.
 */
public class TestServlet extends HttpServlet {
   // private Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);
    private TodoList list = new TodoList();
    {list.add("Example task");}
//    {list.add("Example task");
//        try{
//            cfg.setTemplateLoader(new FileTemplateLoader(new File(".")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Template t=cfg.getTemplate("todo.html");
        StringBuilder buf = new StringBuilder();
        List<Task> tasks = list.view();
        for (Task t : tasks) {
            buf.append("<li>" + t.getTaskName() + "</li>\n");
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>To-Do List</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"add\">\n" +
                "    Add task:<input name=\"task\">\n" +
                "    <input type=\"submit\" value=\"add\">\n" +
                "</form>\n" +
                "<form method=\"post\" action=\"remove\">\n" +
                "    Remove task:<input name=\"taskID\">\n" +
                "    <input type=\"submit\" value=\"remove\">\n" +
                "</form>\n" +
                "<ol>\n" +
                buf +
                "</ol>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String what=req.getParameter("task");
        String whatID=req.getParameter("taskID");
        if (what!=null && what.length()>0)
            list.add(what);
        if (whatID!=null && whatID.length()>0)
            list.delete(Integer.parseInt(whatID));
        resp.sendRedirect("/");
    }
}
