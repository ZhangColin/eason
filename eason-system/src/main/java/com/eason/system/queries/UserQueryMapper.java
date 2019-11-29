package com.eason.system.queries;

/**
 * @author colin
 */
public interface UserQueryMapper {
    Boolean existsUserInDepartment(Long departmentId);
}
