package com.atguigu.guli.service.trade.service;

import java.util.Map;

/**
 * @author helen
 * @since 2020/5/6
 */
public interface WeixinPayService {

    Map<String, Object> createNative(String orderNo, String remoteAddr);
}
