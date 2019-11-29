package com.eason.goods.domains;

/**
 * 属性筛选样式
 * @author colin
 */
public enum FilterType {
    Normal(0, "普通"),
    Color(1, "颜色");

    private final Integer code;
    private final String description;

    FilterType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }


}
