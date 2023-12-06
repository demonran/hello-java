package com.hellojava.webflux.flight.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 航班关注响应对象
 *
 * @author HuangXin
 * @date 2023/9/6
 */
@Data
public class FimsFlightFavoriteVo {


    private Long userId;

    private Long postId;

    private Long deptId;

    private String type;

    private Long id;
    @JsonIgnore
    private Long flightId;

}
