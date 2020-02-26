package web;

import com.sun.org.apache.xpath.internal.SourceTree;
import entity.RainQuality;
import service.RainMangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addServlet",urlPatterns = {"/add"})
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
       request.setCharacterEncoding("utf-8");
        //调用service层新增雨量信息的方法
        RainMangerService rainMangerService = new RainMangerService();
        //获取参数
       String districtName = request.getParameter("districtName");
       String monitorTime =request.getParameter("monitorTime");
       int rain1 =Integer.valueOf(request.getParameter("rain"));
       String monitoringStation =request.getParameter("monitoringStation");
       String monitoringAddress =request.getParameter("monitoringAddress");
         //把参数封装到对象中
        RainQuality rainQuality = new RainQuality();
        //String转换为Date
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date date =sdf.parse(monitorTime);
            rainQuality.setMonitorTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        rainQuality.setDistrictName(districtName);
        rainQuality.setRain(rain1);
        rainQuality.setMonitoringStation(monitoringStation);
        rainQuality.setMonitoringAddress(monitoringAddress);
        //执行添加的方法
        int i =rainMangerService.addNewRainInfo(rainQuality);
        if(i==1){
            System.out.println("添加成功");
            request.getRequestDispatcher("index").forward(request,response);
        }else {
            System.out.println("添加失败！");
            response.sendRedirect("add.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
