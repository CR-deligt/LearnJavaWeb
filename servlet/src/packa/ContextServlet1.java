package packa;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取ServletContext对象，是域对象，存取范围是整个web工程
        ServletContext context = getServletContext();
        System.out.println(context);
        System.out.println("保存之前: Context1 获取 key1的值是:"+ context.getAttribute("key1"));//刚创建时null，刷新网页value
        //ServletContext在web工程启动时创建，停止时销毁（中间刷新保留）
        context.setAttribute("key1", "value1");

        System.out.println("Context1 中获取域数据key1的值是:"+ context.getAttribute("key1"));
    }
}
