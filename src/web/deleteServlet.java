package web;

import entity.RainQuality;
import service.RainMangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteServlet",urlPatterns = {"/del"})
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实例化Srevice对象
      RainMangerService rainMangerService = new RainMangerService();
        //从表单的name属性获取庾亮的信息编号
        String id = request.getParameter("rId");
//        System.out.println(id);
        //把flag打印到页面，作为回调函数data处理的内容
        int i =rainMangerService.deleteById(id);
        boolean flag = false;
        if(i==1){
            flag=true;
        }else {
            flag=false;
        }
        PrintWriter out =response.getWriter();
        out.print(flag);
        out.flush();//刷新
        out.close();//关闭
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
