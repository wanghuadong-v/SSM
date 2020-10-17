package admin.service.impl;

import admin.dao.LeaderDao;
import admin.model.Leader;
import admin.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private LeaderDao leaderDao;
    @Override
    public ArrayList<HashMap<String, Object>> allLeaderMessage(Integer startIndex, Integer endIndex, Integer cid, String uname, String cname, String csex, String job,String tel) {
        return leaderDao.allLeaderMessage(startIndex,endIndex,cid,cname,uname,csex,job,tel);
    }

    @Override
    public boolean deleteLeaderMessage(Integer cid) {
        boolean flag = false;
        int i = leaderDao.deleteLeaderMessage(cid);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean updateLeaderMessage(Leader leader) {
        boolean flag = false;
        int i = leaderDao.updateLeaderMessage(leader);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean insertLeaderMessage(Leader leader) {
        boolean flag = false;
        int i = leaderDao.insertLeaderMessage(leader);
        if (i>0){
            flag = true;
        }
        return flag;
}

    @Override
    public int getLeaderMessageCount(String uname) {
        return leaderDao.getLeaderMessageCount(uname);
    }

    @Override
    public boolean deleteLeaderSomeMessage(List<Integer> ids) {
        boolean flag = false;
        int i  = leaderDao.deleteLeaderSomeMessage(ids);
        if (i>0){
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Map<String, Object>> getSchoolName() {
        return leaderDao.getSchoolName();
    }


}
