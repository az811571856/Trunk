/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.luoteng.payment.service;

import net.luoteng.payment.model.OrderRequest;
import net.luoteng.payment.model.Response;
import net.luoteng.model.common.RestResponse;
/**
 * 
 *
 * @author suetming <suetming.ma at gmail.com>
 * Copyright(c) @2016 Luoteng Company, Inc.  All Rights Reserved.
 */
public interface PaymentService {

    /**
     * 生成预支付订单
     * 
     * @param userId
     * @param request
     * @return 
     */
    public RestResponse preOrders(String userId, OrderRequest request) ;
 
    /**
     * 验证是否是正确的源发出的回调
     * 
     * @param response
     * @return 
     */
    public boolean verifyNotify(Response response);
    
}
