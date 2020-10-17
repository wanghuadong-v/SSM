package admin.controller;

import admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String ename, String password, String job, Model model, HttpServletRequest request) {
        HashMap<String, Object> map = loginService.login(ename, password, job);
        if (map != null) {
            if (ename.equals( map.get("ename")) && password.equals(map.get("password"))) {
                String type = (String) map.get("job");

                HttpSession session = request.getSession();
                session.setAttribute("job",job);
                session.setAttribute("name",ename);

                if ("管理员".equals(type)) {
                    return "adminIndex";
                } else if ("校长".equals(type)) {
                    return "headMasterIndex";
                } else if ("招聘人员".equals(type)) {
                    return "recruiterIndex";
                } else if ("行政人员".equals(type)) {
                    return "administratorIndex";
                } else {
                    return "false";
                }
            }else {
                return "false";
            }
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout( HttpServletRequest request){
        HttpSession session = request.getSession();

        session.removeAttribute("name");
        return "/comm/login";
   }

}
