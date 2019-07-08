package cn.superbio.business.controller;

import cn.superbio.business.ReportInfoServiceApi;
import cn.superbio.business.consumer.ReportInfoServiceConsumer;
import cn.superbio.business.entity.judicial_user.CurrentUser;
import cn.superbio.business.entity.report.ReportInfoCjshEntity;
import cn.superbio.business.entity.report.ReportInfoEntity;
import cn.superbio.business.entity.report.ReportInfoKxxdyEntity;
import cn.superbio.business.entity.ReportInfoQuery;
import cn.superbio.business.entity.sys.SysFileEntityEntity;
import cn.superbio.business.entity.sys.SysFileUploadEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;

@Api(tags = "项目报备接口")
@RequestMapping("/api/reportInfo")
@RestController
public class ReportInfoContorller {
    @Autowired
//    private ReportInfoServiceApi infoService;
    private ReportInfoServiceConsumer infoService;

    @ApiOperation(value = "list", notes = "list")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    List<ReportInfoEntity> list(HttpServletRequest request,@RequestBody ReportInfoQuery infoQuery){
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            infoQuery.setCurrentUser(currentUser);
            return infoService.list(infoQuery);
        }
       return new ArrayList<>();
    }

    @ApiOperation(value = "根据infoId查询成员", notes = "根据infoId查询成员")
    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    ReportInfoEntity getInfo(String infoId){
        return infoService.getInfo(infoId);
    }

    @ApiOperation(value = "保存附属数据list", notes = "保存附属数据list")
    @RequestMapping(value = "/saveFormList", method = RequestMethod.POST)
    ReportInfoEntity saveFormList(@RequestBody ReportInfoEntity infoEntity){
        return infoService.saveFormList(infoEntity);
    }

    @ApiOperation(value = "删除报备", notes = "删除报备")
    @RequestMapping(value = "/removeInfo", method = RequestMethod.GET)
    Boolean removeInfo(String id){
        return infoService.removeInfo(id);
    }

    @ApiOperation(value = "管理员报备", notes = "管理员报备")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    ReportInfoEntity save(@RequestBody ReportInfoEntity info){
        return infoService.save(info);
    }

    @ApiOperation(value = "判断项目编码是否已存在", notes = "判断项目编码是否已存在")
    @RequestMapping(value = "/isOnlyXmba", method = RequestMethod.POST)
    ReportInfoEntity isOnlyXmba(@RequestBody ReportInfoEntity info){
        return infoService.isOnlyXmba(info);
    }

    @ApiOperation(value = "管理员报备修改", notes = "管理员报备修改")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    ReportInfoEntity update(@RequestBody ReportInfoEntity info){
        return infoService.update(info);
    }

    @ApiOperation(value = "根据id修改项目状态", notes = "根据id修改项目状态")
    @RequestMapping(value = "/updateXmzt", method = RequestMethod.POST)
    ReportInfoEntity updateXmzt(@RequestBody ReportInfoQuery info){
        return infoService.updateXmzt(info);
    }

    @ApiOperation(value = "获得地区树形", notes = "获得地区树形")
    @RequestMapping(value = "/getAreaTreeData", method = RequestMethod.GET)
    List<Map> getAreaTreeData(String lastType){
        return infoService.getAreaTreeData(lastType);
    }


    @ApiOperation(value = "合同管理查询", notes = "合同管理查询")
    @RequestMapping(value = "/contract", method = RequestMethod.POST)
    List<ReportInfoEntity> contractList(HttpServletRequest request,@RequestBody ReportInfoQuery infoQuery){
        HttpSession session = request.getSession();
        CurrentUser currentUser = (CurrentUser)session.getAttribute("currentUser");
        if(currentUser != null){
            infoQuery.setCurrentUser(currentUser);
            return infoService.contractList(infoQuery);
        }
        return new ArrayList<>();

    }

    @ApiOperation(value = "根据infoId获得合同", notes = "根据infoId获得合同")
    @RequestMapping(value = "/getContract", method = RequestMethod.GET)
    ReportInfoCjshEntity getContract(String infoId){
        return infoService.getContract(infoId);
    }

    @ApiOperation(value = "保存项目合同", notes = "保存项目合同")
    @RequestMapping(value = "/saveContract", method = RequestMethod.POST)
    ReportInfoCjshEntity saveContract(@RequestBody ReportInfoCjshEntity entity){
        return infoService.saveContract(entity);
    }

    @ApiOperation(value = "上传文件", notes = "上传文件")
    @RequestMapping(value = "/upload")
    Map<String, String> upload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("infoId") String infoId){
        String realName = multipartFile.getOriginalFilename();
        Map<String, String> result = new HashMap<>();
        result.put("name",realName);
        try {
            File upload =  ResourceUtils.getFile("classpath:upload");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String fileName = sdf.format(new Date())+"_"+ UUID.randomUUID().toString() + "." + realName.split("\\.")[1];
            File file = new File(upload,fileName);
            multipartFile.transferTo(file);

            SysFileEntityEntity fileEntity = new SysFileEntityEntity();
            String fileId = UUID.randomUUID().toString();
            fileEntity.setFileId(fileId);
            fileEntity.setFileMd5(getMD5(file));
            fileEntity.setFilePath(fileName);
            fileEntity.setFileType(realName);
            fileEntity.setFileSize(file.length());

            String fileUploadId = infoService.saveFileUpload(fileEntity,infoId);
            if(StringUtils.isNotEmpty(fileUploadId)){
                result.put("status","done");
                result.put("uid",fileUploadId);
                result.put("url","/business-analysis-web/api/reportInfo/download?id="+fileUploadId);
                //result.put("url","/api/reportInfo/download?id="+fileUploadId);
                return result;
            }
        }catch (Exception ex){

        }
        result.put("status","error");
        result.put("response","上传错误");
        return result;
    }

    @ApiOperation(value = "获得上传文件列表", notes = "获得上传文件列表")
    @RequestMapping(value = "/getFileUpload", method = RequestMethod.GET)
    List<Map> getFileUpload(String infoId){
        return infoService.getFileUpload(infoId);
    }

    @RequestMapping(value = "/download")
    void download(String id, HttpServletRequest request , HttpServletResponse response){
        SysFileUploadEntity entity = infoService.getFile(id);
        if(entity != null){
            String fileName = entity.getFileEntity().getFilePath();

            String showName = entity.getFileName();

            FileInputStream hFile = null;
            OutputStream toClient = null;
            try {
                File file = ResourceUtils.getFile("classpath:upload/"+fileName);
                hFile = new FileInputStream(file);
                //得到文件大小
                int i = hFile.available();
                byte data[] = new byte[i];
                //读数据
                hFile.read(data);
                // 设置response的Header
                response.reset();//
                response.setContentType("application/octet-stream; charset=utf-8");
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(showName.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
                //得到向客户端输出二进制数据的对象
                toClient = response.getOutputStream();
                //输出数据
                toClient.write(data);
                toClient.flush();
            }catch (Exception ex){
                System.out.println(ex);
            }finally {
                try {
                    toClient.close();
                    hFile.close();
                } catch (IOException e) {

                }
            }

        }
    }

    public String getMD5(File file) {
        FileInputStream fileInputStream = null;
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
            }
        }
    }


}
