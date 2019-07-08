package cn.superbio.business.provider.sys;

import cn.superbio.business.DO.sys.SysDictData;
import cn.superbio.business.DO.sys.SysDictType;
import cn.superbio.business.DictTypeServiceApi;
import cn.superbio.business.entity.sys.SysDictDataEntity;
import cn.superbio.business.entity.DictDataQuery;
import cn.superbio.business.entity.sys.SysDictTypeEntity;
import cn.superbio.business.entity.DictTypeQuery;
import cn.superbio.business.service.sys.SysDictDataService;
import cn.superbio.business.service.sys.SysDictTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//@Service
@RestController
public class SysDictTypeProvider implements DictTypeServiceApi {
    @Autowired
    private SysDictTypeService typeService;
    @Autowired
    private SysDictDataService dataService;
    @Autowired
    private Mapper dozer;

    @Override
    public List<SysDictTypeEntity> listData(String dictName,String dictType) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(dictName))
            queryWrapper.like("dict_name",dictName);
        if(StringUtils.isNotEmpty(dictType))
            queryWrapper.like("dict_type",dictType);
        queryWrapper.eq("status",1).orderByDesc("create_date");
        return dozer.map(typeService.list(queryWrapper),List.class);
    }

    @Override
    public SysDictTypeEntity addType(@RequestBody SysDictTypeEntity dictType) {
        if(dictType != null){
            dictType.setId(String.valueOf(UUID.randomUUID()));
            boolean result = typeService.save(dozer.map(dictType,SysDictType.class));
            if(result)
                return dictType;
        }
        return null;
    }

    @Override
    public SysDictTypeEntity updateType(@RequestBody SysDictTypeEntity dictType) {
        if(dictType != null || dictType.getId() != null){
            SysDictType oldDictType = typeService.getById(dictType.getId());
            boolean result = typeService.saveOrUpdate(dozer.map(dictType,SysDictType.class));
            if(result){
                String oldType = oldDictType.getDictType();
                String newType = dictType.getDictType();
                if(!oldType.equals(newType)){
                    QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
                    queryWrapper.eq("dict_type",oldType);
                    SysDictData target = new SysDictData();
                    target.setDictType(newType);
                    dataService.update(target,queryWrapper);
                }
                return dictType;
            }
        }
        return null;
    }

    @Override
    public Boolean delType(@RequestBody DictTypeQuery entity) {
        if(entity != null && StringUtils.isNotEmpty(entity.getId())){
            SysDictType dictType = typeService.getById(entity.getId());
            boolean flag = false;
            if(dictType != null) {
                dictType.setStatus(0);
                flag = typeService.updateById(dictType);
            }
            if(flag) return true;
        }
        return null;
    }

    @Override
    public Boolean checkType(String dictType) {
        if(dictType != null){
            QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("dict_type",dictType).eq("status",1);
            List<SysDictType> dictTypes = typeService.list(queryWrapper);
            if(dictTypes != null && dictTypes.size() != 0){
                return true;
            }
        }
        return null;
    }

    @Override
    public List<Map> getData(String dictType,String dictLabel,String dictValue) {
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type",dictType).eq("status",1).orderByAsc("tree_sort").
                select("dict_code as dictCode","parent_code as parentCode","tree_sort as treeSort","description","status","extend1",
                        "dict_label as dictLabel","dict_value as dictValue","dict_type as dictType","create_date as createDate");

        List<Map<String, Object>> baseMap = dataService.listMaps(queryWrapper);
        return dataService.buildTree(baseMap,dictLabel,dictValue,"parentCode","dictCode","0");
    }

    @Override
    public List<Map> getSelectTreeData(String dictType,String dictCode,boolean flag) {
        //flag: true字典管理中使用 id(code)作为select的节点值 false 普通功能select
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type",dictType).eq("status",1).orderByAsc("tree_sort");
        queryWrapper.select("parent_code as parent","dict_code as code", "dict_label as title",
                "concat("+(flag ? "dict_code" : "dict_value") + ",'') as value");
        if(StringUtils.isNotEmpty(dictCode)){
            queryWrapper.ne("dict_code",dictCode).ne("parent_code",dictCode);
        }
        List<Map<String, Object>> baseMap = dataService.listMaps(queryWrapper);
        return dataService.buildTree(baseMap,null,null,"parent","code","0");
    }

    @Override
    public SysDictDataEntity saveData(@RequestBody SysDictDataEntity dictData) {
        try {
            String parentCode = dictData.getParentCode();
            dictData.setDictCode(String.valueOf(UUID.randomUUID()));
            if(StringUtils.isEmpty(parentCode)){
                dictData.setParentCode("0");
                //dictData.setParentCodes("0,");
            }else{
                QueryWrapper<SysDictData> queryParent = new QueryWrapper<>();
                queryParent.eq("dict_code",parentCode).eq("status",1);
                SysDictData patent = dataService.getOne(queryParent);
                //dictData.setParentCodes(patent.getParentCodes() + parentCode + ",");
            }
            dictData.setCreateDate(new Date());
            if(dataService.save(dozer.map(dictData,SysDictData.class)))
                return dictData;
        }catch (Exception ex){
            return null;
        }
        return null;
    }

    @Override
    public SysDictDataEntity updateData(@RequestBody SysDictDataEntity dictData) {
        if(StringUtils.isEmpty(dictData.getParentCode())){
            dictData.setParentCode("0");
        }
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_code",dictData.getDictCode()).eq("status",1);
        if(dataService.update(dozer.map(dictData,SysDictData.class),queryWrapper))
            return dictData;
        return null;
    }

    @Override
    public Boolean delData(@RequestBody DictDataQuery dictData) {
        if(dictData != null && StringUtils.isNotEmpty(dictData.getDictCode())){
            QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("dict_code",dictData.getDictCode());
            SysDictData entity = new SysDictData();
            entity.setStatus(0);
            if(dataService.update(entity,queryWrapper))
                return true;
        }
        return null;
    }

    @Override
    public Boolean checkData(String dictType,String dictValue) {
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type",dictType).eq("dict_value",dictValue).eq("status",1);
        List<SysDictData> dictDatas = dataService.list(queryWrapper);
        if(dictDatas != null && dictDatas.size() != 0){
            return true;
        }
        return null;
    }

    @Override
    public SysDictDataEntity getLastData(String dictType) {
        QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1).eq("dict_type",dictType).orderByDesc("dict_value");
        List<SysDictData> list = dataService.list(queryWrapper);
        if(list != null && !list.isEmpty()){
            return dozer.map(list.get(0),SysDictDataEntity.class);
        }
        SysDictDataEntity entity = new SysDictDataEntity();
        entity.setDictValue(0);
        entity.setTreeSort(0l);
        return entity;
    }

    @Override
    public Map<String, List> getDataByTypes(String dictTypes) {
        Map<String,List> result = new HashMap<>();
        if(StringUtils.isNotEmpty(dictTypes)){
            String[] arrStr = dictTypes.split(",");
            for(String dictType : arrStr){
                result.put(dictType,new ArrayList());
            }

            QueryWrapper<SysDictData> queryWrapper = new QueryWrapper<>();
            queryWrapper.in("dict_type",arrStr).eq("status",1);
            List<SysDictData> dictDatas = dataService.list(queryWrapper);
            if(dictDatas != null){
               for(SysDictData entity : dictDatas){
                   List<SysDictData> temp = result.get(entity.getDictType());
                   temp.add(entity);
               }
            }
        }
        return result;
    }
}
