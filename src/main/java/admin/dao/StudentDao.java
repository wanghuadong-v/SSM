package admin.dao;

import admin.model.Staff;
import admin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    ArrayList<HashMap<String,Object>> allStudentMessage(@Param("startIndex") Integer startIndex,
                                                      @Param("endIndex") Integer endIndex,
                                                      @Param("sid") Integer sid,
                                                      @Param("cliname") String cliname,
                                                      @Param("sname") String sname,
                                                      @Param("tel") String tel,
                                                      @Param("uname") String uname,
                                                      @Param("state") String state,
                                                        @Param("clId") String clId);
    int getStudentMessageCount(@Param("clId") String clId,@Param("sname") String snamedeleteStudentSomeMessage);

    int deleteStudentMessage(Integer sid);

    int updateStudentMessage(Student student);

    int insertStudentMessage(Student student);

    int deleteStudentSomeMessage(List<Integer> ids);


    int selectStudentSomeMessage(@Param("ids")List<Integer> ids,@Param("clid")String clid);

    List<Map<String,Object>> getSchoolName1();

    List<Map<String,Object>> getClassName1();

}
