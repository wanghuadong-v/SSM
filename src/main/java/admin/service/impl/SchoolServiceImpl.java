package admin.service.impl;

import admin.dao.SchoolDao;
import admin.model.School;
import admin.model.Staff;
import admin.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public ArrayList<HashMap<String, Object>> allSchoolMessage(Integer startIndex, Integer endIndex, Integer id, String uname, String uaddr, String ename) {
        return schoolDao.allSchoolMessage(startIndex,endIndex,id,uname,uaddr,ename);
    }

    @Override
    public boolean deleteSchoolMessage(Integer id) {
        boolean flag = false;
        int i = schoolDao.deleteSchoolMessage(id);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateSchoolMessage(School school) {
        boolean flag = false;
        int i = schoolDao.updateSchoolMessage(school);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean insertSchoolMessage(School school) {
        boolean flag = false;
        int i = schoolDao.insertSchoolMessage(school);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public int getSchoolMessageCount(String uname) {
        return schoolDao.getSchoolMessageCount(uname);
    }

    @Override
    public boolean deleteSchoolSomeMessage(List<Integer> ids) {
        boolean flag = false;
        int i = schoolDao.deleteSchoolSomeMessage(ids);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Map<String, Object>> getStaffName() {
        return schoolDao.getStaffName();
    }

    @Override
    public ArrayList<HashMap<String, Object>> studentCount(Integer startIndex, Integer endIndex, String uname) {
        return schoolDao.studentCount(startIndex,endIndex,uname);
    }
}
