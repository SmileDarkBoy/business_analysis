package cn.superbio.business;

import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.entity.report.NewPassword;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Api(tags = "人员类型接口")
@RequestMapping("/service/api/user")
public interface JudicialUserServiceApi {

    @ApiOperation(value = "查询人员(字典形式", notes = "查询人员(字典形式")
    @RequestMapping(value = "/getUserDict", method = RequestMethod.POST)
    Map<String,Map> getUserDict();

    @ApiOperation(value = "登录", notes = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String,Object> login(@RequestBody JudicialUserEntity userEntity);

    @ApiOperation(value = "获得部门树形", notes = "获得部门树形")
    @RequestMapping(value = "/getDeptSelectTree", method = RequestMethod.GET)
    List<Map> getDeptSelectTree();

    @ApiOperation(value = "获得用户集", notes = "获得用户集")
    @RequestMapping(value = "/getUserSelectTree", method = RequestMethod.GET)
    List<Map> getUserSelectTree();

    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    Map<String,Object> updatePssword (@RequestBody NewPassword newPassword);

}
