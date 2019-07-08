package cn.superbio.business.controller.yl;

import cn.superbio.business.BusinessPersonsServiceApi;
import cn.superbio.business.consumer.yl.BusinessPersonsConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.yl.BusinessPersonsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "人员配置")
@RequestMapping("/api/Persons")
@RestController
public class BusinessPersonsController {
    @Autowired
//    private BusinessPersonsServiceApi businessPersonsServiceApi;
    private BusinessPersonsConsumer businessPersonsServiceApi;

    @ApiOperation(value = "查询列表", notes = "查询列表")
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public List<BusinessPersonsEntity> list(HttpServletRequest request, BusinessPersonsEntity businessPersonsEntity) {
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            if("admin".equals(currentUser.getCurrentAuthority()))
                return businessPersonsServiceApi.personsList(businessPersonsEntity);
        }
        return new ArrayList<>();
    }

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "save", method = {RequestMethod.POST})
    public boolean save(@RequestBody BusinessPersonsEntity businessPersonsEntity) {
        return businessPersonsServiceApi.save(businessPersonsEntity);

    }
    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "update", method = {RequestMethod.POST})
    public boolean update( @RequestBody BusinessPersonsEntity businessPersonsEntity) {
        return businessPersonsServiceApi.update(businessPersonsEntity);

    }

    @ApiOperation(value = "批量删除", notes = "批量删除")
    @RequestMapping(value = "", method = {RequestMethod.DELETE})
    public boolean remove(@RequestParam(value="ids",required=true) List<String> ids) {
        return businessPersonsServiceApi.remove(ids);
    }
}
