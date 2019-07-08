package cn.superbio.business.service.business_user.impl;

import cn.superbio.business.DO.business_user.BusinessUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import cn.superbio.business.entity.report.NewPassword;
import cn.superbio.business.mapper.business_user.BusinessUserMapper;
import cn.superbio.business.service.business_user.BusinessUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BusinessUserServiceImpl extends ServiceImpl<BusinessUserMapper, BusinessUser> implements BusinessUserService {

    @Autowired
    private BusinessUserMapper businessUserMapper;

    @Override
    public Map<String, Object> tempUser(JudicialUserEntity userEntity) {
        Map<String, Object> user = businessUserMapper.getUser(userEntity);

        //user.put("currentAuthority",user.get("type")=="2"?"user":"admin");

        return user;
    }

    @Override
    public Map<String, Object> updatePssword(NewPassword newPassword) {
        newPassword.setNpw(DigestUtils.md5Hex(newPassword.getNpw()));
        newPassword.setOldPassword(DigestUtils.md5Hex(newPassword.getOldPassword()));

        if (businessUserMapper.isPassWordById(newPassword)==1){
            businessUserMapper.updatePassword(newPassword);
            return new HashMap<>();
        }
        return null;
    }
}
