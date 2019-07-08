package cn.superbio.business.provider.yl;

import cn.superbio.business.BusinessUsersServiceApi;
import cn.superbio.business.DO.yl.BusinessUsersDO;
import cn.superbio.business.entity.yl.BusinessUsersEntity;
import cn.superbio.business.service.yl.BusinessUsersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Service
public class BusinessUsersProvider implements BusinessUsersServiceApi {
    @Autowired
    private BusinessUsersService businessUsersService;
    @Autowired
    private Mapper dozerMapper;


    @Override
    public List<BusinessUsersEntity> usersList(@RequestBody BusinessUsersEntity businessUsersEntity) {
        QueryWrapper<BusinessUsersDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(businessUsersEntity.getWebchart() != null, "webchart", businessUsersEntity.getWebchart())
                .like(businessUsersEntity.getUsername() != null, "username", businessUsersEntity.getUsername());
        List<BusinessUsersDO> businessUsersDOList = businessUsersService.list(queryWrapper);
        return dozerMapper.map(businessUsersDOList, List.class);
    }
}
