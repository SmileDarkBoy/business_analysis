package cn.superbio.business.consumer;

import cn.superbio.business.JudicialUserServiceApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("business-analysis-java")
public interface JudicialUserServiceConsumer extends JudicialUserServiceApi {
}
