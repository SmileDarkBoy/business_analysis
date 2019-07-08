package cn.superbio.business.service.yl.impl;


import cn.superbio.business.DO.yl.BusinessDeptDO;
import cn.superbio.business.mapper.yl.BusinessDeptMapper;
import cn.superbio.business.service.yl.BusinessDeptService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
@DS("judicial")
public class BusinessDeptServiceImpl extends ServiceImpl<BusinessDeptMapper, BusinessDeptDO> implements BusinessDeptService {
}
