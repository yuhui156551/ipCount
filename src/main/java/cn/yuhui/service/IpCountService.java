package cn.yuhui.service;

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

    public void count(){
        // 每次调用当前操作，就记录当前访问ip，累加访问次数
        // 1、获取访问者ip
        String ip = request.getRemoteAddr();
        System.out.println("--------------" + ip);
        // 2、根据ip从map取值并递增（如果第一次访问，给默认值1）
        ipCountMap.put(ip, ipCountMap.getOrDefault(ip, 0) + 1);
    }
}
