package admin.dao;


import admin.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface StaffDao {
    ArrayList<HashMap<String,Object>> allStaffMessage(@Param("startIndex") Integer startIndex, @Param("endIndex") Integer endIndex, @Param("eid") Integer eid
            , @Param("ename") String ename, @Param("tel") String tel, @Param("job") String job, @Param("password") String password,@Param("headMaster") String headMaster);

    int deleteStaffMessage(Integer eid);

    int updateStaffMessage(Staff staff);

    int insertStaffMessage(Staff staff);

    int getStaffMessageCount(@Param("headMaster")String headMaster,@Param("ename") String ename, @Param("job") String job);

    int deleteStaffSomeMessage(List<Integer> ids);

    ArrayList<HashMap<String,Object>> staffCount(@Param("start") Integer startIndex,@Param("endIndex") Integer endIndex,@Param("ename") String ename);

}


