package cn.yuhui.autoconfig;

import cn.yuhui.service.IpCountService;
import org.springframework.context.annotation.Bean;

public class IpAutoConfiguration {
    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}