package com.eason.goods.product;

import com.cartisan.repositories.BaseRepository;

import java.util.List;

/**
 * @author colin
 */
public interface ProductRepository extends BaseRepository<Product, Long> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);

    List<Product> findByIdIn(List<Long> resourceIds);
}
