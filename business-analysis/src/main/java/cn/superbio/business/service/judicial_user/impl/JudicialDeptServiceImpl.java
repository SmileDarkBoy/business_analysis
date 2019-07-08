package cn.superbio.business.service.judicial_user.impl;

import cn.superbio.business.DO.judicial_user.JudicialDept;
import cn.superbio.business.mapper.judicial_user.JudicialDeptMapper;
import cn.superbio.business.service.judicial_user.JudicialDeptService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DS("judicial")
public class JudicialDeptServiceImpl extends ServiceImpl<JudicialDeptMapper, JudicialDept> implements JudicialDeptService {
    @Override
    public List<Map> buildTree(List<Map<String, Object>> baseMap, String parentName, String codeName) {
        Map<String, List> keyMap = new HashMap<>();
        //构建key:parentCode ,val: List<DictData>
        for(Map<String, Object> tempMap : baseMap){
            String key = (String)tempMap.get(parentName);
            tempMap.put("key",tempMap.get(codeName)+"_selectTree");
            List<Map> childs = keyMap.get(key);
            if(childs == null)
                childs = new ArrayList();
            childs.add(tempMap);
            keyMap.put(key,childs);
        }
        Map<String, Object> root = new HashMap<>();
        root.put(codeName,"0");
        buildTreeDown(keyMap, root,codeName);
        return (List<Map>)root.get("children");
    }

    @Override
    public void buildTreeDown(Map<String, List> keyMap, Map<String, Object> entity, String codeName) {
        List<Map<String, Object>> childs = keyMap.get(entity.get(codeName));
        if(childs != null){
            for(Map<String, Object> temp : childs){
                buildTreeDown(keyMap, temp, codeName);
            }
            entity.put("children", childs);
        }
    }
}
