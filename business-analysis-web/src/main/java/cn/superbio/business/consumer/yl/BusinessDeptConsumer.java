package cn.superbio.business.consumer.yl;

import cn.superbio.business.BusinessDeptServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
@FeignClient("business-analysis-java")
public interface BusinessDeptConsumer extends BusinessDeptServiceApi {
}
