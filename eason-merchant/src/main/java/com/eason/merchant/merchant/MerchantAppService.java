package com.eason.merchant.merchant;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import com.cartisan.utils.SnowflakeIdWorker;
import com.eason.merchant.merchant.request.MerchantParam;
import com.eason.merchant.merchant.request.MerchantQuery;
import com.eason.merchant.merchant.response.MerchantConverter;
import com.eason.merchant.merchant.response.MerchantDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;

/**
 * @author colin
 */
@Service
public class MerchantAppService {
    public static final String ERR_NAME_EXISTS = "商户已存在。";

    private final MerchantRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final MerchantConverter merchantConverter = MerchantConverter.CONVERTER;

    public MerchantAppService(MerchantRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<MerchantDto> searchMerchants(@NonNull MerchantQuery merchantQuery, @NonNull Pageable pageable) {
        final Page<Merchant> searchResult = repository.findAll(querySpecification(merchantQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                merchantConverter.convert(searchResult.getContent()));
    }

    public List<MerchantDto> getAllEnableMerchants() {
        final MerchantQuery merchantQuery = new MerchantQuery();
        merchantQuery.setStatus(1);

        return merchantConverter.convert(repository.findAll(querySpecification(merchantQuery),
                Sort.by(Sort.Direction.ASC, "sort")));
    }

    public MerchantDto getMerchant(Long id) {
        return merchantConverter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto addMerchant(MerchantParam merchantParam) {
        if (repository.existsByName(merchantParam.getName())) {
            throw new CartisanException(CodeMessage.VALIDATE_ERROR.fillArgs(ERR_NAME_EXISTS));
        }
        final Merchant merchant = new Merchant(idWorker.nextId(), merchantParam.getName(), merchantParam.getShopName(),
                merchantParam.getAccount(), merchantParam.getPassword(), merchantParam.getScope());

        return merchantConverter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public MerchantDto editMerchant(Long id, MerchantParam merchantParam) {
        if (repository.existsByNameAndIdNot(merchantParam.getName(), id)) {
            throw new CartisanException(CodeMessage.VALIDATE_ERROR.fillArgs(ERR_NAME_EXISTS));
        }
        final Merchant merchant = requirePresent(repository.findById(id));

        merchant.describe(merchantParam.getName(), merchantParam.getShopName(),
                merchantParam.getAccount(), merchantParam.getPassword(), merchantParam.getScope());

        return merchantConverter.convert(repository.save(merchant));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeMerchant(long id) {
        repository.deleteById(id);
    }


    @Transactional(rollbackOn = Exception.class)
    public void enable(Long id) {
        final Merchant merchant = requirePresent(repository.findById(id));
        merchant.enable();
        repository.save(merchant);
    }

    @Transactional(rollbackOn = Exception.class)
    public void disable(Long id) {
        final Merchant merchant = requirePresent(repository.findById(id));
        merchant.disable();
        repository.save(merchant);
    }
}
