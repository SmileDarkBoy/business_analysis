package cn.superbio.business.service.business_user;

import cn.superbio.business.DO.business_user.BusinessUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.entity.report.NewPassword;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface BusinessUserService extends IService<BusinessUser> {
    Map<String, Object> tempUser(JudicialUserEntity userEntity);

    Map<String,Object> updatePssword(NewPassword newPassword);
}
