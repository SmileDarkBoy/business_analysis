package cn.superbio.business.service.judicial_user.impl;

import cn.superbio.business.DO.judicial_user.JudicialUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.mapper.judicial_user.JudicialUserMapper;
import cn.superbio.business.service.judicial_user.JudicialUserService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DS("judicial")
public class JudicialUserServiceImpl extends ServiceImpl<JudicialUserMapper, JudicialUser> implements JudicialUserService {
    @Autowired
    private JudicialUserMapper userMapper;

    @Override
    public Map<String, Map> tempUser(){
        Map<String, Map> userMap = new HashMap<>();

        Map<String,String> adminUser = new HashMap<>();
        adminUser.put("userCode","admin");
        adminUser.put("password","888888");
        adminUser.put("name","管理员");
        adminUser.put("webchart","0");
        adminUser.put("type","0");  //0:超级管理员 1:东 2:南 3:西 4:北
        adminUser.put("currentAuthority","admin");
        userMap.put("admin",adminUser);

        Map<String,String> eastUser = new HashMap<>();
        eastUser.put("userCode","dongqu");
        eastUser.put("password","888888");
        eastUser.put("name","东区管理员");
        eastUser.put("webchart","1");
        eastUser.put("type","1");
        eastUser.put("currentAuthority","admin");
        userMap.put("dongqu",eastUser);

        Map<String,String> southUser = new HashMap<>();
        southUser.put("userCode","nanqu");
        southUser.put("password","888888");
        southUser.put("name","南区管理员");
        southUser.put("webchart","2");
        southUser.put("type","2");
        southUser.put("currentAuthority","admin");
        userMap.put("nanqu",southUser);

        Map<String,String> westUser = new HashMap<>();
        westUser.put("userCode","xiqu");
        westUser.put("password","888888");
        westUser.put("name","西区管理员");
        westUser.put("webchart","3");
        westUser.put("type","3");
        westUser.put("currentAuthority","admin");
        userMap.put("xiqu",westUser);

        Map<String,String> northUser = new HashMap<>();
        northUser.put("userCode","beiqu");
        northUser.put("password","888888");
        northUser.put("name","北区管理员");
        northUser.put("webchart","4");
        northUser.put("type","4");
        northUser.put("currentAuthority","admin");
        userMap.put("beiqu",northUser);

        Map<String,String> temp = new HashMap<>();
        temp.put("userCode","fudong");
        temp.put("password","888888");
        temp.put("name","付东");
        temp.put("webchart","000001683"); //工号
        temp.put("type","");
        temp.put("currentAuthority","user");
        userMap.put("fudong",temp);

        return userMap;
    }

    @Override
    public Map<String,Map> getUserDict(String list) {
        return userMapper.getUserDict(list);
    }
}
