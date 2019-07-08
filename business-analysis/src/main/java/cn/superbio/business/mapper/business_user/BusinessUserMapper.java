package cn.superbio.business.mapper.business_user;

import cn.superbio.business.DO.business_user.BusinessUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.entity.report.NewPassword;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface BusinessUserMapper extends BaseMapper<BusinessUser> {

    @Select("select " +
            "b.id as sp,b.account as userCode,b.password,p.username as name,IF(p.level='1', 'admin', 'user') as currentAuthority,p.levelname as type,b.account as webchart " +
            "from business_report_staff_accout b " +
            "LEFT JOIN business_daily_persons p on b.account = p.employee_number " +
            "where b.account = #{userCode}")
    Map<String,Object> getUser(JudicialUserEntity userEntity);

    @Update("update business_report_staff_accout set password = #{npw} where id = #{id}")
    int updatePassword(NewPassword newPassword);

    @Select("select count(*) from business_report_staff_accout where id = #{id} and password = #{oldPassword}")
    int isPassWordById(NewPassword newPassword);
}
