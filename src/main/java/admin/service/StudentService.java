package admin.service;

import admin.model.Staff;
import admin.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudentService {
    ArrayList<HashMap<String,Object>> allStudentMessage(Integer startIndex,
                                                        Integer endIndex,
                                                        Integer sid,
                                                        String cliname,
                                                        String sname,
                                                        String tel,
                                                        String uname,
                                                        String state,
                                                        String clId);
    int getStudentMessageCount(String clId,String sname);

    boolean deleteStudentMessage(Integer sid);

    boolean updateStudentMessage(Student student);

    boolean insertStudentMessage(Student student);

    //实现批量删除
    boolean deleteStudentSomeMessage(List<Integer> ids);

    boolean selectStudentSomeMessage(List<Integer> ids,String clid);

    List<Map<String,Object>> getSchoolName1();

    List<Map<String,Object>> getClassName1();
}
