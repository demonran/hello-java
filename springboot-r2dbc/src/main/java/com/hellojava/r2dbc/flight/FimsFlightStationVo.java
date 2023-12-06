package com.hellojava.r2dbc.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 航站响应对象
 *
 * @author HuangXin
 * @date 2023/4/3
 */
@Data
public class FimsFlightStationVo {

    @JsonIgnore
    private Long flightId;
    /**
     * 航站ID
     */
    private Long id;

    /**
     * 航站IATA代码
     */
    private String airportIataCode;
    /**
     * 航站ICAO代码
     */
    private String airportIcaoCode;

    /**
     * 航站简称
     */
    private String airportShortName;

    /**
     * 国际或地区
     */
    private String countryOrRegion;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地区管理局
     */
    private String controlArea;

    /**
     * 时区
     */
    private Integer timeZone;
    /**
     * 计划进港时间。航班调时，记录的是最新的调时后的时间
     */
    private LocalDateTime sibt;
    /**
     * 计划出港时间。航班调时，记录的是最新的调时后的时间
     */
    private LocalDateTime sobt;
    /**
     * 预计落地时间
     */
    private LocalDateTime eldt;
    /**
     * 预计起飞时间
     */
    private LocalDateTime etot;
    /**
     * 实际落地时间
     */
    private LocalDateTime aldt;
    /**
     * 实际起飞时间
     */
    private LocalDateTime atot;
    /**
     * 原始计划进港时间。航班调时不会更改
     */
    private LocalDateTime originalSibt;
    /**
     * 原始计划出港时间。航班调时不会更改
     */
    private LocalDateTime originalSobt;
    /**
     * 上一次计划进港时间。航班发生多次调时，记录的是上次调时后的时间
     */
    private LocalDateTime lastSibt;
    /**
     * 上一次计划出港时间。航班发生多次调时，记录的是上次调时后的时间
     */
    private LocalDateTime lastSobt;
    /**
     * 特殊标记，N-普通，A-备降，C-取消
     */
    public String flag;

    /**
     * 内部异常原因ID
     */
    private Long innerAbnormalReasonId;

    /**
     * 内部异常原因编码
     */
    private String innerAbnormalReasonCode;

    /**
     * 内部异常原因名称
     */
    private String innerAbnormalReasonName;

    /**
     * 外部异常原因ID
     */
    private Long extAbnormalReasonId;

    /**
     * 外部异常原因编码
     */
    private String extAbnormalReasonCode;

    /**
     * 外部异常原因名称
     */
    private String extAbnormalReasonName;

    /**
     * 排序，从0开始
     */
    private Integer sequence;

}
