package admin.service.impl;

import admin.dao.StudentDao;
import admin.model.Student;
import admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public ArrayList<HashMap<String, Object>> allStudentMessage(Integer startIndex, Integer endIndex,
                                                                Integer sid, String cliname,
                                                                String sname, String tel,
                                                                String uname, String state,
                                                                String clId) {
        return studentDao.allStudentMessage(startIndex,endIndex,sid,cliname,sname,tel,uname,state,clId);
    }

    @Override
    public int getStudentMessageCount(String clId,String sname) {
        return studentDao.getStudentMessageCount(clId,sname);
    }

    @Override
    public boolean deleteStudentMessage(Integer sid) {
        boolean flag = false;
        int i = studentDao.deleteStudentMessage(sid);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateStudentMessage(Student student) {
        boolean flag = false;
        int i = studentDao.updateStudentMessage(student);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean insertStudentMessage(Student student) {
        boolean flag = false;
        int i = studentDao.insertStudentMessage(student);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteStudentSomeMessage(List<Integer> ids) {
        boolean flag = false;
        int i = studentDao.deleteStudentSomeMessage(ids);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean selectStudentSomeMessage(List<Integer> ids, String clid) {
        boolean flag = false;
        int i = studentDao.selectStudentSomeMessage(ids,clid);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Map<String, Object>> getSchoolName1() {
        return studentDao.getSchoolName1();
    }

    @Override
    public List<Map<String, Object>> getClassName1() {
        return studentDao.getClassName1();
    }

}
