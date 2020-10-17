package admin.service.impl;

import admin.dao.ClassDao;
import admin.model.Class;
import admin.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;
    @Override
    public ArrayList<HashMap<String, Object>> allClassMessage(Integer startIndex, Integer endIndex, String clid, String cliname, String opentime) {
        return classDao.allClassMessage(startIndex,endIndex,clid,cliname,opentime);
    }

    @Override
    public int getClassMessageCount() {
        return classDao.getClassMessageCount();
    }

    @Override
    public boolean deleteClassMessage(Integer clid) {
        boolean flag = false;
        int i = classDao.deleteClassMessage(clid);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateClassMessage(Class class1) {
        boolean flag = false;
        int i = classDao.updateClassMessage(class1);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean insertClassMessage(Class class1) {
        boolean flag = false;
        int i = classDao.insertClassMessage(class1);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteClassSomeMessage(List<Integer> ids) {
        boolean flag = false;
        int i = classDao.deleteClassSomeMessage(ids);
        if (i > 0) {
            flag = true;
        }
        return flag;
    }
}
