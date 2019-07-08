package cn.superbio.business.mapper.report;

import cn.superbio.business.DO.report.ReportInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ReportInfoMapper extends BaseMapper<ReportInfo> {
    @Select({"select distinct info_fzr from business_report_info where status=1"})
    List<String> getWebchart();

}
