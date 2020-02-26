package test;

import entity.RainQuality;
import service.RainMangerService;

import java.util.Date;

public class AddTest {
    public static void main(String[] args) {
        RainMangerService service = new RainMangerService();
        RainQuality rain = new RainQuality();
        rain.setRain(7);
        rain.setDistrictName("北京市");
        rain.setMonitoringStation("昌平区");
        rain.setMonitoringAddress("商业街");
        rain.setMonitorTime(new Date());
        System.out.println(service.addNewRainInfo(rain));
    }
}
