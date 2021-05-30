package com.eason.goods.category;

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
@Constraint(validatedBy = ParentCategoryVerify.Validator.class)
public @interface ParentCategoryVerify {
    String message() default "指定的上级分类不正确";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class Validator implements ConstraintValidator<ParentCategoryVerify, Long> {

        private final CategoryRepository categoryRepository;

        public Validator(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        @Override
        public boolean isValid(Long value, ConstraintValidatorContext context) {
            if (value.equals(0L)) {
                return true;
            }

            return categoryRepository.existsById(value);
        }
    }
}
