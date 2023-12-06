package com.hellojava.r2dbc.flight;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 航班状态响应对象
 *
 * @author HuangXin
 * @date 2023/4/3
 */
@Data
public class FimsFlightStatusRecordVo {
    /**
     * 状态记录ID
     */
    private Long id;
    /**
     * 状态编码
     */
    private String statusCode;

    /**
     * 是否异常状态
     */
    private Boolean abnormal;

    /**
     * 航段，区分混合航班国内/国际段，非混合航班都是ALL
     */
    private String routeSection;

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
     * 状态实际时间
     */
    private LocalDateTime statusTime;

    /**
     * 操作时间
     */
    private LocalDateTime updateTime;


}
