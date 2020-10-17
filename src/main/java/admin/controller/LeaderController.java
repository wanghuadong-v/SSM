package admin.controller;

import admin.model.Leader;
import admin.model.School;
import admin.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LeaderController {
    @Autowired
    private LeaderService leaderService;

    @RequestMapping("/allLeader")
    @ResponseBody
    public HashMap<String, Object> allLeaderMessage(String page,
                                                    String limit,
                                                    Integer cid,
                                                    String uname,
                                                    String cname,
                                                    String csex,
                                                    String tel,
                                                    String job) {
       int pageSize = Integer.parseInt(limit);
        int currentPage = Integer.parseInt(page);
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = leaderService.allLeaderMessage(startIndex,endIndex,cid,uname,cname,csex,job,tel);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = leaderService.getLeaderMessageCount(uname);
        map.put("count",count);
        return map;
    }
    @RequestMapping("/deleteLeader")
    @ResponseBody
    public String deleteLeaderMessage(Integer cid) {
        boolean flag = false;
        if (!"".equals(cid) && null != cid) {
            flag = leaderService.deleteLeaderMessage(cid);
        }
        return flag + "";
    }

    @RequestMapping("/insertLeader")
    @ResponseBody
    public String insertLeaderMessage(String cid,String id,
                                      String csex,String cname,
                                      String job,String tel){
        boolean flag = false;
        Leader leader = new Leader(cid, cname, csex, job, id, tel);
        if (!"".equals(cid) && null != cid){
            flag = leaderService.updateLeaderMessage(leader);
        }else {
            flag = leaderService.insertLeaderMessage(leader);
        }
        return flag+"";
    }

    @RequestMapping("/deleteLeaderSome")
    @ResponseBody
    public String deleteLeaderSomeMessage(@RequestParam("ids[]")List<Integer> list){
         boolean b = leaderService.deleteLeaderSomeMessage(list);
         return String.valueOf(b);
    }

  @RequestMapping("/getSchoolName")
  @ResponseBody
  public List<Map<String,Object>> getSchoolNameMessage(){
      List<Map<String, Object>> schoolName = leaderService.getSchoolName();
      return schoolName;
  }
}
