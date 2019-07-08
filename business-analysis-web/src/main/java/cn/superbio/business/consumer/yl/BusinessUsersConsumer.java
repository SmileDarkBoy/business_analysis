package cn.superbio.business.consumer.yl;

import cn.superbio.business.BusinessUsersServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
@FeignClient("business-analysis-java")
public interface BusinessUsersConsumer extends BusinessUsersServiceApi {
}
