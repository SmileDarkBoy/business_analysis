package cn.superbio.business.controller;

import cn.superbio.business.DictTypeServiceApi;
import cn.superbio.business.consumer.DictTypeServiceConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.sys.SysDictDataEntity;
import cn.superbio.business.entity.DictDataQuery;
import cn.superbio.business.entity.sys.SysDictTypeEntity;
import cn.superbio.business.entity.DictTypeQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "字典类型接口")
@RequestMapping("/api/dict")
@RestController
public class DictTypeContorller {
    @Autowired
//    private DictTypeServiceApi dictService;
    private DictTypeServiceConsumer dictService;

    @ApiOperation(value= "查询字典类型",notes = "查询字典类型")
    @RequestMapping(value = "/getType", method = RequestMethod.GET)
    List<SysDictTypeEntity> listData(HttpServletRequest request, String dictName, String dictType){
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            if("admin".equals(currentUser.getCurrentAuthority()))
                return dictService.listData(dictName,dictType);
        }
        return new ArrayList<>();
    }

    @ApiOperation(value= "新增字典类型",notes = "新增字典类型")
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    SysDictTypeEntity addType(@RequestBody SysDictTypeEntity dictType){
        return dictService.addType(dictType);
    }

    @ApiOperation(value= "修改字典类型",notes = "修改字典类型")
    @RequestMapping(value = "/updateType", method = RequestMethod.POST)
    SysDictTypeEntity updateType(@RequestBody SysDictTypeEntity dictType){
        return dictService.updateType(dictType);
    }

    @ApiOperation(value= "删除字典类型",notes = "删除字典类型")
    @RequestMapping(value = "/delType", method = RequestMethod.POST)
    Boolean delType(@RequestBody DictTypeQuery entity){
        return dictService.delType(entity);
    }

    @ApiOperation(value= "检查dictType是否重复",notes = "检查dictType是否重复")
    @RequestMapping(value = "/checkType", method = RequestMethod.GET)
    Boolean checkType(String dictType){
        return dictService.checkType(dictType);
    }

    @ApiOperation(value = "根据条件查询字典值", notes = "根据条件查询字典值")
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    List<Map> getData(String dictType,String dictLabel,String dictValue){
        return dictService.getData(dictType,dictLabel,dictValue);
    }

    @ApiOperation(value = "根据字典类型获得字典值", notes = "根据字典类型获得字典值")
    @RequestMapping(value = "/getSelectTreeData", method = RequestMethod.GET)
    List<Map> getSelectTreeData(String dictType, String dictCode){
        return dictService.getSelectTreeData(dictType, dictCode, true);
    }

    @ApiOperation(value = "根据字典类型获得字典值", notes = "根据字典类型获得字典值")
    @RequestMapping(value = "/getSelectTreeDataCopy", method = RequestMethod.GET)
    List<Map> getSelectTreeDataCopy(String dictType, String dictCode){
        return dictService.getSelectTreeData(dictType, dictCode, false);
    }

    @ApiOperation(value = "保存字典值", notes = "保存字典值")
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    SysDictDataEntity saveData(@RequestBody SysDictDataEntity dictData){
        return dictService.saveData(dictData);
    }

    @ApiOperation(value = "修改字典值", notes = "修改字典值")
    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    SysDictDataEntity updateData(@RequestBody SysDictDataEntity dictData){
        return dictService.updateData(dictData);
    }

    @ApiOperation(value= "删除字典值",notes = "删除字典值")
    @RequestMapping(value = "/delData", method = RequestMethod.POST)
    Boolean delData(@RequestBody DictDataQuery dictData){
        return dictService.delData(dictData);
    }

    @ApiOperation(value= "检查字典键值是否重复",notes = "检查字典键值是否重复")
    @RequestMapping(value = "/checkData", method = RequestMethod.GET)
    Boolean checkData(String dictType,String dictValue){
        return dictService.checkData(dictType,dictValue);
    }

    @ApiOperation(value= "新建字典数据自动设置键值",notes = "新建字典数据自动设置键值")
    @RequestMapping(value = "/getLastData", method = RequestMethod.GET)
    SysDictDataEntity getLastData(String dictType){
        return dictService.getLastData(dictType);
    }

    //-------
    @ApiOperation(value= "获得字典data",notes = "获得字典data")
    @RequestMapping(value = "/getDataByTypes", method = RequestMethod.GET)
    Map<String, List> getDataByTypes(String dictTypes){
        return dictService.getDataByTypes(dictTypes);
    }
}
