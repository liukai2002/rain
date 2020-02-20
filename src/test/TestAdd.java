package test;

import dao.RainManageDao;
import entity.RainQuality;
import service.RainMangerService;

import java.util.Date;

public class TestAdd {
    public static void main(String[] args) {
        RainMangerService service = new RainMangerService();
        RainQuality rain = new RainQuality();
        rain.setRain(3);
        rain.setDistrictName("河北省");
        rain.setMonitoringStation("邯郸市");
        rain.setMonitoringAddress("市区");
        rain.setMonitorTime(new Date());
        System.out.println(service.addNewRainInfo(rain));
    }
}
