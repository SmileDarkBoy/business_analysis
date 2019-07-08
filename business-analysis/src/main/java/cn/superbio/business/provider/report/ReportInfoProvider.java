package cn.superbio.business.provider.report;

import cn.superbio.business.DO.report.*;
import cn.superbio.business.DO.sys.SysDictData;
import cn.superbio.business.DO.sys.SysFileEntity;
import cn.superbio.business.DO.sys.SysFileUpload;
import cn.superbio.business.ReportInfoServiceApi;
import cn.superbio.business.entity.ReportInfoQuery;
import cn.superbio.business.entity.report.*;
import cn.superbio.business.entity.sys.SysFileEntityEntity;
import cn.superbio.business.entity.sys.SysFileUploadEntity;
import cn.superbio.business.service.report.*;
import cn.superbio.business.service.sys.SysDictDataService;
import cn.superbio.business.service.sys.SysFileEntityService;
import cn.superbio.business.service.sys.SysFileUploadService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

//@Service
@RestController
public class ReportInfoProvider implements ReportInfoServiceApi {
    @Autowired
    private ReportInfoService infoService;
    @Autowired
    private ReportInfoMemberService memberService;
    @Autowired
    private ReportInfoRivalService rivalService;
    @Autowired
    private ReportInfoFollowingService followingService;
    @Autowired
    private ReportInfoKxxdyService kxxdyService;
    @Autowired
    private ReportInfoCjshService cjshService;
    @Autowired
    private SysFileEntityService fileEntityService;
    @Autowired
    private SysFileUploadService fileUploadService;
    @Autowired
    private Mapper dozer;

    @Autowired
    private SysDictDataService dataService;
    @Autowired
    private ReportInfoCustomerService customerService;
    @Autowired
    private ReportInfoAgencyService agencyService;

    @Override
    public List<ReportInfoEntity> list(@RequestBody ReportInfoQuery infoQuery) {
        QueryWrapper<ReportInfo> queryWrapper = new QueryWrapper<>();
        if (infoQuery != null) {
            //-----权限过滤--------
            String currentAuthority = infoQuery.getCurrentAuthority();
            if("admin".equals(currentAuthority)){
                String type = infoQuery.getType();
                if(!"0".equals(type)){ //0为管理员 跳过过滤
                    queryWrapper.eq("info_ssxq",type);
                }
            }else{
                String webchart = infoQuery.getWebchart();
                if(StringUtils.isNotEmpty(webchart)){
                    queryWrapper.eq("info_fzr",webchart);
                }else{
                    return new ArrayList<>();//给他报错
                }
            }
            //-----end--------

            if (StringUtils.isNotEmpty(infoQuery.getId()))
                queryWrapper.eq("id", infoQuery.getId());
            if (StringUtils.isNotEmpty(infoQuery.getInfoXmbm()))
                queryWrapper.like("info_xmbm", infoQuery.getInfoXmbm());
            if (StringUtils.isNotEmpty(infoQuery.getInfoYwlx()))
                queryWrapper.eq("info_ywlx", infoQuery.getInfoYwlx());
            if (StringUtils.isNotEmpty(infoQuery.getInfoSsdq()))
                queryWrapper.like("info_ssdq", infoQuery.getInfoSsdq());
            if (StringUtils.isNotEmpty(infoQuery.getInfoSsxq()))
                queryWrapper.eq("info_ssxq", infoQuery.getInfoSsxq());
            if (StringUtils.isNotEmpty(infoQuery.getInfoFzr()))
                queryWrapper.like("info_fzr", infoQuery.getInfoFzr());
            if (StringUtils.isNotEmpty(infoQuery.getInfoGsbm()))
                queryWrapper.eq("info_gsbm", infoQuery.getInfoGsbm());
            if (StringUtils.isNotEmpty(infoQuery.getInfoXmzt()))
                queryWrapper.eq("info_xmzt", infoQuery.getInfoXmzt());
        }
        queryWrapper.eq("status", 1).orderByDesc("create_date");
        return dozer.map(infoService.list(queryWrapper), List.class);
    }

