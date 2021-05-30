package com.eason.goods.category;

import com.cartisan.repositories.BaseRepository;
import java.util.List;

/**
 * @author colin
 */
public interface CategoryRepository extends BaseRepository<Category, Long> {
    List<Category> findByIdIn(List<Long> categoryIds);
}
