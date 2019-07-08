package cn.superbio.business.service.yl.impl;

import cn.superbio.business.DO.yl.BusinessPersonsDO;
import cn.superbio.business.mapper.yl.BusinessPersonsMapper;
import cn.superbio.business.service.yl.BusinessPersonsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BusinessPersonsServiceImpl extends ServiceImpl<BusinessPersonsMapper, BusinessPersonsDO> implements BusinessPersonsService {
}
