package com.hellojava.webflux.flight.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 标签响应对象
 *
 * @author HuangXin
 * @date 2023/4/3
 */
@Data
public class FimsTagVo {

    @JsonIgnore
    private Long flightId;

    /**
     * 标签Id
     */
    private Long id;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签规则
     */
    private String type;


    /**
     * 标签图标
     */
    private FimsIconVo icon;

    /**
     * 背景颜色
     */
    private String backgroundColor;

    /**
     * 是否显示
     */
    private Boolean visible;

    /**
     * 编码
     */
    private String code;

    @JsonIgnore
    private String rawIcon;
}

