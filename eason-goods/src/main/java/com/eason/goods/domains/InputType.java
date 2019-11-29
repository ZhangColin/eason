package com.eason.goods.domains;

/**
 * 属性录入方式
 * @author colin
 */
public enum InputType {
    Enter(0, "手工录入"),
    Choose(1, "列表选取");

    private final Integer code;
    private final String description;

    InputType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
