package cn.superbio.business.service.yl;

import cn.superbio.business.DO.yl.BusinessProductDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface BusinessProductService extends IService<BusinessProductDO> {
    List<String> getDept();
}
