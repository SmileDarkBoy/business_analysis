package cn.superbio.business.mapper.yl;

import cn.superbio.business.DO.yl.BusinessProductDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusinessProductMapper extends BaseMapper<BusinessProductDO> {
    @Select("select  distinct(deptname) from business_daily_product_info;")
    List<String> getDept();
}
