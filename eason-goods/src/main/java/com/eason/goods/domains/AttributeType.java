package com.eason.goods.domains;

import lombok.Getter;

/**
 * 属性类型
 * @author colin
 */
@Getter
public enum AttributeType {
    Specification(0, "规格"),
    Param(1, "参数");

    private final Integer code;
    private final String description;

    AttributeType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static AttributeType valueOf(Integer value) {
        return AttributeType.values()[value];
    }
}
