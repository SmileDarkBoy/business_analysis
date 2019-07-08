package cn.superbio.business.service.yl.impl;

import cn.superbio.business.DO.yl.BusinessProductDO;
import cn.superbio.business.mapper.yl.BusinessProductMapper;
import cn.superbio.business.service.yl.BusinessProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BusinessProductServiceImpl extends ServiceImpl<BusinessProductMapper, BusinessProductDO> implements BusinessProductService {
    @Resource
    private BusinessProductMapper businessProductMapper;

    @Override
    public List<String> getDept() {
        return businessProductMapper.getDept();
    }
}
