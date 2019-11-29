package com.eason.goods.services;

import com.eason.goods.domains.ProductCategoryAttributeRelation;
import com.eason.goods.repositories.ProductCategoryAttributeRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductCategoryAttributeRelationService {
    private final ProductCategoryAttributeRelationRepository repository;

    @Autowired
    public ProductCategoryAttributeRelationService(ProductCategoryAttributeRelationRepository repository) {
        this.repository = repository;
    }


    @Transactional(rollbackOn = Exception.class)
    public void addRelations(Long categoryId, List<Long> attributeIds) {
        attributeIds.forEach(attributeId -> repository.save(
                new ProductCategoryAttributeRelation(categoryId, attributeId)));
    }

    @Transactional(rollbackOn = Exception.class)
    public void editRelations(Long categoryId, List<Long> attributeIds) {
        final List<ProductCategoryAttributeRelation> relations = getProductCategoryAttributeRelations(categoryId);

        final List<Long> existAttributeIds = relations.stream().map(ProductCategoryAttributeRelation::getAttributeId).collect(Collectors.toList());

        attributeIds.stream().filter(attributeId -> !existAttributeIds.contains(attributeId))
                .forEach(attributeId -> repository.save(new ProductCategoryAttributeRelation(categoryId, attributeId)));

        relations.stream().filter(relation -> !attributeIds.contains(relation.getAttributeId()))
                .forEach(repository::delete);
    }

    private List<ProductCategoryAttributeRelation> getProductCategoryAttributeRelations(Long categoryId) {
        return repository.findAll((Specification<ProductCategoryAttributeRelation>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

            predicateList.add(criteriaBuilder.equal(root.get("categoryId"), categoryId));
//                    final CriteriaBuilder.In<Object> in = criteriaBuilder.in(root.get("attributeId"));
//                    attributeIds.stream().forEach(attributeId -> in.value(attributeId));
//                    predicateList.add(in);

            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeRelations(Long categoryId) {
        getProductCategoryAttributeRelations(categoryId).forEach(repository::delete);
    }

}
