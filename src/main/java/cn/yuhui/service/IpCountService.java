package cn.yuhui.service;

import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuhui
 * @date 2023/2/11 20:00
 */
public class IpCountService {

    private Map<String, Integer> ipCountMap = new HashMap<>();

    @Resource
    private HttpServletRequest request;

    public void count() {
        // 每次调用当前操作，就记录当前访问ip，累加访问次数
        // 1、获取访问者ip
        String ip = request.getRemoteAddr();
        System.out.println("--------------" + ip);
        // 2、根据ip从map取值并递增（如果第一次访问，给默认值1）
        ipCountMap.put(ip, ipCountMap.getOrDefault(ip, 0) + 1);
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void print() {
        System.out.println("         IP访问监控");
        System.out.println("+-----ip-address-----+--num--+");
        for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(String.format("|%18s  |%5d  |", key, value));
        }
        System.out.println("+--------------------+-------+");
    }

    public static void main(String[] args) {
        System.out.println("         IP访问监控");
        System.out.println("+-----ip-address-----+--num--+");
        System.out.println(String.format("|%18s  |%5d  |", "abc", 123));
        System.out.println("+--------------------+-------+");
    }
}
