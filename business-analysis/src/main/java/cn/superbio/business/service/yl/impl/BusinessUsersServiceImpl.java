package cn.superbio.business.service.yl.impl;

import cn.superbio.business.DO.yl.BusinessUsersDO;
import cn.superbio.business.mapper.yl.BusinessUsersMapper;
import cn.superbio.business.service.yl.BusinessUsersService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
@DS("judicial")
public class BusinessUsersServiceImpl extends ServiceImpl<BusinessUsersMapper, BusinessUsersDO> implements BusinessUsersService {
}
