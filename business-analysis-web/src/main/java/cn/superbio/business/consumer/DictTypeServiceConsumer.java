package cn.superbio.business.consumer;

import cn.superbio.business.DictTypeServiceApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@FeignClient("business-analysis-java")
public interface DictTypeServiceConsumer extends DictTypeServiceApi {

}
