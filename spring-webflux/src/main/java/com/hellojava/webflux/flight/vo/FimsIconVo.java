package com.hellojava.webflux.flight.vo;

import lombok.Data;

/**
 * 标签图标响应对象
 *
 * @author HuangXin
 * @date 2023/7/20
 */
@Data
public class FimsIconVo {
    /**
     * 名称
     */
    private String title;
    /**
     * 图标
     */
    private String icon;
    /**
     * 图标模式
     */
    private String mode;
    /**
     * 标签文字
     */
    private String label;
    /**
     * 标签背景色
     */
    private String bgColor;
    /**
     * 标签字体色
     */
    private String textColor;
    /**
     * 标签边框色
     */
    private String borderColor;
    /**
     * 是否为圆形标签
     */
    private Boolean round;
}
