package admin.service;

import admin.model.Class;
import admin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ClassService {
    ArrayList<HashMap<String,Object>> allClassMessage(Integer startIndex, Integer endIndex,String clid,
                                                      String cliname, String opentime);

    int getClassMessageCount();

    boolean deleteClassMessage(Integer clid);

    boolean updateClassMessage(Class class1);

    boolean insertClassMessage(Class class1);

    //实现批量删除
    boolean deleteClassSomeMessage(List<Integer> ids);

}
