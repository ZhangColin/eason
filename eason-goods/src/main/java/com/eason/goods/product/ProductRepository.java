package com.eason.goods.product;

import com.cartisan.repositories.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends BaseRepository<Product, Long> {

}
