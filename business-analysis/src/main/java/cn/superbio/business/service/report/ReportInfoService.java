package cn.superbio.business.service.report;

import cn.superbio.business.DO.report.ReportInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

public interface ReportInfoService extends IService<ReportInfo> {
    List<String> getWebchart();
}