    @Override
    public ReportInfoEntity getInfo(String infoId) {
        try {
            QueryWrapper<ReportInfo> queryInfo = new QueryWrapper<>();
            queryInfo.eq("id", infoId).eq("status", 1).orderByDesc("create_date");
            ReportInfoEntity entity = dozer.map(infoService.getOne(queryInfo), ReportInfoEntity.class);
            if (entity != null) {
                QueryWrapper<ReportInfoCustomer> queryCustomer = new QueryWrapper<>();
                queryCustomer.eq("info_id", infoId).eq("status", 1).orderByDesc("create_date");
                List<ReportInfoCustomer> customers = customerService.list(queryCustomer);
                entity.setInfoCustomerEntityList(dozer.map(customers,List.class));

                QueryWrapper<ReportInfoAgency> queryAgency = new QueryWrapper<>();
                queryAgency.eq("info_id", infoId).eq("status", 1).orderByDesc("create_date");
                List<ReportInfoAgency> agencys = agencyService.list(queryAgency);
                entity.setInfoAgencyEntityList(dozer.map(agencys,List.class));

                QueryWrapper<ReportInfoMember> queryMember = new QueryWrapper<>();
                queryMember.eq("info_id", infoId).eq("status", 1).orderByDesc("create_date");
                List<ReportInfoMember> members = memberService.list(queryMember);
                entity.setInfoMemberEntityList(dozer.map(members, List.class));

                QueryWrapper<ReportInfoRival> queryRival = new QueryWrapper<>();
                queryRival.eq("info_id", infoId).eq("status", 1).orderByDesc("create_date");
                List<ReportInfoRival> rivals = rivalService.list(queryRival);
                entity.setInfoRivalEntityList(dozer.map(rivals, List.class));

                QueryWrapper<ReportInfoFollowing> queryFollow = new QueryWrapper<>();
                queryFollow.eq("info_id", infoId).eq("status", 1).orderByDesc("create_date");
                List<ReportInfoFollowing> followings = followingService.list(queryFollow);
                entity.setInfoFollowingEntityList(dozer.map(followings, List.class));

                QueryWrapper<ReportInfoKxxdy> queryKxxdy = new QueryWrapper<>();
                queryKxxdy.eq("info_id", infoId).eq("status", 1);
                ReportInfoKxxdy kxxdy = kxxdyService.getOne(queryKxxdy);
                if (kxxdy == null) {
                    kxxdy = new ReportInfoKxxdy();
                    kxxdy.setInfoId(infoId);
                }
                entity.setInfoKxxdyEntity(dozer.map(kxxdy, ReportInfoKxxdyEntity.class));
            }
            return entity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public ReportInfoEntity saveFormList(@RequestBody ReportInfoEntity infoEntity) {
        try {
            QueryWrapper<ReportInfoMember> memberQuery = new QueryWrapper<>();
            memberQuery.eq("info_id", infoEntity.getId());
            memberService.remove(memberQuery);
            List<ReportInfoMemberEntity> members = infoEntity.getInfoMemberEntityList();
            for (ReportInfoMemberEntity member : members) {
                if (StringUtils.isEmpty(member.getId()))
                    member.setId(String.valueOf(UUID.randomUUID()));
            }
            if (members.size() != 0)
                memberService.saveBatch(dozer.map(members, List.class));

            QueryWrapper<ReportInfoRival> rivalQuery = new QueryWrapper<>();
            rivalQuery.eq("info_id", infoEntity.getId());
            rivalService.remove(rivalQuery);
            List<ReportInfoRivalEntity> rivals = infoEntity.getInfoRivalEntityList();
            for (ReportInfoRivalEntity rival : rivals) {
                if (StringUtils.isEmpty(rival.getId()))
                    rival.setId(String.valueOf(UUID.randomUUID()));
            }
            if (rivals.size() != 0)
                rivalService.saveBatch(dozer.map(rivals, List.class));

            QueryWrapper<ReportInfoFollowing> followQuery = new QueryWrapper<>();
            followQuery.eq("info_id", infoEntity.getId());
            followingService.remove(followQuery);
            List<ReportInfoFollowingEntity> follows = infoEntity.getInfoFollowingEntityList();
            for (ReportInfoFollowingEntity follow : follows) {
                if (StringUtils.isEmpty(follow.getId()))
                    follow.setId(String.valueOf(UUID.randomUUID()));
            }
            if (follows.size() != 0)
                followingService.saveBatch(dozer.map(follows, List.class));

            ReportInfoKxxdyEntity kxxdyEntity = infoEntity.getInfoKxxdyEntity();
            String kxxdyId = kxxdyEntity.getId();
            if (StringUtils.isNotEmpty(kxxdyId)) {
                kxxdyService.saveOrUpdate(dozer.map(kxxdyEntity, ReportInfoKxxdy.class));
            } else {
                kxxdyEntity.setId(String.valueOf(UUID.randomUUID()));
                kxxdyEntity.setCreateDate(new Date());
                kxxdyService.save(dozer.map(kxxdyEntity, ReportInfoKxxdy.class));
            }

            if("1".equals(infoEntity.getInfoXmzt())){
                infoEntity.setInfoXmzt("2");
                infoService.updateById(dozer.map(infoEntity,ReportInfo.class));
            }
            return infoEntity;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Boolean removeInfo(String id) {
        QueryWrapper<ReportInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id).eq("status", 1);
        ReportInfo target = new ReportInfo();
        target.setStatus(0);
        if (infoService.update(target, queryWrapper)) {
            return true;
        }
        return null;
    }

    String getXmbm(ReportInfoEntity info){
        String areaCode = info.getAreaCode();
        String khsx = info.getInfoCustomerEntityList().get(0).getCustomerKhsx();
        String khsxCode = dataService.getDictDataCode("customer_khsx",khsx).getExtend1();
        String ywxl = dataService.getDictDataCode("business_type",info.getInfoYwlx()).getExtend1();
        String xmxl = dataService.getDictDataCode("project_type",info.getInfoXmlx()).getExtend1();
        String fzr = info.getInfoFzr();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String xmbm = areaCode + khsxCode + ywxl + xmxl + fzr.substring(5) + sdf.format(new Date());
        return  xmbm;
    }

    @Override
    public ReportInfoEntity save(@RequestBody ReportInfoEntity info) {

        if(info != null){
            String xmbm = getXmbm(info);
            String infoId = UUID.randomUUID().toString();
            String areaCode = info.getAreaCode();

            info.setId(infoId);
            info.setInfoXmbm(xmbm);
            info.setInfoXmzt("1");
            info.setInfoSsdq(dataService.getFullName(areaCode));
            info.setCreateDate(new Date());

            List<ReportInfoCustomerEntity> infoCustomerEntityList = info.getInfoCustomerEntityList();
            List<ReportInfoAgencyEntity> infoAgencyEntityList = info.getInfoAgencyEntityList();
            for(ReportInfoCustomerEntity temp : infoCustomerEntityList){
                temp.setId(UUID.randomUUID().toString());
                temp.setInfoId(infoId);
            }
            for(ReportInfoAgencyEntity temp : infoAgencyEntityList){
                temp.setId(UUID.randomUUID().toString());
                temp.setInfoId(infoId);
            }
            customerService.saveBatch(dozer.map(infoCustomerEntityList,List.class));
            agencyService.saveBatch(dozer.map(infoAgencyEntityList,List.class));

            if(infoService.save(dozer.map(info,ReportInfo.class))){
                return new ReportInfoEntity();
            }
        }
        return null;
    }

    @Override
    public ReportInfoEntity isOnlyXmba(@RequestBody ReportInfoEntity info) {
        QueryWrapper<ReportInfo> queryWrapper = new QueryWrapper<>();

        String areaCode = info.getAreaCode();
        String khsx = info.getInfoCustomerEntityList().get(0).getCustomerKhsx();
        String khsxCode = dataService.getDictDataCode("customer_khsx",khsx).getExtend1();
        String ywxl = dataService.getDictDataCode("business_type",info.getInfoYwlx()).getExtend1();
        String xmxl = dataService.getDictDataCode("project_type",info.getInfoXmlx()).getExtend1();
        String xmbm = areaCode + khsxCode + ywxl + xmxl;

        queryWrapper.likeRight("info_xmbm",xmbm);
        List<ReportInfo> list = infoService.list(queryWrapper);
        if (list.size()==0){
            return new ReportInfoEntity();
        }
        return null;
    }

    @Override
    public ReportInfoEntity update(@RequestBody ReportInfoEntity info){
        try{
            infoService.updateById(dozer.map(info,ReportInfo.class));

            QueryWrapper<ReportInfoCustomer> customerQuery = new QueryWrapper<>();
            customerQuery.eq("info_id", info.getId());
            customerService.remove(customerQuery);
            List<ReportInfoCustomerEntity> customers = info.getInfoCustomerEntityList();
            for (ReportInfoCustomerEntity customer : customers) {
                if (StringUtils.isEmpty(customer.getId()))
                    customer.setId(String.valueOf(UUID.randomUUID()));
            }
            if (customers.size() != 0)
                customerService.saveBatch(dozer.map(customers, List.class));

            QueryWrapper<ReportInfoAgency> agencyQuery = new QueryWrapper<>();
            agencyQuery.eq("info_id", info.getId());
            agencyService.remove(agencyQuery);
            List<ReportInfoAgencyEntity> agencys = info.getInfoAgencyEntityList();
            for (ReportInfoAgencyEntity agency : agencys) {
                if (StringUtils.isEmpty(agency.getId()))
                    agency.setId(String.valueOf(UUID.randomUUID()));
            }
            if (agencys.size() != 0)
                agencyService.saveBatch(dozer.map(agencys, List.class));

            return info;

        }catch (Exception ex){

        }
        return null;
    }

    @Override
    public List<Map> getAreaTreeData(String lastType) {
        if(StringUtils.isEmpty(lastType)){
            lastType = "'district'";
        }
        String types = "";
        if(lastType.equals("'district'")) types = "'province','city','district'";
        if(lastType.equals("'city'")) types = "'province','city'";

        List<Map<String,Object>> baseMap = dataService.getAreaTreeData(types,lastType);
        List<Map> temp = null;
        try {
            temp = dataService.buildTree(baseMap,null,null,"parent","code",
                    unicodeToCn("\\u4e2d\\u534e\\u4eba\\u6c11\\u5171\\u548c\\u56fd"));
        } finally {


        }
        return temp;
    }

    private static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }

    @Override
    public ReportInfoEntity updateXmzt(@RequestBody ReportInfoQuery info){
        QueryWrapper<ReportInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1).eq("id",info.getId());
        ReportInfo reportInfo = infoService.getOne(queryWrapper);
        reportInfo.setInfoXmzt(info.getInfoXmzt());
        if(infoService.updateById(reportInfo)){
            return dozer.map(reportInfo,ReportInfoEntity.class);
        }
        return null;
    }

    @Override
    public List<ReportInfoEntity> contractList(@RequestBody ReportInfoQuery infoQuery) {
        QueryWrapper<ReportInfo> queryWrapper = new QueryWrapper<>();
        if (infoQuery != null) {
            //-----权限过滤--------
            String currentAuthority = infoQuery.getCurrentAuthority();
            if("admin".equals(currentAuthority)){
                String type = infoQuery.getType();
                if(!"0".equals(type)){ //0为管理员 跳过过滤
                    queryWrapper.eq("info_ssxq",type);
                }
            }else{
                String webchart = infoQuery.getWebchart();
                if(StringUtils.isNotEmpty(webchart)){
                    queryWrapper.eq("info_fzr",webchart);
                }else{
                    return new ArrayList<>();//给他报错
                }
            }
            //-----end--------

            if (StringUtils.isNotEmpty(infoQuery.getInfoXmbm()))
                queryWrapper.like("info_xmbm", infoQuery.getInfoXmbm());
            if (StringUtils.isNotEmpty(infoQuery.getInfoXmzt()))
                queryWrapper.eq("info_xmzt", infoQuery.getInfoXmzt());
        }
        queryWrapper.eq("status", 1).ge("info_xmzt","2").le("info_xmzt","3").orderByDesc("create_date");
        return dozer.map(infoService.list(queryWrapper), List.class);
    }

    @Override
    public ReportInfoCjshEntity getContract(String infoId) {
        if(StringUtils.isNotEmpty(infoId)){
            QueryWrapper<ReportInfoCjsh> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("info_id",infoId).eq("status",1);
            List<ReportInfoCjsh> cjshs = cjshService.list(queryWrapper);
            if(cjshs != null && !cjshs.isEmpty()){
                ReportInfoCjsh entity = cjshs.get(0);
                if(entity.getCjshHtqsrq() != null)
                    entity.setCjshHtqsrq(new Date(entity.getCjshHtqsrq().getTime()+12*60*60*1000));
                if(entity.getCjshHtsxrq() != null)
                    entity.setCjshHtsxrq(new Date(entity.getCjshHtsxrq().getTime()+12*60*60*1000));

                if(entity.getCjshHkrq() != null)
                    entity.setCjshHkrq(new Date(entity.getCjshHkrq().getTime()+12*60*60*1000));
                if(entity.getCjshZbsj() != null)
                    entity.setCjshZbsj(new Date(entity.getCjshZbsj().getTime()+12*60*60*1000));
                return dozer.map(entity,ReportInfoCjshEntity.class);
            }else{
                ReportInfoCjshEntity entity = new ReportInfoCjshEntity();
                entity.setInfoId(infoId);
                return entity;
            }
        }
        return null;
    }

    @Override
    public ReportInfoCjshEntity saveContract(@RequestBody ReportInfoCjshEntity entity){
        if(entity != null){
            String infoId = entity.getInfoId();
            QueryWrapper<ReportInfo> infoQuery = new QueryWrapper<>();
            infoQuery.eq("id",infoId).eq("status",1);
            ReportInfo info = infoService.getOne(infoQuery);
            if(info != null && "2,3".contains(info.getInfoXmzt())){
                SysFileUpload target = new SysFileUpload();
                target.setStatus(1);
                List<String> files = entity.getFiles();
                files.add("-1");//确保files不为空
                QueryWrapper<SysFileUpload> fileQuery = new QueryWrapper<>();
                fileQuery.in("id",files).eq("status",0).eq("biz_key",infoId);
                fileUploadService.update(target,fileQuery);

                if(StringUtils.isEmpty(entity.getId())){
                    entity.setId(UUID.randomUUID().toString());
                    boolean success = cjshService.save(dozer.map(entity,ReportInfoCjsh.class));
                    if(success){
                        info.setInfoXmzt("3");
                        infoService.updateById(info);
                        return entity;
                    }
                }else{
                    boolean success = cjshService.updateById(dozer.map(entity,ReportInfoCjsh.class));
                    if(success){
                        if("3".equals(info.getInfoXmzt())){
                            info.setInfoXmzt("3");
                            infoService.updateById(info);
                        }
                        return entity;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String saveFileUpload(@RequestBody SysFileEntityEntity fileEntity, @RequestParam("infoId") String infoId){
        if(fileEntityService.save(dozer.map(fileEntity,SysFileEntity.class))){
            SysFileUploadEntity fileUpload = new SysFileUploadEntity();
            fileUpload.setId(UUID.randomUUID().toString());
            fileUpload.setFileId(fileEntity.getFileId());
            fileUpload.setFileName(fileEntity.getFileType());
            fileUpload.setBizKey(infoId);
            fileUpload.setStatus(0);
            if(fileUploadService.save(dozer.map(fileUpload,SysFileUpload.class))){
                return fileUpload.getId();
            }
        }
        return "";
    }

    @Override
    public List<Map> getFileUpload(String infoId){
        List<Map> result = new ArrayList<>();
        if(StringUtils.isNotEmpty(infoId)){
            QueryWrapper<SysFileUpload> uploadQuery = new QueryWrapper<>();
            uploadQuery.eq("biz_key",infoId).eq("status",1);
            List<SysFileUpload> uploads = fileUploadService.list(uploadQuery);
            if(uploads != null){
                for(SysFileUpload entity : uploads){
                    String fileId = entity.getFileId();
                    QueryWrapper<SysFileEntity> fileQuery = new QueryWrapper<>();
                    fileQuery.eq("file_id",fileId);
                    SysFileEntity fileEntity= fileEntityService.getOne(fileQuery);
                    Map temp = new HashMap();
                    temp.put("uid",entity.getId());
                    temp.put("name",entity.getFileName());
                    temp.put("status","done");
                    try {
                        temp.put("url","/business-analysis-web/api/reportInfo/download?id="+entity.getId());
                        //temp.put("url","/api/reportInfo/download?id="+entity.getId());
                    }catch (Exception ex){

                    }
                    result.add(temp);
                }
            }
        }
        return result;
    }

    @Override
    public SysFileUploadEntity getFile(String id){
        SysFileUpload entity = fileUploadService.getById(id);
        if(entity != null){
            String fileId = entity.getFileId();
            QueryWrapper<SysFileEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("file_id",fileId);
            SysFileEntity fileEntity = fileEntityService.getOne(queryWrapper);
            SysFileUploadEntity result = dozer.map(entity,SysFileUploadEntity.class);
            result.setFileEntity(dozer.map(fileEntity,SysFileEntityEntity.class));
            return result;
        }
        return null;
    }


}
