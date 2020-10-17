package admin.dao;

import admin.model.Leader;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LeaderDao {
    ArrayList<HashMap<String,Object>> allLeaderMessage(@Param("startIndex") Integer startIndex, @Param("endIndex") Integer endIndex, @Param("cid") Integer cid
            ,@Param("tel") String tel, @Param("uname") String uname, @Param("cname") String cname, @Param("csex") String csex, @Param("job") String job);
    int deleteLeaderMessage(Integer cid);
    int updateLeaderMessage(Leader leader);
    int insertLeaderMessage(Leader leader);

    int getLeaderMessageCount(String uname);


    int deleteLeaderSomeMessage(List<Integer> ids);

    List<Map<String,Object>> getSchoolName();


}
