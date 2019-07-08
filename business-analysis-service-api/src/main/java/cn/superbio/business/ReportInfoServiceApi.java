package cn.superbio.business;

import cn.superbio.business.entity.report.ReportInfoCjshEntity;
import cn.superbio.business.entity.report.ReportInfoEntity;
import cn.superbio.business.entity.report.ReportInfoKxxdyEntity;
import cn.superbio.business.entity.ReportInfoQuery;
import cn.superbio.business.entity.sys.SysFileEntityEntity;
import cn.superbio.business.entity.sys.SysFileUploadEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@Api(tags = "项目报备接口")
@RequestMapping("/service/api/reportInfo")
public interface ReportInfoServiceApi {

    @ApiOperation(value = "list", notes = "list")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    List<ReportInfoEntity> list(@RequestBody ReportInfoQuery infoQuery);

    @ApiOperation(value = "根据条件查询人员", notes = "根据条件查询人员")
    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    ReportInfoEntity getInfo(@RequestParam("infoId") String infoId);

    @ApiOperation(value = "保存附属数据list", notes = "保存附属数据list")
    @RequestMapping(value = "/saveFormList", method = RequestMethod.POST)
    ReportInfoEntity saveFormList(@RequestBody ReportInfoEntity infoEntity);

    @ApiOperation(value = "删除报备", notes = "删除报备")
    @RequestMapping(value = "/removeInfo", method = RequestMethod.GET)
    Boolean removeInfo(@RequestParam("id") String id);

    @ApiOperation(value = "管理员报备", notes = "管理员报备")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ReportInfoEntity save(@RequestBody ReportInfoEntity info);

    @RequestMapping(value = "/isOnlyXmba", method = RequestMethod.POST)
    ReportInfoEntity isOnlyXmba(@RequestBody ReportInfoEntity info);

    @ApiOperation(value = "管理员报备修改", notes = "管理员报备修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ReportInfoEntity update(@RequestBody ReportInfoEntity info);

    @ApiOperation(value = "获得地区树形", notes = "获得地区树形")
    @RequestMapping(value = "/getAreaTreeData", method = RequestMethod.GET)
    List<Map> getAreaTreeData(@RequestParam("lastType")String lastType);

    @ApiOperation(value = "根据id修改项目状态", notes = "根据id修改项目状态")
    @RequestMapping(value = "/updateXmzt", method = RequestMethod.POST)
    ReportInfoEntity updateXmzt(@RequestBody ReportInfoQuery info);

    @ApiOperation(value = "合同管理查询", notes = "合同管理查询")
    @RequestMapping(value = "/contract", method = RequestMethod.POST)
    List<ReportInfoEntity> contractList(@RequestBody ReportInfoQuery infoQuery);

    @ApiOperation(value = "根据infoId获得合同", notes = "根据infoId获得合同")
    @RequestMapping(value = "/getContract", method = RequestMethod.GET)
    ReportInfoCjshEntity getContract(@RequestParam("infoId")String infoId);

    @ApiOperation(value = "保存项目合同", notes = "保存项目合同")
    @RequestMapping(value = "/saveContract", method = RequestMethod.POST)
    ReportInfoCjshEntity saveContract(@RequestBody ReportInfoCjshEntity entity);

    @ApiOperation(value = "保存上传文件信息", notes = "保存上传文件信息")
    @RequestMapping(value = "/saveFileUpload", method = RequestMethod.POST)
    String saveFileUpload(@RequestBody SysFileEntityEntity fileEntity, @RequestParam("infoId") String infoId);

    @ApiOperation(value = "获得上传文件列表", notes = "获得上传文件列表")
    @RequestMapping(value = "/getFileUpload", method = RequestMethod.GET)
    List<Map> getFileUpload(@RequestParam("infoId") String infoId);

    @RequestMapping(value = "/getFile", method = RequestMethod.GET)
    SysFileUploadEntity getFile(@RequestParam("id") String id);

}
