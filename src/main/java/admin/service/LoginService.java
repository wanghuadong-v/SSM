package admin.service;

import admin.model.Login;

import java.util.ArrayList;
import java.util.HashMap;

public interface LoginService {
    HashMap<String,Object> login(String ename, String password,String job);

}
