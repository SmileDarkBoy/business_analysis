package cn.superbio.business.provider.judicial_user;

import cn.superbio.business.DO.judicial_user.JudicialDept;
import cn.superbio.business.DO.judicial_user.JudicialUser;
import cn.superbio.business.JudicialUserServiceApi;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.entity.report.NewPassword;
import cn.superbio.business.service.business_user.BusinessUserService;
import cn.superbio.business.service.judicial_user.JudicialDeptService;
import cn.superbio.business.service.judicial_user.JudicialUserService;
import cn.superbio.business.service.report.ReportInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
@RestController
public class JudicialUserProvider implements JudicialUserServiceApi {
    @Autowired
    private JudicialUserService userService;
    @Autowired
    private ReportInfoService infoService;
    @Autowired
    private JudicialDeptService deptService;
    @Autowired
    private BusinessUserService businessUserService;

    @Override
    public Map<String,Map> getUserDict() {
        List<String> webCharts = infoService.getWebchart();
        String webchartStr = webCharts.toString().replaceAll("\\[","").replaceAll("\\]","");
        return userService.getUserDict(webchartStr);
    }

    @Override
    public Map<String, Object> login(@RequestBody JudicialUserEntity userEntity) {
        Map<String,Object> result = new HashMap<>();
        if(userEntity != null){
            //String userCode = userEntity.getUserCode();

            Map<String, Object> targetUser = businessUserService.tempUser(userEntity);
            if(targetUser == null){
                result.put("status","error");
                result.put("type","用户不存在");
                result.put("currentAuthority","guest");
            }else{
                String password = userEntity.getPassword();
                if(targetUser.get("password").equals(DigestUtils.md5Hex(password))){
                    result.put("status","ok");
                    result.put("currentAuthority",targetUser.get("currentAuthority"));

                    Map<String, Object> currentUser = new HashMap<>();
                    currentUser.put("sp",targetUser.get("sp"));
                    currentUser.put("name",targetUser.get("name"));
                    currentUser.put("webchart",targetUser.get("webchart"));
                    currentUser.put("type",targetUser.get("type") == null ? "" : targetUser.get("type"));
                    currentUser.put("currentAuthority",targetUser.get("currentAuthority"));
                    result.put("currentUser",currentUser);

                }else{
                    result.put("status","error");
                    result.put("type","密码填写错误");
                    result.put("currentAuthority","guest");
                }
            }
        }else{
            result.put("status","error");
            result.put("type","出现异常");
            result.put("currentAuthority","guest");
        }
        return result;
    }

    @Override
    public List<Map> getDeptSelectTree() {
        QueryWrapper<JudicialDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("delstatus",0).orderByAsc("sort").
                select("parentid as parent","deptid as code","deptcode as value","deptname as title");

        List<Map<String, Object>> baseMap = deptService.listMaps(queryWrapper);
        return deptService.buildTree(baseMap,"parent","code");
    }

    @Override
    public List<Map> getUserSelectTree() {
        QueryWrapper<JudicialUser> queryWrapper = new QueryWrapper<>();
        //queryWrapper.select("userid","concat(webchart,'_',userid) as value","username as title","concat(initials,'_',username,'_',webchart) as filter");
        queryWrapper.select("webchart as value","userid","concat(substring_index(webchart,'00000',-1),'-',username) as title","concat(initials,'_',username,'_',webchart) as filter");
        String[] types = {"1","4","6"};
        queryWrapper.ne("webchart","").in("type",types).isNull("delstatus").groupBy("webchart");
        List baseMap = userService.listMaps(queryWrapper);
        return baseMap;
    }

    @Override
    public Map<String, Object> updatePssword(@RequestBody NewPassword newPassword) {
        return businessUserService.updatePssword(newPassword);
    }
}
