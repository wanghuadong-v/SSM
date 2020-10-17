package admin.dao;

import admin.model.Login;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

public interface LoginDao {
    HashMap<String,Object> login(@Param("ename") String ename, @Param("password") String password,@Param("job") String job);
}
