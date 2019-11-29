package com.eason.goods.queries;

import com.eason.goods.dtos.ProductAttributeCategoryInfo;
import com.eason.goods.dtos.ProductAttributeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author colin
 */
@Service
public class ProductAttributeQuery {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductAttributeQuery(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductAttributeInfo> findByProductCategory(Long productCategoryId) {
        final String sql = "select pa.id as attributeId, pa.category_id as attributeCategoryId \n" +
                "from goods_product_category_attribute_relations as pcar \n" +
                "inner join goods_product_attributes as pa on pcar.attribute_id=pa.id where pcar.category_id=?\n" +
                "and pcar.active=1 and pcar.deleted=0 and pa.active=1 and pa.deleted=0";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ProductAttributeInfo.class), productCategoryId);
    }

    public List<ProductAttributeCategoryInfo> findAllParams() {
        final String sql = "select pac.id as attributeCategoryId, pac.`name` as attributeCategoryName, pa.id as attributeId, pa.`name` as attributeName\n" +
                "from goods_product_attribute_categories as pac\n" +
                "inner join goods_product_attributes as pa on pa.category_id = pac.id and pa.type=1\n" +
                "\tand pa.active=1 and pa.deleted=0 and pac.active=1 and pac.deleted=0\n";

        final List<ProductAttributeInfo> results = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(ProductAttributeInfo.class));

        List<ProductAttributeCategoryInfo> categories = new ArrayList<>();
        results.stream()
                .collect(groupingBy(ProductAttributeInfo::getAttributeCategoryId))
                .forEach((categoryId, attributes)->{
                    final ProductAttributeCategoryInfo categoryInfo = new ProductAttributeCategoryInfo();
                    categoryInfo.setAttributeCategoryId(attributes.get(0).getAttributeCategoryId());
                    categoryInfo.setAttributeCategoryName(attributes.get(0).getAttributeCategoryName());
                    categoryInfo.setAttributes(attributes);

                    categories.add(categoryInfo);
                });

        return categories;
    }
}
