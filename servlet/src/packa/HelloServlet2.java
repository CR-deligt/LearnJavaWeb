package packa;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);//重写init时为了不丢失先保存config
    }


    /**
     * doGet() 在get请求时调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 get");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        //获取初始化参数的init-param
        System.out.println("初始化username的值是"+ servletConfig.getInitParameter("username"));
        System.out.println("初始化url的值是"+ servletConfig.getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 post");
    }
}
