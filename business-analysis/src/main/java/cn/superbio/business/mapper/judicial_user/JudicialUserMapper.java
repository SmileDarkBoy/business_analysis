package cn.superbio.business.mapper.judicial_user;

import cn.superbio.business.DO.judicial_user.JudicialUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface JudicialUserMapper extends BaseMapper<JudicialUser> {

    @MapKey("webchart")
    @Select("select username,webchart from tb_upc_users where webchart in (${list})")
    Map<String,Map> getUserDict(@Param("list") String list);
}
