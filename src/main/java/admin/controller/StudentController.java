package admin.controller;

import admin.model.Student;
import admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/allStudent")
    @ResponseBody
    public HashMap<String,Object> allStudentMessage(String page,String limit,
                                                    Integer sid,String sname,
                                                    String tel,String cliname,
                                                    String uname,String state,String clId){
        int pageSize = Integer.parseInt(limit);
        int currentPage = Integer.parseInt(page);
        int startIndex = pageSize*(currentPage-1)+1;
        int endIndex = currentPage*pageSize;
        ArrayList<HashMap<String,Object>> arrayList = studentService.allStudentMessage(startIndex, endIndex,sid, cliname, sname, tel, uname, state,clId);
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",arrayList);
        int count = studentService.getStudentMessageCount(clId,sname);
        map.put("count",count);
        return map;
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public String deleteStudentMessage(Integer sid){
        boolean flag = false;
        if (!"".equals(sid) && null != sid){
            flag = studentService.deleteStudentMessage(sid);
        }
        return flag + "";
    }

    @RequestMapping("/insertStudent")
    @ResponseBody
    public String insertStudentMessage(String sid,String sname,String tel,String id,
            String state,String clId){
        boolean flag = false;
        Student student = new Student(sid,sname,tel,id,state,clId);
        if (!"".equals(sid) && null != sid){
            flag = studentService.updateStudentMessage(student);
        }else {
            flag = studentService.insertStudentMessage(student);
        }
        return flag + "";
    }

    @RequestMapping("/deleteStudentSome")
    @ResponseBody
    public String deleteStudentSomeMessage(@RequestParam("ids[]") List<Integer> list){
        boolean i = studentService.deleteStudentSomeMessage(list);
        return String.valueOf(i);
    }


    @RequestMapping("/selectStudentSome")
    @ResponseBody
    public String selectStudentSomeMessage(@RequestParam("ids[]") List<Integer> list,String clid){
        boolean i = studentService.selectStudentSomeMessage(list,clid);
        return String.valueOf(i);
    }

    @RequestMapping("/getSchoolName1")
    @ResponseBody
    public List<Map<String,Object>> getSchoolNameMessage(){
        List<Map<String, Object>> schoolName = studentService.getSchoolName1();
        return schoolName;

    }

    @RequestMapping("/getClassName1")
    @ResponseBody
    public List<Map<String,Object>> getClassNameMessage(){
        List<Map<String, Object>> className = studentService.getClassName1();
        return className;
    }
}
