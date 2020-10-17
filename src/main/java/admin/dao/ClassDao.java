package admin.dao;

import admin.model.Class;
import admin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface    ClassDao {
    ArrayList<HashMap<String,Object>> allClassMessage(@Param("startIndex") Integer startIndex,@Param("endIndex") Integer endIndex,@Param("clid") String clid,
                                                      @Param("cliname") String cliname, @Param("opentime") String opentime);
    int getClassMessageCount();

    int deleteClassMessage(Integer clid);

    int updateClassMessage(Class class1);

    int insertClassMessage(Class class1);

    int deleteClassSomeMessage(List<Integer> ids);



}
