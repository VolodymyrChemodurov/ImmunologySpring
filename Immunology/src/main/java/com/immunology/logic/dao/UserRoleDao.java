package com.immunology.logic.dao;

import com.immunology.logic.utils.enums.UserRoles;
import com.immunology.model.Role;

public interface UserRoleDao {

	Role findByUserRole(UserRoles userRole);
}
