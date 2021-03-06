/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.luoteng.order.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.luoteng.entity.AbstractTimeScopeEntity;
import net.luoteng.entity.embedded.RealmEntity;
import net.luoteng.enums.PayType;
import net.luoteng.order.enums.OrderStatus;
import net.luoteng.order.enums.OrderType;
import net.luoteng.order.utils.OrderGenerator;

/**
 * 订单
 *
 * @author suetming <suetming.ma at gmail.com>
 * Copyright(c) @2016 Luoteng Company, Inc. All Rights Reserved.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"orderId", "type", "status"})
})
public class Order extends AbstractTimeScopeEntity {

    /**
     * 本平台生成的订单号
     *
     * @return
     */
    @Column(nullable = false)
    private String orderId;

    /**
     * 三方生成的订单号
     *
     * @return
     */
    private String outOrderId;

    /**
     * 订单发起人
     *
     * @return
     */
    @Column(nullable = false)
    private String userId;

    /**
     * 订单类型
     *
     * @return
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderType type;

    /**
     * 订单状态
     *
     * @return
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    /**
     * 支付方式
     *
     * @return
     */
    @Enumerated(EnumType.STRING)
    private PayType payType;

    /**
     * 为哪个对象发起支付
     *
     * @return
     */
    @AttributeOverrides({
        @AttributeOverride(name = "realm", column
                = @Column(name = "owner_realm")),
        @AttributeOverride(name = "entityId", column
                = @Column(name = "owner_entity_id"))
    })
    private RealmEntity owner;

    /**
     * 订单总金额（三方+红包+余额）
     * 
     * @return
     */
    @Getter
    @Setter
    private long amount;
    
    /**
     * 订单中红包支付占用金额
     * 
     * @return
     */
    @Getter
    @Setter
    private long couponAmount;
    
    /**
     * 订单中余额支付占用金额
     * 
     * @return
     */
    @Getter
    @Setter
    private long balanceAmount;
    
    /**
     * 订单成功时间
     *
     * @return
     */
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSuccessed;

    /**
     * 订单失败时间
     *
     * @return
     */
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeFailed;

    /**
     * 订单取消时间
     *
     * @return
     */
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCaneled;
    
    /**
     * 订单过期时间
     * 
     * @return
     */
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeExpired;

    /**
     * 备注
     *
     * @return
     */
    private String remark;

    /**
     * 三方支付返回的数据
     *
     * @return
     */
    @Lob
    private String priv;

    public Order(
            String orderId,
            String userId,
            OrderType type,
            OrderStatus status,
            PayType payType,
            RealmEntity owner,
            long amount,
            long couponAmount,
            long balanceAmount) {
        
        this(
                orderId,
                null,
                userId,
                type,
                status,
                payType,
                owner,
                amount,
                couponAmount,
                balanceAmount,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

}
