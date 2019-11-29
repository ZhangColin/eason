package com.eason.system.repositories;

import com.cartisan.repositories.BaseRepository;
import com.eason.system.domains.Permission;

/**
 * @author colin
 */
public interface PermissionRepository extends BaseRepository<Permission, Long> {
    boolean existsByParentIdAndName(Long parentId, String name);
    boolean existsByParentIdAndNameAndIdNot(Long parentId, String name, Long departmentId);

    boolean existsByParentId(Long parentId);
}
