package com.eason.goods.category;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.utils.AssertionUtil.requirePresent;

/**
 * @author colin
 */
@Service
public class CategoryAppService {
    private final CategoryConverter converter = CategoryConverter.CONVERTER;
    private final CategoryRepository repository;

    public CategoryAppService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDto> getCategoryTreeList() {
        final List<CategoryDto> categoryDtos = converter.convert(
                repository.findAll(Sort.by(Sort.Direction.ASC, "sort")));

        return CategoryDto.buildCategoryTreeList(categoryDtos);
    }

    public List<CategoryDto> getAllCategories() {
        return converter.convert(repository.findAll());
    }

    @Transactional(rollbackOn = Exception.class)
    public CategoryDto addCategory(CategoryParam categoryParam) {
        final Category category = new Category(categoryParam.getParentId(),
                categoryParam.getName(),  0, categoryParam.getSort());

        return converter.convert(repository.save(category));
    }

    @Transactional(rollbackOn = Exception.class)
    public CategoryDto editCategory(Long id, CategoryParam categoryParam) {
        final Category category = requirePresent(repository.findById(id));

        category.change(categoryParam.getParentId(),
                categoryParam.getName(),  0, categoryParam.getSort());

        return converter.convert(repository.save(category));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeCategory(long id) {
        repository.deleteById(id);
    }
}
