package admin.service.impl;

import admin.dao.LeaderDao;
import admin.dao.LoginDao;
import admin.model.Login;
import admin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public HashMap<String, Object> login(String ename, String password,String job) {
        return loginDao.login(ename,password,job);
    }
}
