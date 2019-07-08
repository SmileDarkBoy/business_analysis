package cn.superbio.business.mapper.sys;

import cn.superbio.business.DO.sys.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SysDictDataMapper extends BaseMapper<SysDictData> {//if(level = ${lastType},'','true') as disabled,
    @Select({"select name as code,parent,name as title,adcode as value, concat(parent,'-',name) as fullname" +
            " from business_all_areainfo where level in (${types}) order by adcode"})
    List<Map<String,Object>> getAreaTreeData(@Param("types")String types,@Param("lastType")String lastType);

    @Select({"select * from business_all_areainfo where ${col}='${val}'"})
    Map<String,Object> getArea(@Param("col")String col,@Param("val")String val);
}
