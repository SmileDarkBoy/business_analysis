package cn.superbio.business.controller;

import cn.superbio.business.JudicialUserServiceApi;
import cn.superbio.business.consumer.JudicialUserServiceConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.entity.report.NewPassword;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "项目报备接口")
@RequestMapping("/api/user")
@RestController
public class JudicialUserController {
    @Autowired
//    private JudicialUserServiceApi userService;
    private JudicialUserServiceConsumer userService;

    @ApiOperation(value = "查询人员(字典形式", notes = "查询人员(字典形式")
    @RequestMapping(value = "/getUserDict", method = RequestMethod.POST)
    Map<String,Map> getUserDict(){
        return userService.getUserDict();
    }

    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    Map<String,Object> updatePssword(HttpServletRequest httpServletRequest,@RequestBody NewPassword newPassword){
        HttpSession session = httpServletRequest.getSession();
        newPassword.setId(String.valueOf(session.getAttribute("userId")));
        return  userService.updatePssword(newPassword);
    }

    @ApiOperation(value = "登录", notes = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String,Object> login(HttpServletRequest request,@RequestBody JudicialUserEntity userEntity){
        Map<String,Object> result = userService.login(userEntity);

        if("ok".equals(result.get("status"))){
            Map<String, Object> currentUser = (Map<String, Object>)result.get("currentUser");
            HttpSession session = request.getSession();
            session.setAttribute("userId", currentUser.get("sp"));
        }

        return result;
    }

    @RequestMapping(value = "/setCurrentUser", method = RequestMethod.POST)
    void setCurrentUser(HttpServletRequest request,@RequestBody CurrentUser currentUser){
        HttpSession session = request.getSession();

        if(currentUser != null && "guest".equals(currentUser.getCurrentAuthority())){
            session.setAttribute("userId", "");
        }

        session.setAttribute("currentUser", currentUser);
    }

    @RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET)
    CurrentUser getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (CurrentUser) session.getAttribute("currentUser");
    }

    @ApiOperation(value = "获得部门树形", notes = "获得部门树形")
    @RequestMapping(value = "/getDeptSelectTree", method = RequestMethod.GET)
    List<Map> getDeptSelectTree(){
        return userService.getDeptSelectTree();
    }

    @ApiOperation(value = "获得用户集", notes = "获得用户集")
    @RequestMapping(value = "/getUserSelectTree", method = RequestMethod.GET)
    List<Map> getUserSelectTree(){
        return userService.getUserSelectTree();
    }
}
