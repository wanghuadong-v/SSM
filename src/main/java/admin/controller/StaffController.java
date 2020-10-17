package admin.controller;

import admin.model.Staff;
import admin.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/allStaff")
    @ResponseBody
    public HashMap<String, Object> allStaffMessage(Integer page, Integer limit, Integer eid
            , String ename, String tel, String job, String password,String headMaster) {
        int pageSize = Integer.parseInt(String.valueOf(limit));
        int currentPage = Integer.parseInt(String.valueOf(page));
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = staffService.allStaffMessage(startIndex,endIndex,eid,ename,tel,job,password,headMaster);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = staffService.getStaffMessageCount(headMaster,ename,job);
        map.put("count",count);
        return map;
    }

    @RequestMapping("/deleteStaff")
    @ResponseBody
    public String deleteStaffMessage(Integer eid){
        boolean flag = false;
        if (!"".equals(eid) && null != eid){
            flag = staffService.deleteStaffMessage(eid);
        }
        return  flag + "";
    }

    @RequestMapping("/insertStaff")
    @ResponseBody
    public String insertStaffMessage(String eid,String ename,String tel,String job,String password){
        boolean flag = false;
        if (!"".equals(eid) && null != eid){
            Staff staff = new Staff (Integer.parseInt(eid),ename,tel,job,password);
            flag = staffService.updateStaffMessage(staff);
        }else {
            Staff staff = new Staff (ename,tel,job,password);
            flag = staffService.insertStaffMessage(staff);
        }
        return flag + "";
    }


    @RequestMapping("/deleteStaffSome")
    @ResponseBody
    public String deleteStaffSomeMessage(@RequestParam("ids[]")List<Integer> list){
        boolean b = staffService.deleteStaffSomeMessage(list);
        return String.valueOf(b);
    }

    @RequestMapping("/staffCount")
    @ResponseBody
    public HashMap<String, Object> staffCount(Integer page, Integer limit, String ename,String headMaster,String job) {
        int pageSize = Integer.parseInt(String.valueOf(limit));
        int currentPage = Integer.parseInt(String.valueOf(page));
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = staffService.staffCount(startIndex,endIndex,ename);

        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = staffService.getStaffMessageCount(headMaster,ename,job);
        map.put("count",count);
        return map;
    }









}
