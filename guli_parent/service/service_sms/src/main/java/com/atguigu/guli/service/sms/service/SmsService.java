package com.atguigu.guli.service.sms.service;

import com.aliyuncs.exceptions.ClientException;

/**
 * @author helen
 * @since 2020/4/29
 */
public interface SmsService {
    void send(String mobile, String checkCode) throws ClientException;
}
