package com.eason.membership.user;

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
public class UserAppService {
    private final UserRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final UserConverter converter = UserConverter.CONVERTER;

    public UserAppService(UserRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<UserDto> searchUsers(@NonNull UserQuery userQuery, @NonNull Pageable pageable) {
        final Page<User> searchResult = repository.findAll(querySpecification(userQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                converter.convert(searchResult.getContent()));
    }

    public UserDto getUser(Long id) {
        return converter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public UserDto addUser(UserParam userParam) {
        final User user = new User(idWorker.nextId(),
        userParam.getName(),
        userParam.getAge(),
        userParam.getAccount(),
        userParam.getPasswordEncrypt(),
        userParam.getAddress(),
        userParam.getTelphone(),
        userParam.getQq(),
        userParam.getEmail(),
        userParam.getWeixin(),
        userParam.getSex());

        return converter.convert(repository.save(user));
    }

    @Transactional(rollbackOn = Exception.class)
    public UserDto editUser(Long id, UserParam userParam) {
        final User user = requirePresent(repository.findById(id));

        user.describe(userParam.getName(),
        userParam.getAge(),
        userParam.getAccount(),
        userParam.getPasswordEncrypt(),
        userParam.getAddress(),
        userParam.getTelphone(),
        userParam.getQq(),
        userParam.getEmail(),
        userParam.getWeixin(),
        userParam.getSex());

        return converter.convert(repository.save(user));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeUser(long id) {
        repository.deleteById(id);
    }
}
