package com.eason.goods.services;

import com.cartisan.dtos.PageResult;
import com.eason.goods.domains.Brand;
import com.eason.goods.dtos.BrandDto;
import com.eason.goods.params.BrandParam;
import com.eason.goods.repositories.BrandRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author colin
 */
@Service
public class BrandService {
    private final BrandRepository repository;

    @Autowired
    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<BrandDto> getAllBrands() {
        final List<Brand> brands = repository.findAll();
        return brands.stream().map(BrandDto::convertFrom).collect(Collectors.toList());
    }

    public BrandDto getBrand(Long id) {
        return BrandDto.convertFrom(repository.findById(id).get());
    }

    public PageResult<BrandDto> searchBrands(String name, Integer currentPage, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, pageSize,
                new Sort(Sort.Direction.DESC, "sort"));

        final Page<Brand> searchResult = repository.findAll((Specification<Brand>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(name)) {
                predicateList.add(criteriaBuilder.like(root.get("name"),
                        "%" + name + "%"));
            }

            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        }, pageRequest);

        return new PageResult<>(searchResult.getTotalElements(),searchResult.getTotalPages(),
                searchResult.map(BrandDto::convertFrom).getContent());
    }

    @Transactional(rollbackOn = Exception.class)
    public void addBrand(BrandParam brandParam) {
        final Brand brand = new Brand();
        BeanUtils.copyProperties(brandParam, brand);

        if (StringUtils.isEmpty(brand.getFirstLetter())) {
            brand.setFirstLetter(brand.getName().substring(0, 1));
        }

        repository.save(brand);
    }

    @Transactional(rollbackOn = Exception.class)
    public void editBrand(Long id, BrandParam brandParam) {
        final Brand brand = repository.findById(id).get();
        BeanUtils.copyProperties(brandParam, brand);
        brand.setId(id);

        if (StringUtils.isEmpty(brand.getFirstLetter())) {
            brand.setFirstLetter(brand.getName().substring(0, 1));
        }

        // TODO: 更新品牌时要更新商品中的品牌名称

        repository.save(brand);
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeBrand(long id) {
        repository.deleteById(id);
    }
}
