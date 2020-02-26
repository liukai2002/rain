package dao;

import entity.RainQuality;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RainManageDao extends BaseDao {
    Connection conn;
    PreparedStatement pstmt;
    int rs;

    /**
     * 查询所有的雨量监测信息，并且按照时间倒序排列
     *
     * @return
     */
    public List<RainQuality>getAllInfo(){
        List<RainQuality>rainQualityList = new ArrayList<RainQuality>();
        RainQuality rainQuality = null;
        try{
            String Sql = "select id,districtName,monitorTime,rain,monitoringStation,monitoringAddress from `rainquality` ORDER BY monitorTime DESC";
            conn =BaseDao.getConn();
            pstmt=conn.prepareStatement(Sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                rainQuality = new RainQuality();
                rainQuality.setId(rs.getInt("id"));
                rainQuality.setDistrictName(rs.getString("districtName"));
                rainQuality.setMonitorTime(rs.getDate("monitorTime"));
                rainQuality.setRain(rs.getInt("rain"));
                rainQuality.setMonitoringStation(rs.getString("monitoringStation"));
                rainQuality.setMonitoringAddress(rs.getString("monitoringAddress"));
                rainQualityList.add(rainQuality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rainQualityList;
    }

    /**
     * 新增雨量监测信息
     *
     * @param rain 雨量对象
     * @return 是否添加成功：1表示成功，其他表示失败
     */
    public int addNewRainInfo(RainQuality rain){
        int num=0;
        try{
            StringBuffer Sql = new StringBuffer("insert into rainquality");
            Sql.append("(districtName,monitorTime,rain,monitoringStation,monitoringAddress)");
            Sql.append("values(?,?,?,?,?)");
            conn = BaseDao.getConn();
            pstmt=conn.prepareStatement(Sql.toString());
            pstmt.setObject(1,rain.getDistrictName());
            pstmt.setObject(2,rain.getMonitorTime());
            pstmt.setObject(3,rain.getRain());
            pstmt.setObject(4,rain.getMonitoringStation());
            pstmt.setObject(5,rain.getMonitoringAddress());
            num=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            num=-1;
        }
        return num;
    }

    /**
     * 根据编号删除雨量信息
     * @param id
     * @return
     */
    public int deleteById(String id){
        int num=0;
        try{
            String Sql ="delete from rainquality where id=?";
            conn=BaseDao.getConn();
            pstmt=conn.prepareStatement(Sql);
            pstmt.setObject(1,id);
            num=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            num=-1;
        }
        return num;
    }
}