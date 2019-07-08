package cn.superbio.business.controller.yl;

import cn.superbio.business.BusinessProductServiceApi;
import cn.superbio.business.consumer.yl.BusinessProductConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.yl.BusinessProductEntity;
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

@Api(tags = "后台数据")
@RequestMapping("/api/Product")
@RestController
public class BusinessProductController {
    @Autowired
//    private BusinessProductServiceApi businessProductServiceApi;
    private BusinessProductConsumer businessProductServiceApi;

    @ApiOperation(value = "查询列表", notes = "查询列表")
    @RequestMapping(value = "", method = {RequestMethod.GET})
    public List<BusinessProductEntity> list(HttpServletRequest request, BusinessProductEntity businessProductEntity) {
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            if("admin".equals(currentUser.getCurrentAuthority()))
                return businessProductServiceApi.productList(businessProductEntity);
        }
        return new ArrayList<>();
    }

    @ApiOperation(value = "查询部门列表", notes = "查询部门列表")
    @RequestMapping(value = "deptList", method = {RequestMethod.GET})
    public List<String> deptList() {
        return businessProductServiceApi.deptList();
    }

    @ApiOperation(value = "统计", notes = "统计")
    @RequestMapping(value = "TotalList", method = {RequestMethod.GET})
    public String TotalList(BusinessProductEntity businessProductEntity) {

        List list = businessProductServiceApi.productList(businessProductEntity);
        return "";

    }

}
