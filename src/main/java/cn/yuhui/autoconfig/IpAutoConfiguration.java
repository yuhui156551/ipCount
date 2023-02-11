package cn.yuhui.autoconfig;

import cn.yuhui.properties.IpProperties;
import cn.yuhui.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import(IpProperties.class)
public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}