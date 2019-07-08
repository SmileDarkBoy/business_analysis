package cn.superbio.business.controller.yl;


import cn.superbio.business.BusinessUsersServiceApi;
import cn.superbio.business.consumer.yl.BusinessUsersConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.yl.BusinessUsersEntity;
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

@Api(tags = "人员查询")
@RequestMapping("/api/Users")
@RestController
public class BusinessUsersController {
    @Autowired
//    private BusinessUsersServiceApi businessUsersServiceApi;
    private BusinessUsersConsumer businessUsersServiceApi;
    @ApiOperation(value = "查询列表", notes = "查询列表")
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public List<BusinessUsersEntity> list(HttpServletRequest request, BusinessUsersEntity businessUsersEntity) {
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            if("admin".equals(currentUser.getCurrentAuthority()))
                return businessUsersServiceApi.usersList(businessUsersEntity);
        }
        return new ArrayList<>();
    }

}
