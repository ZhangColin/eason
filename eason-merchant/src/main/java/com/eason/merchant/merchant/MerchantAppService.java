package com.eason.merchant.merchant;

import com.cartisan.dtos.PageResult;
import com.cartisan.utils.SnowflakeIdWorker;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;

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
                merchantParam.getScope());

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto editMerchant(Long id, MerchantParam merchantParam) {
        final Merchant merchant = requirePresent(repository.findById(id));

        merchant.describe(merchantParam.getName(),
                merchantParam.getShopName(),
                merchantParam.getAccount(),
                merchantParam.getPassword(),
                merchantParam.getScope());

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeMerchant(long id) {
        repository.deleteById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto approve(Long id) {
        final Merchant merchant = requirePresent(repository.findById(id));
        merchant.approve();

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto reject(Long id) {
        final Merchant merchant = requirePresent(repository.findById(id));
        merchant.reject();

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto enable(Long id) {
        final Merchant merchant = requirePresent(repository.findById(id));
        merchant.enable();

        return converter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto disable(Long id) {
        final Merchant merchant = requirePresent(repository.findById(id));
        merchant.disable();

        return converter.convert(repository.save(merchant));
    }
}
