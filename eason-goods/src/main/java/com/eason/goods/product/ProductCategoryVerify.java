package com.eason.goods.product;

import com.eason.goods.category.CategoryAppService;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author colin
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductCategoryVerify.Validator.class)
public @interface ProductCategoryVerify {
    String message() default "产品分类不存在";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ProductCategoryVerify, Long> {
        private final CategoryAppService categoryAppService;

        public Validator(CategoryAppService categoryAppService) {
            this.categoryAppService = categoryAppService;
        }

        @Override
        public boolean isValid(Long value, ConstraintValidatorContext context) {
            return categoryAppService.getAllCategories().stream()
                    .anyMatch(productCategoryDto -> productCategoryDto.getId().equals(value.toString()));
        }
    }
}
