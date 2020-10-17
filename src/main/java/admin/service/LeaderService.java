package admin.service;

import admin.model.Leader;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LeaderService {
    ArrayList<HashMap<String,Object>> allLeaderMessage(Integer startIndex,Integer endIndex,Integer cid
            ,String uname,String cname,String csex,String job,String tel);
    boolean deleteLeaderMessage(Integer cid);
    boolean updateLeaderMessage(Leader leader);
    boolean insertLeaderMessage(Leader leader);

    int getLeaderMessageCount(String uname);

    boolean deleteLeaderSomeMessage(List<Integer> ids);

    List<Map<String,Object>> getSchoolName();
}
