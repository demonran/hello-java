package com.hellojava.r2dbc.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 航班节点动态汇报响应对象
 *
 * @author HuangXin
 * @date 2023/4/3
 */
@Data
public class FimsFlightNodeVo {

    @JsonIgnore
    private Long flightId;

    private Long id;

    /**
     * 节点定义主键
     */
    private Long nodeId;
    /**
     * 节点定义名称
     */
    private String nodeName;
    /**
     * 节点定义编码
     */
    private String nodeCode;


    /**
     * 航班节点保障岗位ID集合
     */
    private List<Long> postIds;

    /**
     * 航班节点标准要求时间
     */
    private LocalDateTime standardTime;

    /**
     * 航班节点预警时间
     */
    private LocalDateTime alarmTime;

    /**
     * 航班节点状态
     */
    private String status;


    /**
     * 航班节点汇报时间
     */
    private LocalDateTime reportTime;

    @JsonIgnore
    private String reportablePostIds;

}
