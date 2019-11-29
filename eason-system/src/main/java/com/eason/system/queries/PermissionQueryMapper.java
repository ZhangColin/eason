package com.eason.system.queries;

import com.eason.system.dtos.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author colin
 */
public interface PermissionQueryMapper {
    List<TreeNode> getPermissionTree();

    List<String> getPermissionCodesByRoleCodes(@Param("roleCodes") List<String> roleCodes);
}
