package cn.superbio.business.service.judicial_user;

import cn.superbio.business.DO.judicial_user.JudicialUser;
import cn.superbio.business.entity.judicial_user.JudicialUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface JudicialUserService extends IService<JudicialUser> {

    Map<String, Map> tempUser();

    Map<String,Map> getUserDict(String list);
}
