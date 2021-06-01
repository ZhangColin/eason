package com.eason.membership.user;

import com.cartisan.constants.CodeMessage;
import com.cartisan.dtos.PageResult;
import com.cartisan.exceptions.CartisanException;
import com.cartisan.utils.SnowflakeIdWorker;
import com.eason.membership.user.request.UserParam;
import com.eason.membership.user.request.UserQuery;
import com.eason.membership.user.response.UserConverter;
import com.eason.membership.user.response.UserDto;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;

/**
 * @author colin
 */
@Service
public class UserAppService {
    public static final String ERR_NAME_EXISTS = "用户已存在。";

    private final UserRepository repository;
    private final SnowflakeIdWorker idWorker;

    private final UserConverter userConverter = UserConverter.CONVERTER;

    public UserAppService(UserRepository repository, SnowflakeIdWorker idWorker) {
        this.repository = repository;
        this.idWorker = idWorker;
    }

    public PageResult<UserDto> searchUsers(@NonNull UserQuery userQuery, @NonNull Pageable pageable) {
        final Page<User> searchResult = repository.findAll(querySpecification(userQuery),
                PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                userConverter.convert(searchResult.getContent()));
    }

    public List<UserDto> getUsers() {

        return userConverter.convert(repository.findAll());
    }

    public UserDto getUser(Long id) {
        return userConverter.convert(requirePresent(repository.findById(id)));
    }

    @Transactional(rollbackOn = Exception.class)
    public UserDto addUser(UserParam userParam) {

        final User user = new User();
        user.setId(idWorker.nextId());
        user.setName(userParam.getName());
        user.setAge(userParam.getAge());
        user.setAddress(userParam.getAddress());
        user.setAccount(userParam.getAccount());
        user.setPassword(userParam.getPassword());
        user.setTelphone(userParam.getTelphone());
        user.setQq(userParam.getQq());
        user.setWeixin(userParam.getWeixin());
        user.setEmail(userParam.getEmail());
        user.setSex(userParam.getSex());

        return userConverter.convert(repository.save(user));
    }

    @Transactional(rollbackOn = Exception.class)
    public UserDto editUser(Long id, UserParam userParam) {
        final User user = requirePresent(repository.findById(id));

        user.setName(userParam.getName());
        user.setAge(userParam.getAge());
        user.setAddress(userParam.getAddress());
        user.setAccount(userParam.getAccount());
        user.setPassword(userParam.getPassword());
        user.setTelphone(userParam.getTelphone());
        user.setQq(userParam.getQq());
        user.setWeixin(userParam.getWeixin());
        user.setEmail(userParam.getEmail());
        user.setSex(userParam.getSex());

        return userConverter.convert(repository.save(user));
    }

    @Transactional(rollbackOn = Exception.class)
    public void removeUser(long id) {
        repository.deleteById(id);
    }

}
