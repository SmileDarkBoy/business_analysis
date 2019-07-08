package cn.superbio.business.service.report.impl;

import cn.superbio.business.DO.report.ReportInfo;
import cn.superbio.business.mapper.report.ReportInfoMapper;
import cn.superbio.business.service.report.ReportInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportInfoServiceImpl extends ServiceImpl<ReportInfoMapper, ReportInfo> implements ReportInfoService {
    @Autowired
    private ReportInfoMapper infoMapper;

    @Override
    public List<String> getWebchart() {
        return infoMapper.getWebchart();
    }
}
