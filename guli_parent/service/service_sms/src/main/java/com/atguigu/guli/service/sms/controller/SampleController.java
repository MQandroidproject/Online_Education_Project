package com.atguigu.guli.service.sms.controller;

import com.atguigu.guli.common.base.result.R;
import com.atguigu.guli.service.sms.util.SmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author helen
 * @since 2020/5/9
 */
@RestController
@RequestMapping("/sms/sample")
@RefreshScope
public class SampleController {

    @Autowired
    private SmsProperties smsProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${aliyun.sms.signName}")
    private String signName;

    @GetMapping("test-sing-name")
    public R testSingName(){
        return R.ok().data("signName", signName);
    }

    @GetMapping("test-sms-properties")
    public R testSmsProperties(){
        return R.ok().data("smsProperties", smsProperties);
    }

    @GetMapping("test-redis")
    public R testRedis(){
        redisTemplate.opsForValue().set("test", "123", 5, TimeUnit.MINUTES);
        return R.ok();
    }
}
