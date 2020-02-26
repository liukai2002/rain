package service;

import dao.RainManageDao;
import entity.RainQuality;

import java.util.List;

public class RainMangerService {
    private RainManageDao rainManageDao = new RainManageDao();
    public List<RainQuality>getAllInfo(){
        return rainManageDao.getAllInfo();
    }
    //新增雨量
    public int addNewRainInfo(RainQuality rain){
        return rainManageDao.addNewRainInfo(rain);
    }
   //删除
   public int deleteById(String id){
        return rainManageDao.deleteById(id);
   }

}