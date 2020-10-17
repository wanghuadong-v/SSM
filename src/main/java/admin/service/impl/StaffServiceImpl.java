package admin.service.impl;

import admin.dao.StaffDao;
import admin.model.Staff;
import admin.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;
    @Override
    public ArrayList<HashMap<String, Object>> allStaffMessage(Integer startIndex, Integer endIndex, Integer eid, String ename, String tel, String job, String password,String headMaster) {

        return staffDao.allStaffMessage(startIndex,endIndex,eid,ename,tel,job,password,headMaster);
    }

    @Override
    public boolean deleteStaffMessage(Integer eid) {
        boolean flag = false;
       int i = staffDao.deleteStaffMessage(eid);
       if (i>0){
           flag = true;
       }
        return flag;
    }

    @Override
    public boolean updateStaffMessage(Staff staff) {
        boolean flag = false;
        int i = staffDao.updateStaffMessage(staff);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean insertStaffMessage(Staff staff) {
        boolean flag = false;
        int i = staffDao.insertStaffMessage(staff);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public int getStaffMessageCount(String headMaster,String ename,String job) {
        return staffDao.getStaffMessageCount(headMaster,ename,job);
    }

    @Override
    public boolean deleteStaffSomeMessage(List<Integer> ids) {
        boolean flag = false;
        int i = staffDao.deleteStaffSomeMessage(ids);
        if (i > 0){
            flag = true;
        }
        return flag;
    }

    @Override
    public ArrayList<HashMap<String, Object>> staffCount(Integer startIndex, Integer endIndex, String ename) {
        return staffDao.staffCount(startIndex,endIndex,ename);
    }


}
