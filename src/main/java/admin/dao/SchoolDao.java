package admin.dao;

import admin.model.School;
import admin.model.Staff;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SchoolDao {
    ArrayList<HashMap<String,Object>> allSchoolMessage(@Param("startIndex") Integer startIndex, @Param("endIndex") Integer endIndex, @Param("id") Integer id
            , @Param("uname") String uname, @Param("uaddr") String uaddr, @Param("ename") String ename);
    int deleteSchoolMessage(Integer id);
    int updateSchoolMessage(School school);
    int insertSchoolMessage(School school);

    int getSchoolMessageCount(String uname);

    int deleteSchoolSomeMessage(List<Integer> ids);

    List<Map<String,Object>> getStaffName();

    ArrayList<HashMap<String,Object>> studentCount(@Param("start") Integer startIndex,@Param("endIndex") Integer endIndex,@Param("uname") String uname);
}
