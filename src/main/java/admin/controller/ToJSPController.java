package admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToJSPController {

    @RequestMapping(value = "/adminIndex")
    public String adminIndex(){
        return "admin/adminHomePage";
    }

    @RequestMapping(value = "/headMasterIndex")
    public String headMasterIndex(){
        return "headMaster/headMasterHomePage";
    }

    @RequestMapping(value = "/recruiterIndex")
    public String recruiterIndex(){
        return "recruiter/recruiterHomePage";
    }

    @RequestMapping(value = "/administratorIndex")
    public String administratorIndex(){
        return "administrator/administratorHomePage";
    }

    //管理员登录
    @RequestMapping(value = "/toadminIndex")
    public String toadminIndex(){
        return "admin/adminIndex";
    }

    @RequestMapping(value = "/toStaffMessage")
    public String toStaffMessage(){
        return "admin/staffMessage";
    }

    @RequestMapping(value = "/toSchoolMessage")
    public String toSchoolMessage(){
        return "admin/schoolMessage";
    }

    @RequestMapping(value = "/toLeaderMessage")
    public String toLeaderMessage(){
        return "admin/leaderMessage";
    }
    @RequestMapping(value = "/totest5")
    public String totest5(){
        return "admin/test5";
    }

    //校长登录
    @RequestMapping("/toHeadMasterIndex")
    public String toHeadMasterIndex(){
        return "headMaster/headMasterIndex";
    }

    @RequestMapping(value = "/toStaffMessage2")
    public String toStaffMessage2(){
        return "headMaster/staffMessage";
    }

    @RequestMapping(value = "/toClassMessage")
    public String toClassMessage(){
        return "headMaster/classMessage";
    }

    @RequestMapping(value = "/toStudentMessage")
    public String toStudentMessage(){return "headMaster/studentMessage"; }

    @RequestMapping(value = "/toStaffCount")
    public String toStaffCount(){return "headMaster/staffCount"; }

    @RequestMapping(value = "/toStudentCount")
    public String toStudentCount(){return "headMaster/studentCount"; }

    //招聘人员登录
    @RequestMapping("/toRecruiterIndex")
    public String toRecruiterIndex(){
        return "recruiter/recruiterIndex";
    }

    @RequestMapping("/toSchoolMessage2")
    public String toSchoolMessage2(){
        return "recruiter/schoolMessage";
    }

    @RequestMapping(value = "/toLeaderMessage2")
    public String toLeaderMessage2(){
        return "recruiter/leaderMessage";
    }

    @RequestMapping(value = "/toClassMessage2")
    public String toClassMessage2(){
        return "recruiter/classMessage";
    }

    @RequestMapping(value = "/toStudentMessage2")
    public String toStudentMessage2(){return "recruiter/studentMessage"; }

    //行政人员
    @RequestMapping("/toAdministratorIndex")
    public String toAdministratorIndex(){return "administrator/administratorIndex"; }

    @RequestMapping("/toClassMessage3")
    public String toClassMessage3(){return "administrator/classMessage"; }

    @RequestMapping(value = "/toStudentMessage3")
    public String toStudentMessage3(){return "administrator/studentMessage"; }
}
