package admin.service;

import admin.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface StaffService {

    ArrayList<HashMap<String,Object>> allStaffMessage(Integer startIndex,Integer endIndex, Integer eid
            , String ename, String tel, String job,String password,String headMaster);

    boolean deleteStaffMessage(Integer eid);

    boolean updateStaffMessage(Staff staff);

    boolean insertStaffMessage(Staff staff);

    int getStaffMessageCount(String headMaster,String ename,String job);
    //实现批量删除
    boolean deleteStaffSomeMessage(List<Integer> ids);

    //统计人数
    ArrayList<HashMap<String,Object>> staffCount(Integer startIndex,Integer endIndex,String ename);


}
