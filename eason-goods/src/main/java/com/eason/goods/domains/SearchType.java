package com.eason.goods.domains;

/**
 * 属性、参数检索类型
 * @author colin
 */
public enum SearchType {
    NotSearch(0, "不需要进行检索"),
    Keyword(1, "关键字检索"),
    Range(2, "范围检索");

    private final Integer code;
    private final String description;

    SearchType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
