package admin.service;

import admin.model.School;
import admin.model.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SchoolService {
    ArrayList<HashMap<String,Object>> allSchoolMessage(Integer startIndex, Integer endIndex, Integer id
            , String uname, String uaddr, String ename);

    boolean deleteSchoolMessage(Integer id);

    boolean updateSchoolMessage(School school);

    boolean insertSchoolMessage(School school);

    int getSchoolMessageCount(String uname);
    //实现批量删除
    boolean deleteSchoolSomeMessage(List<Integer> ids);


    List<Map<String,Object>> getStaffName();

    ArrayList<HashMap<String,Object>> studentCount(Integer startIndex,Integer endIndex,String uname);
}
