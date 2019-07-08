package cn.superbio.business.provider.yl;


import cn.superbio.business.BusinessPersonsServiceApi;
import cn.superbio.business.DO.yl.BusinessPersonsDO;
import cn.superbio.business.entity.yl.BusinessPersonsEntity;
import cn.superbio.business.service.yl.BusinessPersonsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Service
public class BusinessPersonsProvider implements BusinessPersonsServiceApi {
    @Autowired
    private BusinessPersonsService businessPersonsService;
    @Autowired
    private Mapper dozerMapper;


    @Override
    public List<BusinessPersonsEntity> personsList(@RequestBody BusinessPersonsEntity businessPersonsEntity) {
        QueryWrapper<BusinessPersonsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(businessPersonsEntity.getId() != null, "id", businessPersonsEntity.getId())
                .eq(businessPersonsEntity.getEmployeeNumber() != null, "employee_number", businessPersonsEntity.getEmployeeNumber())
                .like(businessPersonsEntity.getUsername() != null, "username", businessPersonsEntity.getUsername())
                .eq(businessPersonsEntity.getDept() != null, "dept", businessPersonsEntity.getDept())
                .eq(businessPersonsEntity.getUsertype() != null, "usertype", businessPersonsEntity.getUsertype())
                .like(businessPersonsEntity.getTelphone() != null, "telphone", businessPersonsEntity.getTelphone())
                .eq(businessPersonsEntity.getState() != null, "state", businessPersonsEntity.getState());
        List<BusinessPersonsDO> businessPersonsDOList = businessPersonsService.list(queryWrapper);
        return dozerMapper.map(businessPersonsDOList, List.class);
    }

    @Override
    public boolean save(@RequestBody BusinessPersonsEntity businessPersonsEntity) {
        BusinessPersonsDO businessPersonsDO = dozerMapper.map(businessPersonsEntity, BusinessPersonsDO.class);
        return businessPersonsService.save(businessPersonsDO);
    }

    @Override
    public boolean update(@RequestBody BusinessPersonsEntity businessPersonsEntity) {
        QueryWrapper<BusinessPersonsDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", businessPersonsEntity.getId());
        if(businessPersonsEntity.getLevel().equals("2")){
            businessPersonsEntity.setLevelname(" ");
        }
        BusinessPersonsDO businessPersonsDO = dozerMapper.map(businessPersonsEntity, BusinessPersonsDO.class);
        return businessPersonsService.update(businessPersonsDO, queryWrapper);
    }

    @Override
    public boolean remove(@RequestParam List<String> ids) {

        return businessPersonsService.removeByIds(ids);
    }
}
