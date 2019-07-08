package cn.superbio.business.controller.yl;


import cn.superbio.business.BusinessDeptServiceApi;
import cn.superbio.business.consumer.yl.BusinessDeptConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.yl.BusinessDeptEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "部门查询")
@RequestMapping("/api/Dept")
@RestController
public class BusinessDeptController {
    @Autowired
//    private BusinessDeptServiceApi businessDeptServiceApi;
    private BusinessDeptConsumer businessDeptServiceApi;


    @ApiOperation(value = "查询列表", notes = "查询列表")
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public List<BusinessDeptEntity> list(HttpServletRequest request, BusinessDeptEntity businessDeptEntity) {
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            if("admin".equals(currentUser.getCurrentAuthority()))
                return businessDeptServiceApi.deptList(businessDeptEntity);
        }
        return new ArrayList<>();
    }
}
