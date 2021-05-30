package com.eason.goods.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Data
public class CategoryDto {
    @ApiModelProperty(value = "商品分类Id")
    private String id;

    @ApiModelProperty(value = "上级商品分类")
    private String parentId;

    @ApiModelProperty(value = "商品分类名称")
    private String name;

    @ApiModelProperty(value = "商品分类排序")
    private Integer sort;

    @Setter
    @JsonProperty("children")
    private List<CategoryDto> childCategories;

    public static List<CategoryDto> buildCategoryTreeList(List<CategoryDto> menus) {
        Multimap<String, CategoryDto> menuMap = ArrayListMultimap.create();
        menus.forEach(menu -> menuMap.put(menu.getParentId(), menu));

        return buildCategoryTreeList("0", menuMap);
    }

    private static List<CategoryDto> buildCategoryTreeList(String parentId, Multimap<String, CategoryDto> menuMap) {
        return menuMap.get(parentId).stream()
                .peek(menu -> {
                    final List<CategoryDto> childCategories = buildCategoryTreeList(menu.getId(), menuMap);
                    if (childCategories.size()>0) {
                        menu.setChildCategories(childCategories);
                    }
                })
                .collect(Collectors.toList());
    }
}
