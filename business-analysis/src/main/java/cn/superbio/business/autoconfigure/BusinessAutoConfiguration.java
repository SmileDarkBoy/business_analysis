package cn.superbio.business.autoconfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan( "cn.superbio.business.mapper*" )
@ComponentScan(basePackages = {"cn.superbio.business.provider", "cn.superbio.business.service"})
public class BusinessAutoConfiguration {
}
