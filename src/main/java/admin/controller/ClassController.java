package admin.controller;

import admin.model.Class;
import admin.model.Student;
import admin.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping("/allClass")
    @ResponseBody
    public HashMap<String,Object> allClassMessage(String page,String limit,String clid,String cliname,String opentime){
        int pageSize = Integer.parseInt(limit);
        int currentPage = Integer.parseInt(page);
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = classService.allClassMessage(startIndex,endIndex,clid,cliname,opentime);

        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = classService.getClassMessageCount();
        map.put("count",count);
        return map;
    }

    @RequestMapping("/deleteClass")
    @ResponseBody
    public String deleteStudentMessage(Integer clid){
        boolean flag = false;
        if (!"".equals(clid) && null != clid){
            flag = classService.deleteClassMessage(clid);
        }
        return flag + "";
    }

    @RequestMapping("/insertClass")
    @ResponseBody
    public String insertStudentMessage(String clid,String cliname,String opentime){
        boolean flag = false;
        Class class1 = new Class(clid,cliname,opentime);
        if (!"".equals(clid) && null != clid){
            flag = classService.updateClassMessage(class1);
        }else {
            flag = classService.insertClassMessage(class1);
        }
        return flag + "";
    }

    @RequestMapping("/deleteClassSome")
    @ResponseBody
    public String deleteStudentSomeMessage(@RequestParam("ids[]") List<Integer> list){
        boolean i = classService.deleteClassSomeMessage(list);
        return String.valueOf(i);
    }
}
