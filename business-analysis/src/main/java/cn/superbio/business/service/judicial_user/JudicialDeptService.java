package cn.superbio.business.service.judicial_user;

import cn.superbio.business.DO.judicial_user.JudicialDept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface JudicialDeptService extends IService<JudicialDept> {
    List<Map> buildTree(List<Map<String, Object>> baseMap, String parentName, String codeName);

    void buildTreeDown(Map<String, List> keyMap, Map<String, Object> entity,String codeName);
}
