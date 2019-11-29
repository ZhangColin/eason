package com.eason.system.repositories;


import com.cartisan.repositories.BaseRepository;
import com.eason.system.domains.Department;

/**
 * @author colin
 */
public interface DepartmentRepository extends BaseRepository<Department, Long> {
    boolean existsByParentIdAndName(Long parentId, String name);
    boolean existsByParentIdAndNameAndIdNot(Long parentId, String name, Long departmentId);

    boolean existsByParentId(Long parentId);
}
