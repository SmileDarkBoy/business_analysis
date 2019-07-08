package cn.superbio.business.consumer;

import cn.superbio.business.ReportInfoServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@FeignClient("business-analysis-java")
public interface ReportInfoServiceConsumer extends ReportInfoServiceApi {
}
