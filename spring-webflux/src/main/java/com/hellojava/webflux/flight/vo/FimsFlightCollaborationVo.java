package com.hellojava.webflux.flight.vo;


import lombok.Data;

import java.time.LocalDateTime;

/**
 * 航班协同 实体
 *
 * @author HuangXin
 * @date 2023/4/3
 */
@Data
public class FimsFlightCollaborationVo {
    /**
     * 目标撤轮挡时间
     */
    private LocalDateTime tobt;
    /**
     * 计算撤轮挡时间
     */
    private LocalDateTime cobt;
    /**
     * 计算起飞时间
     */
    private LocalDateTime ctot;

    /**
     * 预计撤轮挡时间
     */
    private LocalDateTime eobt;

    /**
     * 目标许可开车时间
     */
    private LocalDateTime tsat;


    /**
     * 放行警戒时间
     */
    private LocalDateTime wtot;

    /**
     * 目标起飞时间
     */
    private LocalDateTime ttot;

}
