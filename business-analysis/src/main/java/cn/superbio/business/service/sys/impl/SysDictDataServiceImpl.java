package cn.superbio.business.service.sys.impl;

import cn.superbio.business.DO.sys.SysDictData;
import cn.superbio.business.mapper.sys.SysDictDataMapper;
import cn.superbio.business.service.sys.SysDictDataService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {
    @Autowired
    private SysDictDataMapper dataMapper;

    public List<Map> buildTree(List<Map<String, Object>> baseMap,String dictLabel,String dictValue,String parentName,String codeName,String rootName){
        Map<String, List> keyMap = new HashMap<>();
        if(!StringUtils.isAllEmpty(dictLabel,dictValue)){
            List<String> needs = filter(baseMap,codeName,dictLabel,dictValue);
            for(Map<String, Object> tempMap : baseMap){
                String dictCode = (String)tempMap.get(codeName);
                if(needs.contains(dictCode)){
                    String key = (String)tempMap.get(parentName);
                    tempMap.put("key",dictCode+"_selectTree");
                    List<Map> childs = keyMap.get(key);
                    if(childs == null)
                        childs = new ArrayList();
                    childs.add(tempMap);
                    keyMap.put(key,childs);
                }
            }
        }else{
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
        }
        Map<String, Object> root = new HashMap<>();

        root.put(codeName,rootName);
        buildTreeDown(keyMap, root,codeName);
        return (List<Map>)root.get("children");

    }

    public void buildTreeDown(Map<String, List> keyMap, Map<String, Object> entity,String codeName){
        List<Map<String, Object>> childs = keyMap.get(entity.get(codeName));
        if(childs != null){
            for(Map<String, Object> temp : childs){
                buildTreeDown(keyMap, temp, codeName);
            }
            entity.put("children", childs);
        }
    }

    public List<String> filter(List<Map<String, Object>> baseMap, String codeName, String dictLabel, String dictValue){
        List<String> needs = new ArrayList<>();
        Map<String,Object> keyMap = new HashMap<>();
        List<Map> feets = new ArrayList<>();
        for(Map<String, Object> tempMap : baseMap){
            String key = (String)tempMap.get(codeName);
            tempMap.put("key",tempMap.get(codeName)+"_selectTree");
            keyMap.put(key,tempMap);

            String label = (String) tempMap.get("dictLabel");
            String value = String.valueOf((Integer) tempMap.get("dictValue")) ;
            if(StringUtils.isEmpty(dictLabel)){
                if(value.matches(".*"+dictValue+".*")){
                    feets.add(tempMap);
                }
            }else if(StringUtils.isEmpty(dictValue)){
                if(label.matches(".*"+dictLabel+".*")){
                    feets.add(tempMap);
                }
            }else{
                if(label.matches(".*"+dictLabel+".*") && value.matches(".*"+dictValue+".*")){
                    feets.add(tempMap);
                }
            }
        }
        if(!feets.isEmpty()){
            for(Map<String,Object> entity : feets){
                buildTreeUp(needs, keyMap,entity,codeName);
            }
        }
        return needs;
    }

    public void buildTreeUp(List<String> needs, Map<String,Object> keyMap, Map<String, Object> entity,String codeName){
        String dictCode = (String) entity.get(codeName);
        if(!needs.contains(dictCode)){
            needs.add(dictCode);
        }

        String parentCode = (String) entity.get("parentCode");
        Map<String,Object> parent = (Map<String,Object>)keyMap.get(parentCode);
        if(parent != null){
            buildTreeUp(needs, keyMap, parent, codeName);
        }

    }

    @Override
    public SysDictData getDictDataCode(String dictType,String dictValue){
        QueryWrapper<SysDictData> dictDataQuery = new QueryWrapper<>();
        dictDataQuery.eq("status",1).eq("dict_type",dictType).eq("dict_value",dictValue);
        return getOne(dictDataQuery);
    }

    @Override
    public List<Map<String,Object>> getAreaTreeData(String tpyes, String lastType) {
        return dataMapper.getAreaTreeData(tpyes,lastType);
    }

    @Override
    public String getFullName(String adcode){
        Map<String,Object> area = dataMapper.getArea("adcode",adcode);
        String fullName = getParents(area.get("name") + "",(String) area.get("parent"));
        return fullName;
    }

    private String getParents(String fullName,String parentName){
        Map<String,Object> parent = dataMapper.getArea("name",parentName);
        if(parent != null && !"中华人民共和国".equals(parent.get("name"))){
            fullName = parent.get("name") + " " +fullName;
            fullName = getParents(fullName,(String) parent.get("parent"));
        }
        return fullName;
    }
}
