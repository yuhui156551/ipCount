package cn.yuhui.autoconfig;

import cn.yuhui.service.IpCountService;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}