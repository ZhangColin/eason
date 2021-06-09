package com.eason.merchant.merchant;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cartisan.utils.SnowflakeIdWorker;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;
import static java.util.stream.Collectors.toList;

@Service
public class MerchantAppService {
    private final MerchantRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final MerchantConverter converter = MerchantConverter.CONVERTER;

    public MerchantAppService(MerchantRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<MerchantDto> searchMerchants(@NonNull MerchantQuery merchantQuery, @NonNull Pageable pageable) {
        final Page<Merchant> searchResult = repository.findAll(querySpecification(merchantQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public MerchantDto getMerchant(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto addMerchant(MerchantParam merchantParam) {
        final Merchant merchant = new Merchant(idWorker.nextId(),
        merchantParam.getName(),
        merchantParam.getShopName(),
        merchantParam.getAccount(),
        merchantParam.getPassword(),
        merchantParam.getScope(),
        merchantParam.getStatus(),
        merchantParam.getAuditStatus());

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto editMerchant(Long id, MerchantParam merchantParam) {
        final Merchant merchant = requirePresent(repository.findById(id));

        merchant.describe(merchantParam.getName(),
        merchantParam.getShopName(),
        merchantParam.getAccount(),
        merchantParam.getPassword(),
        merchantParam.getScope(),
        merchantParam.getStatus(),
        merchantParam.getAuditStatus());

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeMerchant(long id) {
        repository.deleteById(id);
    }
}
