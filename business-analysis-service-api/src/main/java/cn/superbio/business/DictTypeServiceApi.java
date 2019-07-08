package cn.superbio.business;

import cn.superbio.business.entity.DictDataQuery;
import cn.superbio.business.entity.DictTypeQuery;
import cn.superbio.business.entity.sys.SysDictDataEntity;
import cn.superbio.business.entity.sys.SysDictTypeEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Api(tags = "字典类型接口")
@RequestMapping("/service/api/dict")
public interface DictTypeServiceApi {

    /**
     * 查询List
     */
    @ApiOperation(value= "查询字典类型",notes = "查询字典类型")
    @RequestMapping(value = "/getType", method = RequestMethod.GET)
    List<SysDictTypeEntity> listData(@RequestParam(value = "dictName",required = false)String dictName,
                                     @RequestParam(value = "dictType",required = false)String dictType);

    /**
     * 新增
     */
    @ApiOperation(value= "新增字典类型",notes = "新增字典类型")
    @RequestMapping(value = "/addType", method = RequestMethod.POST)
    SysDictTypeEntity addType(@RequestBody SysDictTypeEntity dictType);

    /**
     * 修改
     */
    @ApiOperation(value= "修改字典类型",notes = "修改字典类型")
    @RequestMapping(value = "/updateType", method = RequestMethod.POST)
    SysDictTypeEntity updateType(@RequestBody SysDictTypeEntity dictType);

    /**
     * 删除
     */
    @ApiOperation(value= "删除字典类型",notes = "删除字典类型")
    @RequestMapping(value = "/delType", method = RequestMethod.POST)
    Boolean delType(@RequestBody DictTypeQuery entity);

    /**
     * 检查dictType是否重复
     */
    @ApiOperation(value= "检查dictType是否重复",notes = "检查dictType是否重复")
    @RequestMapping(value = "/checkType", method = RequestMethod.GET)
    Boolean checkType(@RequestParam("dictType")String dictType);

    //------------------

    @ApiOperation(value = "根据条件查询字典值", notes = "根据条件查询字典值")
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    List<Map> getData(@RequestParam(value = "dictType")String dictType,
                                    @RequestParam(value = "dictLabel",required = false)String dictLabel,
                                    @RequestParam(value = "dictValue",required = false)String dictValue);


    @ApiOperation(value = "根据类型获得字典树形值", notes = "根据类型获得字典树形值")
    @RequestMapping(value = "/getSelectTreeData", method = RequestMethod.GET)
    List<Map> getSelectTreeData(@RequestParam("dictType")String dictType,
                                @RequestParam(value = "dictCode",required = false)String dictCode,
                                @RequestParam("flag")boolean flag);

    @ApiOperation(value = "保存字典值", notes = "保存字典值")
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    SysDictDataEntity saveData(@RequestBody SysDictDataEntity dictData);

    @ApiOperation(value = "修改字典值", notes = "修改字典值")
    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    SysDictDataEntity updateData(@RequestBody SysDictDataEntity dictData);

    @ApiOperation(value= "删除字典值",notes = "删除字典值")
    @RequestMapping(value = "/delData", method = RequestMethod.POST)
    Boolean delData(@RequestBody DictDataQuery dictData);

    @ApiOperation(value= "检查字典键值是否重复",notes = "检查字典键值是否重复")
    @RequestMapping(value = "/checkData", method = RequestMethod.GET)
    Boolean checkData(@RequestParam("dictType")String dictType,@RequestParam("dictValue")String dictValue);

    @ApiOperation(value= "新建字典数据自动设置键值",notes = "新建字典数据自动设置键值")
    @RequestMapping(value = "/getLastData", method = RequestMethod.GET)
    SysDictDataEntity getLastData(@RequestParam("dictType")String dictType);

    //------------
    @ApiOperation(value= "获得字典data",notes = "获得字典data")
    @RequestMapping(value = "/getDataByTypes", method = RequestMethod.GET)
    Map<String, List> getDataByTypes(@RequestParam("dictTypes")String dictTypes);
}
