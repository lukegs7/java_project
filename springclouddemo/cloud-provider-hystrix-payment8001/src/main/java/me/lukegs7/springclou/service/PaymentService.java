package me.lukegs7.springclou.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问，肯定ok
     *
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfoOK: " + id + "\t" + "哈哈";
    }

    /**
     * 正常访问，肯定ok
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 8;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + " paymentInfoTimeout: " + id + "\t" + "哈哈" + " 耗时(s): " + timeNumber + "s";
    }

    //服务熔断，在10s内10次请求中有60%是失败的，就发生熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        if (id < 0) {
            throw new RuntimeException("****id 不能为负数");
        }
        // 等价于UUID.randomUUID()
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试，id：" + id;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfoTimeout: " + id + "\t" + "wuwu";
    }
}
