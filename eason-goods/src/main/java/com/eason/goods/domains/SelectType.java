package com.eason.goods.domains;

/**
 * 属性、参数选择类型
 * @author colin
 */
public enum SelectType {
    Unique(0, "唯一"),
    Single(1, "单选"),
    Multiple(2, "多选");

    private final Integer code;
    private final String description;

    SelectType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
