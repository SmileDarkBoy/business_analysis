package cn.superbio.business.service.sys;

import cn.superbio.business.DO.sys.SysDictData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface SysDictDataService extends IService<SysDictData> {

    List<Map> buildTree(List<Map<String, Object>> baseMap, String dictLabel, String dictValue, String parentName, String codeName,String rootName);

    void buildTreeDown(Map<String, List> keyMap, Map<String, Object> entity,String codeName);

    void buildTreeUp(List<String> needs, Map<String,Object> keyMap, Map<String, Object> entity,String codeName);

    SysDictData getDictDataCode(String dictType,String dictValue);

    List<Map<String,Object>> getAreaTreeData(String tpyes, String lastType);

    String getFullName(String adcode);
}
