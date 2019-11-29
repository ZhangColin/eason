package com.eason.system.queries;

import com.eason.system.dtos.TreeNode;

import java.util.List;

/**
 * @author colin
 */
public interface DepartmentQueryMapper {
    List<TreeNode> getDepartmentTreeNodes();
}
