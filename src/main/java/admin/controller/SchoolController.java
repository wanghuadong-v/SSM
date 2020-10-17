package admin.controller;

import admin.model.School;
import admin.service.SchoolService;
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
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/allSchool")
    @ResponseBody
    public HashMap<String, Object> allSchoolMessage(String page, String limit, Integer id, String uname, String uaddr, String ename) {
        int pageSize = Integer.parseInt(limit);
        int currentPage = Integer.parseInt(page);
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = schoolService.allSchoolMessage(startIndex,endIndex,id,uname,uaddr,ename);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = schoolService.getSchoolMessageCount(uname);
        map.put("count",count);
        return map;
    }
    @RequestMapping("/deleteSchool")
    @ResponseBody
    public String deleteSchoolMessage(Integer id){
        boolean flag = false;
        if (!"".equals(id) && null != id){
            flag = schoolService.deleteSchoolMessage(id);
        }
        return flag +"";
    }
    @RequestMapping("/insertSchool")
    @ResponseBody
    public String insertSchoolMessage(String id,String uname,String uaddr,String eid){
        boolean flag = false;
        School school = new School(id,uname,uaddr,eid);
        if (!"".equals(id) && null != id){
            flag = schoolService.updateSchoolMessage(school);
        }else {
            flag = schoolService.insertSchoolMessage(school);
        }
        return flag+"";
    }


    @RequestMapping("/deleteSchoolSome")
    @ResponseBody
    public String deleteSchoolSomeMessage(@RequestParam("ids[]")List<Integer> list){
        boolean b = schoolService.deleteSchoolSomeMessage(list);
        return String.valueOf(b);
    }



    @RequestMapping("/getStaffName")
    @ResponseBody
    public List<Map<String,Object>> getStaffNameMessage(){
        List<Map<String, Object>> staffName = schoolService.getStaffName();
        return staffName;
    }

    @RequestMapping("/studentCount")
    @ResponseBody
    public HashMap<String, Object> studentCount(Integer page, Integer limit, String uname) {
        int pageSize = Integer.parseInt(String.valueOf(limit));
        int currentPage = Integer.parseInt(String.valueOf(page));
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = schoolService.studentCount(startIndex,endIndex,uname);

        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = schoolService.getSchoolMessageCount(uname);
        map.put("count",count);
        return map;
    }
}
