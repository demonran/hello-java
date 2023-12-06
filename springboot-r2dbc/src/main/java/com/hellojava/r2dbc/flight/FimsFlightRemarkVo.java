package com.hellojava.r2dbc.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 航班备注响应对象
 *
 * @author HuangXin
 * @date 2023/9/6
 */
@Data
public class FimsFlightRemarkVo {

    private Long userId;
    private Long postId;
    private Long deptId;
    private String remark;
    private String type;
    private Long id;
    @JsonIgnore
    private Long flightId;

}
