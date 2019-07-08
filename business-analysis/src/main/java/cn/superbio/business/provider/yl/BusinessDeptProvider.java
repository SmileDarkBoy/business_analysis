package cn.superbio.business.provider.yl;

import cn.superbio.business.BusinessDeptServiceApi;
import cn.superbio.business.DO.yl.BusinessDeptDO;
import cn.superbio.business.entity.yl.BusinessDeptEntity;
import cn.superbio.business.service.yl.BusinessDeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Service
public class BusinessDeptProvider implements BusinessDeptServiceApi {
    @Autowired
    private BusinessDeptService businessDeptService;
    @Autowired
    private Mapper dozerMapper;

    @Override
    public List<BusinessDeptEntity> deptList(@RequestBody BusinessDeptEntity businessdeptEntity) {
        QueryWrapper<BusinessDeptDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(businessdeptEntity.getDeptcode() != null, "deptcode", businessdeptEntity.getDeptcode());
        List<BusinessDeptDO> businessDeptDOList = businessDeptService.list(queryWrapper);
        return dozerMapper.map(businessDeptDOList, List.class);
    }
}
