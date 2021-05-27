package com.eason.membership.account.application;

import com.cartisan.dtos.PageResult;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.cartisan.repositories.ConditionSpecifications.querySpecification;
import static com.cartisan.utils.AssertionUtil.requirePresent;


/**
 * @author colin
 */
@Service
@Slf4j
public class UserAppService {
    private final RegisterService registerService;
    private final AssignService assignService;
    private final ChangePasswordService changePasswordService;
    private final LoginService loginService;
    private final UserRepository repository;
    private final UserConverter userConverter = UserConverter.CONVERTER;
    private final UserDetailConverter userDetailConverter = UserDetailConverter.CONVERTER;

    public UserAppService(RegisterService registerService,
                          AssignService assignService,
                          ChangePasswordService changePasswordService,
                          LoginService loginService,
                          UserRepository repository) {
        this.registerService = registerService;
        this.assignService = assignService;
        this.changePasswordService = changePasswordService;
        this.loginService = loginService;
        this.repository = repository;
    }

    public PageResult<UserDto> searchUsers(@NonNull UserQuery userQuery, @NonNull Pageable pageable) {
        final Page<User> searchResult = repository.findAll(querySpecification(userQuery), pageable);

        return new PageResult<>(searchResult.getTotalElements(), searchResult.getTotalPages(),
                userConverter.convert(searchResult.getContent()));
    }

    public UserDetailDto getUser(Long id) {
        return userDetailConverter.convert(requirePresent(repository.findById(id)));
    }


    @Transactional(rollbackOn = Exception.class)
    public UserDetailDto createAccount(CreateAccountCommand command) {
        final User user = registerService.register(
                command.getUsername(), command.getPhone(), command.getEmail(), command.getRealName());

        assignService.assignRoles(user, command.getRoleIds());
        assignService.assignOrganization(user, command.getOrganizationId());

        repository.save(user);
        return userDetailConverter.convert(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void assignRoles(Long userId, AssignRolesCommand command) {
        final User user = requirePresent(repository.findById(userId));
        assignService.assignRoles(user, command.getRoleIds());

        repository.save(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void assignOrganization(Long userId, AssignOrganizationsCommand command) {
        final User user = requirePresent(repository.findById(userId));
        assignService.assignOrganization(user, command.getOrganizationId());

        repository.save(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void disable(Long userId) {
        final User user = requirePresent(repository.findById(userId));

        user.disable();

        repository.save(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void enable(Long userId) {
        final User user = requirePresent(repository.findById(userId));

        user.enable();

        repository.save(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void resetPassword(Long userId) {
        final User user = requirePresent(repository.findById(userId));

        changePasswordService.resetPassword(user);

        loginService.logoutByUsername(user.getUsername());

        repository.save(user);
    }
}
