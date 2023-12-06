package com.hellojava.r2dbc.flight;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 航班信息响应对象
 *
 * @author HuangXin
 * @date 2023/4/3
 */
@Data
public class FimsFlightVo {


    /**
     * 航班ID
     */
    private Long flightId;

    /**
     * 航司ICAO代码
     */
    private String airlineIcaoCode;

    /**
     * 航司IATA代码
     */
    private String airlineIataCode;

    /**
     * 航班号，不含航司IATA代码
     */
    private String flightNo;

    /**
     * 航班方向
     */
    private String direction;

    /**
     * 航线类型，DOM-国内，INT-国际，REG-地区，MIX-混合
     */
    private String routeType;

    /**
     * 飞行任务代码
     */
    private String flyTaskCode;

    /**
     * 飞行任务
     */
    private String flyTaskName;

    /**
     * 机号
     */
    public String regNo;

    /**
     * 机型ICAO代码
     */
    public String aerocraftTypeIcaoCode;

    /**
     * 航班运营日期。同一批次的航班计划运营日期相同
     */
    private LocalDate operationDate;

    /**
     * 计划日期，进港航班指计划进港日期，出港航班指计划出港日期
     */
    private LocalDate scheDate;

    /**
     * 计划时间，进港航班指计划进港时间，出港航班指计划出港时间
     */
    private LocalDateTime scheTime;

    /**
     * 预计落地时间，进港航班指本站，出港航班指下站
     */
    private LocalDateTime eldt;

    /**
     * 预计起飞时间，进港航班指前站，出港航班指本站
     */
    private LocalDateTime etot;

    /**
     * 实际落地时间，进港航班指本站，出港航班指下站
     */
    private LocalDateTime aldt;

    /**
     * 实际起飞时间，进港航班指前站，出港航班指本站
     */
    private LocalDateTime atot;

    /**
     * 正常航班状态编码
     */
    private String normalStatus;

    /**
     * 混合航班国际段正常航班状态编码
     */
    private String intNormalStatus;


    /**
     * 异常航班状态编码
     */
    private String abnormalStatus;

    /**
     * 内部异常原因ID
     */
    private Long innerAbnormalReasonId;

    /**
     * 内部异常原因编码
     */
    protected String innerAbnormalReasonCode;

    /**
     * 内部异常原因名称
     */
    protected String innerAbnormalReasonName;

    /**
     * 外部异常原因ID
     */
    private Long extAbnormalReasonId;

    /**
     * 外部异常原因编码
     */
    protected String extAbnormalReasonCode;

    /**
     * 外部异常原因名称
     */
    protected String extAbnormalReasonName;

    /**
     * 航班是否调时
     */
    private Boolean scheTimeAdjusted;

    /**
     * 调时原因
     */
    private String adjustScheTimeReason;

    /**
     * 共享航班
     */
    public List<String> shareFlightNos;

    /**
     * FPL备降站（机场IATA代码）
     */
    public List<String> fplAltAirports;

    /**
     * 走廊口
     */
    private String airCorridor;


    /**
     * VIP等级，0表示非VIP
     */
    public Integer vipLevel;


    /**
     * 国内航站楼编号
     */
    private String terminalCode;

    /**
     * 国际航站楼编号
     */
    private String intTerminalCode;

    /**
     * 跑道号
     */
    private String runwayCode;

    /**
     * 流控标识
     */
    private Boolean flowed;

    /**
     * 航班进程单状态
     */
    private String efsStatus;

    /**
     * 航班发布动态时间
     */
    private LocalDateTime publishTime;

    /**
     * 滑行时间VTT，时长，分钟
     */
    private Integer vtt;

    /**
     * 接飞航班ID flightlink查
     */
    private Long linkedId;


    /**
     * 是否拼接
     */
    private Boolean connected;

    /**
     * 拼接航班的航司IATA代码
     */
    private String linkedAirlineIataCode;

    /**
     * 拼接航班的航司ICAO代码
     */
    private String linkedAirlineIcaoCode;

    /**
     * 拼接航班的航班号
     */
    private String linkedFlightNo;

    /**
     * 拼接航班的共享航班号
     */
    private String linkedShareFlightNos;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否锁定预达时间
     */
    private Boolean lockEldt;


    /**
     * 标签
     */
    private List<FimsTagVo> tags;

    /**
     * 航站信息
     */
    private List<FimsFlightStationVo> flightStations;

    /**
     * 航班协同信息
     */
    private FimsFlightCollaborationVo flightCollaboration;

    /**
     * 机位信息
     */
    private List<String> standCodes;

    /**
     * 当前机位编号
     */
    private String currentStandCode;
    /**
     * 登机口信息
     */
    private List<String> gateCodes;
    /**
     * 行李提取转盘信息
     */
    private List<String> carouselCodes;
    /**
     * 行李分拣转盘信息
     */
    private List<String> chuteCodes;
    /**
     * 值机柜台信息
     */
    private List<String> counterCodes;
    /**
     * 值机岛信息
     */
    private List<String> islandCodes;

    /**
     * 航班状态记录
     */
    private List<FimsFlightStatusRecordVo> flightStatusRecords;

    /**
     * 变更字段名
     */
    private List<String> changedFields;


    /**
     * 航班节点数据
     */
    private List<FimsFlightNodeVo> flightNodes;

    /**
     * 航班关注集合
     */
    private List<FimsFlightFavoriteVo> flightFavorites;

    /**
     * 航班备注集合
     */
    private List<FimsFlightRemarkVo> flightRemarks;

}
